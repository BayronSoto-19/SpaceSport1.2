package com.example.spacesport1.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.spacesport1.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaBox extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_box);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        myMap = googleMap;

        LatLng ubicacion= new LatLng(-30.604550361888148, -71.20193029285396);
        myMap.addMarker(new MarkerOptions().position(ubicacion).title("Club Boxing"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        myMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        LatLng ubicacion2= new LatLng(-30.60363439195045, -71.19735230704319);
        myMap.addMarker(new MarkerOptions().position(ubicacion2).title("On Box Club"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion2));
        myMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setCompassEnabled(true);

        myMap.getUiSettings().setZoomControlsEnabled(false);
        myMap.getUiSettings().setScrollGesturesEnabled(false);

    }
}