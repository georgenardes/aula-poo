package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by 6473091 on 10/12/2018.
 */

public class LocationGPS implements LocationListener {

    Context context;

    public LocationGPS(Context c){
        context = c;
    }

    public Location getLocation(){

        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            return null;
        }
        LocationManager lc = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        boolean isEnable = lc.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(isEnable){
            lc.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, this);
            Location location = lc.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return location;
        }else{
            Toast.makeText(context,"GPS desativado!", Toast.LENGTH_LONG).show();
        }
        return null;

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}

