/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aleclownes.asciiweatherwatchface;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.wearable.watchface.CanvasWatchFaceService;
import android.support.wearable.watchface.WatchFaceService;
import android.support.wearable.watchface.WatchFaceStyle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowInsets;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Digital watch face with seconds. In ambient mode, the seconds aren't displayed. On devices with
 * low-bit ambient mode, the text is drawn without anti-aliasing in ambient mode.
 */
public class ASCIIWeatherWatchface extends CanvasWatchFaceService implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        DataApi.DataListener{

    private static final String TAG = "ASCIIWeatherWatchface";

    private static final Typeface NORMAL_TYPEFACE =
            Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL);

    /**
     * Update rate in milliseconds for interactive mode. We update once a second since seconds are
     * displayed in interactive mode.
     */
    private static final long INTERACTIVE_UPDATE_RATE_MS = TimeUnit.SECONDS.toMillis(1);

    /**
     * Handler message id for updating the time periodically in interactive mode.
     */
    private static final int MSG_UPDATE_TIME = 0;

    JSONObject weatherData;

    WeatherFormatter.DisplayType displayType = WeatherFormatter.DisplayType.CURRENT;

    GoogleApiClient mGoogleApiClient;

    Node mNode;

    private static final int REQUEST_PERIOD = 60*5;//5 minutes

    private static final String WEATHER_DATA_MESSAGE_PATH = "/weather_data";
    private static final String WEATHER_DATA_KEY = "json";

    @Override
    public void onCreate() {
        super.onCreate();
        mGoogleApiClient = new GoogleApiClient.Builder(ASCIIWeatherWatchface.this)
                .addConnectionCallbacks(ASCIIWeatherWatchface.this)
                .addOnConnectionFailedListener(ASCIIWeatherWatchface.this)
                .addApi(Wearable.API)
                .build();
    }

    /*
        * Resolve the node = the connected device to send the message to
        */
    private void resolveNode() {
        Log.v(TAG, "trying to resolve nodes");
        Wearable.NodeApi.getConnectedNodes(mGoogleApiClient).setResultCallback(new ResultCallback<NodeApi.GetConnectedNodesResult>() {
            @Override
            public void onResult(NodeApi.GetConnectedNodesResult nodes) {
                for (Node node : nodes.getNodes()) {
                    if (node.isNearby()){
                        mNode = node;
                        break;
                    }
                }
            }
        });
    }

    /**
     * Send message to mobile handheld
     * @return boolean of whether or not the request was able to be made
     */
    private boolean requestWeatherData() {
        Log.v(TAG, "requesting weather data");
        if (mNode != null && mGoogleApiClient.isConnected()) {
            Log.v(TAG, "node and client are not null, requesting weather data");
            Wearable.MessageApi.sendMessage(
                    mGoogleApiClient, mNode.getId(), WEATHER_DATA_MESSAGE_PATH, null).setResultCallback(

                    new ResultCallback<MessageApi.SendMessageResult>() {
                        @Override
                        public void onResult(MessageApi.SendMessageResult sendMessageResult) {

                            if (!sendMessageResult.getStatus().isSuccess()) {
                                Log.e(TAG, "Failed to send message with status code: "
                                        + sendMessageResult.getStatus().getStatusCode());
                                Toast.makeText(ASCIIWeatherWatchface.this, "failed to send message", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            );
            resolveNode();
            return true;
        }else{
            if (!mGoogleApiClient.isConnected()){
                mGoogleApiClient.connect();
            }
            //Update connected node
            resolveNode();
            return false;
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Wearable.DataApi.addListener(mGoogleApiClient, this);
        Uri uri = Uri.parse("wear://*"+WEATHER_DATA_MESSAGE_PATH);
        Wearable.DataApi.getDataItems(mGoogleApiClient, uri)
                .setResultCallback(new ResultCallback<DataItemBuffer>() {
                    @Override
                    public void onResult(@NonNull DataItemBuffer dataItems) {
                        if (dataItems.getStatus().isSuccess()){
                            if (dataItems.getCount() > 0){
                                DataItem item = dataItems.get(0);
                                DataMap dataMap = DataMapItem.fromDataItem(item).getDataMap();
                                try {
                                    weatherData = new JSONObject(dataMap.getString(WEATHER_DATA_KEY));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    weatherData = StubData.getStubData();
                                }
                            }
                            else{
                                weatherData = StubData.getStubData();
                            }
                            resolveNode();
                        }
                        dataItems.release();
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Wearable.DataApi.removeListener(mGoogleApiClient, this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        //Improve your code
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        //Improve your code
        Toast.makeText(this, "connection failed", Toast.LENGTH_SHORT);
    }

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        for (DataEvent event : dataEvents) {
            if (event.getType() == DataEvent.TYPE_CHANGED) {
                // DataItem changed
                DataItem item = event.getDataItem();
                if (item.getUri().getPath().compareTo(WEATHER_DATA_MESSAGE_PATH) == 0) {
                    DataMap dataMap = DataMapItem.fromDataItem(item).getDataMap();
                    try {
                        weatherData = new JSONObject(dataMap.getString(WEATHER_DATA_KEY));
                    } catch (JSONException e) {
                        weatherData = StubData.getStubData();
                    }
                }
            }
        }
    }

    @Override
    public Engine onCreateEngine() {
        return new Engine();
    }

    private class Engine extends CanvasWatchFaceService.Engine {
        final Handler mUpdateTimeHandler = new EngineHandler(this);

        final BroadcastReceiver mTimeZoneReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                mCalendar.setTimeZone(TimeZone.getDefault());
                invalidate();
            }
        };
        boolean mRegisteredTimeZoneReceiver = false;

        Paint mBackgroundPaint;
        Paint mTextPaint;

        boolean mAmbient;
        Calendar mCalendar;

        float mXOffset;
        float mYOffset;

        /**
         * Whether the display supports fewer bits for each color in ambient mode. When true, we
         * disable anti-aliasing in ambient mode.
         */
        boolean mLowBitAmbient;

        @Override
        public void onCreate(SurfaceHolder holder) {
            super.onCreate(holder);

            setWatchFaceStyle(new WatchFaceStyle.Builder(ASCIIWeatherWatchface.this)
                    .setCardPeekMode(WatchFaceStyle.PEEK_MODE_SHORT)
                    .setBackgroundVisibility(WatchFaceStyle.BACKGROUND_VISIBILITY_INTERRUPTIVE)
                    .setAmbientPeekMode(WatchFaceStyle.AMBIENT_PEEK_MODE_HIDDEN)
                    .setShowSystemUiTime(false)
                    .setAcceptsTapEvents(true)
                    .build());
            Resources resources = ASCIIWeatherWatchface.this.getResources();
            mYOffset = resources.getDimension(R.dimen.digital_y_offset);

            mBackgroundPaint = new Paint();
            mBackgroundPaint.setColor(resources.getColor(R.color.background));

            mTextPaint = new Paint();
            mTextPaint = createTextPaint(resources.getColor(R.color.digital_text));
            mTextPaint.setTypeface(Typeface.MONOSPACE);

            mCalendar = Calendar.getInstance();

            mGoogleApiClient.connect();
        }

        @Override
        public void onDestroy() {
            mUpdateTimeHandler.removeMessages(MSG_UPDATE_TIME);
            super.onDestroy();
        }

        private Paint createTextPaint(int textColor) {
            Paint paint = new Paint();
            paint.setColor(textColor);
            paint.setTypeface(NORMAL_TYPEFACE);
            return paint;
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            super.onVisibilityChanged(visible);

            if (visible) {
                registerReceiver();

                // Update time zone in case it changed while we weren't visible.
                mCalendar.setTimeZone(TimeZone.getDefault());
                invalidate();
            } else {
                unregisterReceiver();
            }

            // Whether the timer should be running depends on whether we're visible (as well as
            // whether we're in ambient mode), so we may need to start or stop the timer.
            updateTimer();
        }

        private void registerReceiver() {
            if (mRegisteredTimeZoneReceiver) {
                return;
            }
            mRegisteredTimeZoneReceiver = true;
            IntentFilter filter = new IntentFilter(Intent.ACTION_TIMEZONE_CHANGED);
            ASCIIWeatherWatchface.this.registerReceiver(mTimeZoneReceiver, filter);
        }

        private void unregisterReceiver() {
            if (!mRegisteredTimeZoneReceiver) {
                return;
            }
            mRegisteredTimeZoneReceiver = false;
            ASCIIWeatherWatchface.this.unregisterReceiver(mTimeZoneReceiver);
        }

        @Override
        public void onApplyWindowInsets(WindowInsets insets) {
            super.onApplyWindowInsets(insets);

            // Load resources that have alternate values for round watches.
            Resources resources = ASCIIWeatherWatchface.this.getResources();
            boolean isRound = insets.isRound();
            mXOffset = resources.getDimension(isRound
                    ? R.dimen.digital_x_offset_round : R.dimen.digital_x_offset);
            float textSize = resources.getDimension(isRound
                    ? R.dimen.digital_text_size_round : R.dimen.digital_text_size);

            mTextPaint.setTextSize(textSize);
        }

        @Override
        public void onPropertiesChanged(Bundle properties) {
            super.onPropertiesChanged(properties);
            mLowBitAmbient = properties.getBoolean(PROPERTY_LOW_BIT_AMBIENT, false);
        }

        @Override
        public void onTimeTick() {
            super.onTimeTick();
            invalidate();
        }

        @Override
        public void onAmbientModeChanged(boolean inAmbientMode) {
            super.onAmbientModeChanged(inAmbientMode);
            if (mAmbient != inAmbientMode) {
                mAmbient = inAmbientMode;
                invalidate();
            }

            // Whether the timer should be running depends on whether we're visible (as well as
            // whether we're in ambient mode), so we may need to start or stop the timer.
            updateTimer();
        }

        @Override
        public void onTapCommand(@TapType int tapType, int x, int y, long eventTime){
            switch (tapType){
                case WatchFaceService.TAP_TYPE_TAP:
                    if (displayType.equals(WeatherFormatter.DisplayType.CURRENT)){
                        displayType = WeatherFormatter.DisplayType.DETAIL;
                    }
                    else {
                        displayType = WeatherFormatter.DisplayType.CURRENT;
                    }
                    break;
                default:
                    super.onTapCommand(tapType, x, y, eventTime);
            }
        }

        @Override
        public void onDraw(Canvas canvas, Rect bounds) {
            if (com.aleclownes.asciiweatherwatchface.BuildConfig.DEBUG){
                if (weatherData == null){
                    weatherData = StubData.getStubData();
                }
                else{
                    JSONObject currently = weatherData.optJSONObject("currently");
                    long time = System.currentTimeMillis();
                    List<String> icons = new ArrayList<>(WeatherFormatter.iconCodes.keySet());
                    int index = (int)((time/1000)%icons.size());
                    try {
                        currently.put("icon", icons.get(index));
                        currently.put("summary", icons.get(index));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            else{
                //Find out if new json needs to be requested
                if (weatherData != null){
                    JSONObject currently = weatherData.optJSONObject("currently");
                    int repeats = weatherData.optInt("repeats");
                    if (currently != null) {
                        //time is in seconds
                        long time = currently.optLong("time");
                        if (time == 0) {
                            Toast.makeText(ASCIIWeatherWatchface.this, "Time was 0", Toast.LENGTH_SHORT);
                        } else {
                            //now is in seconds
                            long now = new Date().getTime()/1000;
                            if (now - time > REQUEST_PERIOD) {
                                boolean success = requestWeatherData();
                                try {
                                    if (success) {
                                        //If the request was able to be made
                                        //set the time to current time
                                        currently.put("time", now);
                                        weatherData.put("repeats", repeats+1);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
            // Draw the background.
            if (isInAmbientMode()) {
                canvas.drawColor(Color.BLACK);
            } else {
                canvas.drawRect(0, 0, bounds.width(), bounds.height(), mBackgroundPaint);
            }

            // Draw H:MM in ambient mode or H:MM:SS in interactive mode.
            long now = System.currentTimeMillis();
            mCalendar.setTimeInMillis(now);
            int hour = mCalendar.get(Calendar.HOUR);
            if (hour == 0){
                hour = 12;
            }

            String timeText = mAmbient
                    ? String.format("%d:%02d", hour,
                            mCalendar.get(Calendar.MINUTE))
                    : String.format("%d:%02d:%02d", hour,
                            mCalendar.get(Calendar.MINUTE), mCalendar.get(Calendar.SECOND));
            String am_pm = mCalendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
            timeText += " " + am_pm;
            int month = mCalendar.get(Calendar.MONTH)+1;
            String dateText = String.format("%d/%d/%d", month,
                    mCalendar.get(Calendar.DAY_OF_MONTH), mCalendar.get(Calendar.YEAR));
            int sizeDiff = WeatherFormatter.TOTAL_WIDTH -(dateText.length()+timeText.length());
            for (int i = 0; i < sizeDiff; i++){
                timeText += " ";
            }

            float subYOffset = mYOffset;
            List<List<ColorText>> lines = WeatherFormatter.createDisplay(weatherData, displayType);
            for (List<ColorText> line : lines){
                float subXOffset = mXOffset;
                for (ColorText colorText : line){
                    if (!mAmbient){
                        mTextPaint.setColor(colorText.getColor());
                    }
                    else{
                        mTextPaint.setColor(Color.WHITE);
                    }
                    canvas.drawText(colorText.getText(), subXOffset, subYOffset, mTextPaint);
                    subXOffset += mTextPaint.measureText(colorText.getText());
                }
                subYOffset += mTextPaint.getTextSize() + 2;
            }
            mTextPaint.setColor(Color.WHITE);
            canvas.drawText(timeText+dateText, mXOffset, subYOffset, mTextPaint);
        }

        private List<List<ColorText>> createStringList(){
            //drawing
            /*
             *             Overcast
             *     .--.    73 - 77 *F
             *  .-(    ).  ↗ 6 – 8 mph
             * (___.__)__) 10:30 PM
             *             0.0 in | 2%
             *------------------------
             * PC    MR    SU    RA       green
             * 84*F  84*F  82*F  75*F     white or yellow or red
             * 09%   21%   89%   05%      blue
             *------------------------
             *11:07:02 PM       7/7/16
             */
            List<List<ColorText>> lines = new ArrayList<>();
            List<ColorText> line0 = new ArrayList<>();
            line0.add(new ColorText(Color.WHITE, "             Overcast"));
            lines.add(line0);
            List<ColorText> line1 = new ArrayList<>();
            line1.add(new ColorText(Color.WHITE, "     .--.    73 - 77 *F"));
            lines.add(line1);
            List<ColorText> line2 = new ArrayList<>();
            line2.add(new ColorText(Color.WHITE, "  .-(    ).  ↗ 6 – 8 mph"));
            lines.add(line2);
            List<ColorText> line3 = new ArrayList<>();
            line3.add(new ColorText(Color.WHITE, " (___.__)__) 10:30 PM"));
            lines.add(line3);
            List<ColorText> line4 = new ArrayList<>();
            line4.add(new ColorText(Color.WHITE, "             0.0 in | 2%"));
            lines.add(line4);
            List<ColorText> line5 = new ArrayList<>();
            line5.add(new ColorText(Color.WHITE, "------------------------"));
            lines.add(line5);
            List<ColorText> line6 = new ArrayList<>();
            line6.add(new ColorText(Color.GREEN, " PC    MR    SU    RA   "));
            lines.add(line6);
            List<ColorText> line7 = new ArrayList<>();
            line7.add(new ColorText(Color.YELLOW, " 84*F  84*F  82*F  "));
            line7.add(new ColorText(Color.RED, "75*F "));
            lines.add(line7);
            List<ColorText> line8 = new ArrayList<>();
            line8.add(new ColorText(Color.BLUE, " 09%   21%   89%   05%  "));
            lines.add(line8);
            List<ColorText> line9 = new ArrayList<>();
            line9.add(new ColorText(Color.WHITE, "------------------------"));
            lines.add(line9);
            List<ColorText> line10 = new ArrayList<>();
            line10.add(new ColorText(Color.WHITE, "11:07:02 PM       7/7/14"));
            lines.add(line10);
            return lines;
        }

        /**
         * Starts the {@link #mUpdateTimeHandler} timer if it should be running and isn't currently
         * or stops it if it shouldn't be running but currently is.
         */
        private void updateTimer() {
            mUpdateTimeHandler.removeMessages(MSG_UPDATE_TIME);
            if (shouldTimerBeRunning()) {
                mUpdateTimeHandler.sendEmptyMessage(MSG_UPDATE_TIME);
            }
        }

        /**
         * Returns whether the {@link #mUpdateTimeHandler} timer should be running. The timer should
         * only run when we're visible and in interactive mode.
         */
        private boolean shouldTimerBeRunning() {
            return isVisible() && !isInAmbientMode();
        }

        /**
         * Handle updating the time periodically in interactive mode.
         */
        private void handleUpdateTimeMessage() {
            invalidate();
            if (shouldTimerBeRunning()) {
                long timeMs = System.currentTimeMillis();
                long delayMs = INTERACTIVE_UPDATE_RATE_MS
                        - (timeMs % INTERACTIVE_UPDATE_RATE_MS);
                mUpdateTimeHandler.sendEmptyMessageDelayed(MSG_UPDATE_TIME, delayMs);
            }
        }
    }

    private static class EngineHandler extends Handler {
        private final WeakReference<ASCIIWeatherWatchface.Engine> mWeakReference;

        public EngineHandler(ASCIIWeatherWatchface.Engine reference) {
            mWeakReference = new WeakReference<>(reference);
        }

        @Override
        public void handleMessage(Message msg) {
            ASCIIWeatherWatchface.Engine engine = mWeakReference.get();
            if (engine != null) {
                switch (msg.what) {
                    case MSG_UPDATE_TIME:
                        engine.handleUpdateTimeMessage();
                        break;
                }
            }
        }
    }
}
