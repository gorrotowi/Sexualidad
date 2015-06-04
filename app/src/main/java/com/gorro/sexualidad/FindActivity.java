package com.gorro.sexualidad;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class FindActivity extends ActionBarActivity implements LocationListener {

    LocationManager locationManager;
    String provider;

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        map = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);

        try {
            Location location = locationManager.getLastKnownLocation(provider);
            location.getLongitude();
            location.getLatitude();
            onLocationChanged(location);

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(FindActivity.this, "En estos momentos no podemos obtener tu ubicacion, intenta mas tarde", Toast.LENGTH_LONG).show();
        }

        map.setMyLocationEnabled(true);
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng localizacionLtLn = new LatLng(19.432675, -99.16300443);
        updateMapCamera(localizacionLtLn);

    }

    @Override
    public void onLocationChanged(Location location) {

        Double latitude, longitud;
        latitude = (double) (location.getLatitude());
        longitud = (double) (location.getLongitude());

        LatLng localizacion = new LatLng(latitude, longitud);

        updateMapCamera(localizacion);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    private void updateMapCamera(LatLng localizacion) {

        CameraPosition camPos = new CameraPosition.Builder()
                .target(localizacion).zoom(15).tilt(45).build();
        CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(camPos);
        map.animateCamera(camUpd);

    }

    public void printSexualStores() {
        map.clear();
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.6862937, -99.0217066)).
                title("La Vida en Rosa").snippet("Mexico - Pachuca\n" +
                "Ozumbilla\n" +
                "55760 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
    }

    public void printClinics() {
        map.clear();
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Zona XPlanta Alta").snippet("5 de May. 12\nTecamac Centro\n55740 Tecámac de Felipe Villanueva, Méx."));
    }

}
