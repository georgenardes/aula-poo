package com.george.de.borba.nardes.a05_controle_abastecimento;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class ShowMap extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ArrayList<Abastecer> listaCoordenadas;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;

        this.listaCoordenadas = AbastecerDao.getLista(this.getApplicationContext());

        //For para cada abastecimento
        for (int i = 0; i < listaCoordenadas.size(); i++) {
            //Se for igual a 90 deu ruim em algum lugar, entao nao mostra
            if (listaCoordenadas.get(i).getLat() != 90) {
                //Coloca um marcador na coordenada
                this.mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(listaCoordenadas.get(i).getLat(), listaCoordenadas.get(i).getLog()))
                        .title(listaCoordenadas.get(i).getPosto())
                        .snippet(listaCoordenadas.get(i).getData()));

                //Move a camera pra coordenada
                this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(listaCoordenadas.get(i).getLat(), listaCoordenadas.get(i).getLog()), 15f));
            }
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);

        initMap();
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(ShowMap.this);
    }
}