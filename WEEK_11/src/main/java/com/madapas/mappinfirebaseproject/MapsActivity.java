package com.madapas.mappinfirebaseproject;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        builder = new AlertDialog.Builder(this);
        // Obtain here the SupportMapFragment and get a notification when the map is ready
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Repository.mMap = mMap;
        Log.i("all", "map is loaded right");
        addDefaultPlaces();
        addPin();
    }

    private void addPin() {
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(final LatLng latLng) {
                Log.i("all", "map was clicked");

                final EditText input = new EditText(MapsActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setTitle("Set title of pin")
                        .setView(input)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String title = input.getText().toString();
                                Repository.addNewPin(title, latLng);
                                mMap.addMarker(new MarkerOptions().position(latLng).title(title));
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();

            }
        });
    }

    private void addDefaultPlaces() {
        LatLng london = new LatLng(51.5285582, -0.2416815);
        mMap.addMarker(new MarkerOptions().position(london).title("Marker in London"));

        LatLng pizzeria = new LatLng(55.6510606, 12.6098122);
        mMap.addMarker(new MarkerOptions().position(pizzeria).title("Pizza!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pizzeria, 12));

        LatLng venue = new LatLng(55.657048, 12.5048583);
        mMap.addMarker(new MarkerOptions().position(venue).title("Cph"));
    }


}