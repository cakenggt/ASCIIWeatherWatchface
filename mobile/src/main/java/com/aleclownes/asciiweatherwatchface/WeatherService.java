package com.aleclownes.asciiweatherwatchface;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by alownes on 7/8/2016.
 */

public class WeatherService extends WearableListenerService {

    private final String TAG = "WeatherService";
    private GoogleApiClient mGoogleApiClient;
    private static final String WEATHER_DATA_MESSAGE_PATH = "/weather_data";
    private static final String WEATHER_DATA_KEY = "json";
    private RequestQueue queue;
    private String url = "https://api.forecast.io/forecast/";
    private String API_KEY = BuildConfig.API_KEY;
    private final int MY_PERMISSIONS_FINE_LOCATION = 1;
    static final int GET_LOCATION_REQUEST = 2;

    @Override
    public void onCreate() {
        super.onCreate();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .build();
        mGoogleApiClient.connect();
        queue = Volley.newRequestQueue(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startID) {
        Log.v(TAG, "onStartCommand");
        getForecast(new ResponseListener(), new ErrorListener());
        return START_STICKY;
    }

    private void sendWeatherData(String data){
        Log.v(TAG, "Sending weather data");
        PutDataMapRequest putDataMapReq = PutDataMapRequest.create(WEATHER_DATA_MESSAGE_PATH);
        putDataMapReq.getDataMap().putString(WEATHER_DATA_KEY, data);
        PutDataRequest putDataReq = putDataMapReq.asPutDataRequest();
        PendingResult<DataApi.DataItemResult> pendingResult =
                Wearable.DataApi.putDataItem(mGoogleApiClient, putDataReq);
    }

    private void getForecast(Response.Listener<String> responseListener,
                               Response.ErrorListener errorListener){
        LocationManager locationManager = (LocationManager)
                this.getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED){
            Log.v(TAG, "Location permission granted");
            Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (loc != null){
                getForecast(loc.getLatitude(),
                        loc.getLongitude(), responseListener,
                        errorListener);
            }
        }
        else{
            Log.v(TAG, "Starting location permission activity");
            Intent locationPermissionActivityIntent = new Intent(this, LocationPermissionActivity.class);
            startActivity(locationPermissionActivityIntent);
        }
    }

    private void getForecast(double latitude, double longitude, Response.Listener<String> responseListener,
                             Response.ErrorListener errorListener){
        Log.v(TAG, "getting forecast");
        String totalUrl = url + API_KEY + "/" + latitude + "," + longitude;
        StringRequest stringRequest = new StringRequest
                (Request.Method.GET, totalUrl, responseListener, errorListener);
        queue.add(stringRequest);
    }

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {

        /*
         * Receive the message from wear
         */
        Log.v(TAG, "Got weather message");
        if (messageEvent.getPath().equals(WEATHER_DATA_MESSAGE_PATH)) {
            getForecast(new ResponseListener(), new ErrorListener());
        }
    }

    private class ResponseListener implements Response.Listener<String> {
        @Override
        public void onResponse(String response) {
            Log.v(TAG, "Weather data received");
            sendWeatherData(response);
        }
    }

    private class ErrorListener implements Response.ErrorListener {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.v(TAG, "ErrorResponse " + error.toString());
        }
    }
}
