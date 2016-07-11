package com.aleclownes.asciiweatherwatchface;

import android.widget.Toast;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by alownes on 7/8/2016.
 */

public class WearableWeatherService extends WearableListenerService {

    private static final String TAG = "WearableListenerService";
    private static final String WEATHER_DATA_MESSAGE_PATH = "/weather_data";
    private static final String WEATHER_DATA_KEY = "json";
    public static JSONObject weatherData;

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        Toast.makeText(this, "data changed", Toast.LENGTH_SHORT).show();
        for (DataEvent event : dataEvents) {
            if (event.getType() == DataEvent.TYPE_CHANGED) {
                // DataItem changed
                DataItem item = event.getDataItem();
                if (item.getUri().getPath().compareTo(WEATHER_DATA_MESSAGE_PATH) == 0) {
                    DataMap dataMap = DataMapItem.fromDataItem(item).getDataMap();
                    try {
                        weatherData = new JSONObject(dataMap.getString(WEATHER_DATA_KEY));
                    } catch (JSONException e) {
                        weatherData = null;
                    }
                }
            }
        }
    }
}
