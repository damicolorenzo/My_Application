package com.example.myapplication.service;

import android.Manifest;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

public class LocationHelper {

    public static void start(Context context, LocationListener listener) {
        int fineLocation = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
        int coarseLocation = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (fineLocation == PackageManager.PERMISSION_GRANTED && coarseLocation == PackageManager.PERMISSION_GRANTED) {
            LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
        }

    }

    public static void stop(Context context) {
        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }
}
