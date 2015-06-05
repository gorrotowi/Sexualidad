package com.gorro.sexualidad;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.melnykov.fab.FloatingActionButton;


public class FindActivity extends ActionBarActivity implements LocationListener {

    LocationManager locationManager;
    String provider;

    FloatingActionButton stores, clinics;

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        stores = (FloatingActionButton) findViewById(R.id.fabStores);
        clinics = (FloatingActionButton) findViewById(R.id.fabClinics);

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

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                new MaterialDialog.Builder(FindActivity.this)
                        .title(marker.getTitle())
                        .content(marker.getSnippet())
                        .positiveText("ok")
                        .build()
                        .show();
            }
        });

        LatLng localizacionLtLn = new LatLng(19.432675, -99.16300443);
        updateMapCamera(localizacionLtLn);

        printSexualStores();

        stores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printSexualStores();
            }
        });

        clinics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printClinics();
            }
        });

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
                .target(localizacion).zoom(15).build();
        CameraUpdate camUpd = CameraUpdateFactory.newCameraPosition(camPos);
        map.animateCamera(camUpd);

    }

    public void printSexualStores() {
        map.clear();
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).
                title("Zona XPlanta Alta").snippet("5 de May. 12\n" +
                "Tecamac Centro\n" +
                "55740 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.6862937, -99.0217066)).
                title("La Vida en Rosa").snippet("Mexico - Pachuca\n" +
                "Ozumbilla\n" +
                "55760 Tecámac de Felipe Villanueva, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.6811215, -99.0883112)).
                title("Punto X").snippet("Local A\n" +
                "Blvrd Ojo de Agua Mz.94 Lt.31\n" +
                "55770 Ojo de Agua, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.6837076, -99.12745)).
                title("FANTASEXSHOP").snippet("Cond S\n" +
                "La Isla\n" +
                "54930 Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.6584912, -99.1343164)).
                title("Tentazion Sex Shop").snippet("Avenida Zarzaparrillas Mz 24 Lt 26 Casa 1\n" +
                "55712 Heroes Coacalco, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.6559047, -99.1257334)).
                title("Sex Shop Cachondiux").snippet("Planta Baja\n" +
                "Blvrd Coacalco 307\n" +
                "Villa de Las Flores\n" +
                "55710 Coacalco de Berriozabal, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4578253, -99.2369091)).
                title("TISHA'S SEXSHOP").snippet("Golfo de San Lorenzo # 16 Local C\n" +
                "Colonia Tacuba Delegacion Miguel Hidalgo .d.f.\n" +
                "11410 Ciudad de Mexico"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4594439, -99.2104732)).
                title("Erotika Sex Shop Campo Militar\n").snippet("Av Parque de Chapultepec 87\n" +
                "El Parque\n" +
                "Naucalpan de Juárez, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4562068, -99.1442119)).
                title("SEX SHOP").snippet("Planta alta\n" +
                "Quito 735\n" +
                "Lindavista, Gustavo A. Madero\n" +
                "07300 Ciudad de México, D.F."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.5139057, -98.944459)).
                title("Sex Shop Sensuality").snippet("Local 21\n" +
                "Benito Juárez 321\n" +
                "Centro\n" +
                "56100 Texcoco de Mora, Estado de México"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4315482, -98.9564538)).
                title("Sex Shop Peñón").snippet("Av del Peñon\n" +
                "Mineros (Punta La Zanja)\n" +
                "56334 Chimalhuacán, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3130671, -98.8936901)).title("SEX-SHOP").snippet("Cuauhtémoc 7\n" +
                "Santa Barbara\n" +
                "56530 Ixtapaluca, Estado de México"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.2784762, -98.9489222)).title("Sex Shop Fetich").snippet("Nacional 62\n" +
                "Chalco Centro\n" +
                "56600 Chalco de Díaz Covarrubias, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.2726428, -98.8850642)).title("Erotika").snippet("Piso 2\n" +
                "Avenida Cuauhtémoc 13\n" +
                "Chalco Centro\n" +
                "56600 Chalco de Díaz Covarrubias, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.2700501, -98.9197398)).title("Paraíso").snippet("Local 33\n" +
                "Av Miguel Hidalgo 10\n" +
                "Chalco Centro\n" +
                "56600 Chalco de Díaz Covarrubias, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4261857, -99.0134669)).title("SEX SHOP").snippet("Adolfo López Mateos 625\n" +
                "Benito Juárez\n" +
                "57000 Nezahualcóyotl, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4158245, -99.0402461)).title("SEX - SHOP").snippet("Casi Esquina Av Pantitlan\n" +
                "México 241\n" +
                "México 1ra Secc\n" +
                "57620 Nezahualcóyotl, Méx."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3070325, -99.1205227)).title("Zagues").snippet("Avenida México SN\n" +
                "San Ángel, Álvaro Obregón\n" +
                "01000 Ciudad de México, D.F."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3007479, -99.1789734)).title("Love Planet").snippet("Ahuejotes 12\n" +
                "San Marcos Norte, Xochimilco\n" +
                "16038 Ciudad de Mexico, D.F."));
    }

    public void printClinics() {
        map.clear();
        map.addMarker(new MarkerOptions().position(new LatLng(19.3535963, -99.1789734)).title("Sexóloga").snippet("Av. Miguel Ángel de Quevedo 320\n" +
                "Santa Catarina, Coyoacán\n" +
                "04310 Ciudad de México, D.F.\n" +
                "01 55 5554 0902"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4149191, -99.1789734)).title("Urología y Sexología Integral de México").snippet("Calle de Aguascalientes 28\n" +
                "Roma Sur, Cuauhtémoc\n" +
                "06760 Ciudad de México, D.F.\n" +
                "01 55 5574 9379"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4057715, -99.175463)).title("Inesspa A.C.").snippet("Calle Palenque 55\n" +
                "Narvarte Poniente, Benito Juárez\n" +
                "03020 Ciudad de México, D.F.\n" +
                "inesspa.com  \n" +
                "01 55 5530 2618"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3963401, -99.1743472)).title("Especialidades Médicas Nápoles").snippet("Pennsylvania 209\n" +
                "03810 Benito Juárez, D.F.\n" +
                "01 55 5523 5453"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.407674, -99.1758063)).title("Olivares Sánchez Jorge Antonio ").snippet("Ginecólogo \n" +
                "Quintana Roo 81\n" +
                "Cuauhtémoc\n" +
                "06760 D.F.\n" +
                "01 55 5584 5275\n"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4677913, -99.2170837)).title("UNIDADES MÉDICAS DE LA MUJER\n").snippet("Cto. Interior 1448\n" +
                "Vallejo, Gustavo A. Madero\n" +
                "07870 Ciudad de México, D.F.\n" +
                "01 55 5517 4590"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.377247, -99.133436)).title("Clínica de Colposcopia Fundación Cruz Talonia").snippet("Eje 6 Sur Av. Playa Pie de la Cuesta 18\n" +
                "Iztapalapa\n" +
                "Zacahuitzco\n" +
                "09440 Ciudad de México, D.F.\n" +
                "01 55 5601 4365"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.283081, -99.167425)).title("AMSSAC").snippet("Asociación Mexicana para la Salud Sexual A.C. \n" +
                "Teléfonos.\n" +
                " (55) 5573-3460\n" +
                " (55) 5513-7489\n" +
                "Fax.\n" +
                " (55) 5513-1065\n" +
                "Correo Electrónico\n" +
                "informesamssac@gmail.com"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4090854, -99.1823602)).title("Clínica Especializada Condesa").snippet("General Benjamín Hill 17\n" +
                "Cuauhtémoc\n" +
                "Hipódromo Condesa\n" +
                "06170 Ciudad de México, D.F.\n" +
                "condesadf.mx \n" +
                "55 5515 8311"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.42746, -99.16428)).title("Centro Comunitario de Atención a la Diversidad Sexual").snippet("Génova 30 H Zona Rosa,\n" +
                " 06600 México, D. F."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4426206, -99.1581267)).title("Unidad Especializada para la Atención a Usuarios de la Comunidad LGBTTTI.").snippet("Calle Santa María la Rivera 37\n" +
                "Col. Santa María la Rivera. \n" +
                "Delegación Cuauhtémoc"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4270027, -99.1643029)).title("Unidad Especializada para la Atención a Usuarios de la Comunidad LGBTTTI.").snippet("Calle Génova 30-H \n" +
                "Col. Juárez Zona Rosa.\n" +
                " Delegación Cuauhtémoc C.P. 06600\n" +
                "Tel. 5533-5981, 5633-6726"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3550339, -99.1748205)).title("Cuarta Visitaduría General Especializada en la Comunidad LGBTI Comisión de Derechos Humanos de Distrito Federal").snippet("Tel. 5229-5600 ext. 1514 Directo 5578-1228\n" +
                "Av. Universidad 1449 Col. Florida, Pueblo de \n" +
                "Axotla C.P. 01030"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4591173, -99.1806605)).title("Medica Center Fem Popotla").snippet("Mar Egeo 178 Colonia Popotal\n" +
                " Delegación Miguel Hidalgo, México D.F.\n" +
                "Teléfono: 55 53470659\n" +
                " Lada sin costo: 01 800 822 8221"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4367229, -99.1765169)).title("Ginecea").snippet("Avenida Ejército Nacional 161\n" +
                "Colonia Anzures Delegación Miguel Hidalgo, \n" +
                "Teléfono: 55 5531 1031\n" +
                "Lada sin costo: 01800 890 2727"));
        map.addMarker(new MarkerOptions().position(new LatLng(19.3435931, -99.0395332)).title("Atención cálida ECOFEM Iztapalapa").snippet("Calzada Ermita-Iztapalapa 2720 Colonia Santa \n" +
                "Cruz Meyehualco Delegación Iztapalapa \n" +
                "Teléfono: 55 2608 4516\n" +
                "Celular: 55 5008 0662\n" +
                "Lada sin costo: 01800 8903 317."));
        map.addMarker(new MarkerOptions().position(new LatLng(19.4841934, -99.1836549)).title("Marie Stopes “Clínica Azcapotzalco'").snippet("Avenida 22 de Febrero 345\n" +
                "Colonia Azcapotzalco Centro\n" +
                "Delegación Azcapotzalco, México D.F.\n" +
                " Teléfono: 5555430000\n" +
                " Lada sin costo: 018003009000"));

    }

}
