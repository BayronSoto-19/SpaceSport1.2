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

public class Mapa_Taekwondo extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_taekwondo);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        myMap = googleMap;

        LatLng ubicacion= new LatLng(-30.696843238967208, -70.95737451740072);
        myMap.addMarker(new MarkerOptions().position(ubicacion).title("Monte Sport"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        myMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        LatLng ubicacion2= new LatLng(-30.5852374497787, -71.2007795675652);
        myMap.addMarker(new MarkerOptions().position(ubicacion2).title("Polideportivo, Taekwondo WT Academia municipal"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion2));
        myMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        LatLng ubicacion3= new LatLng(-29.96319992215127, -71.3014712377468);
        myMap.addMarker(new MarkerOptions().position(ubicacion3).title("Choi Yong TaeKwon-Do\n"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion3));
        myMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setCompassEnabled(true);

        myMap.getUiSettings().setZoomControlsEnabled(false);
        myMap.getUiSettings().setScrollGesturesEnabled(false);

        myMap.getUiSettings().setZoomControlsEnabled(false);
        myMap.getUiSettings().setScrollGesturesEnabled(false);

    }
}