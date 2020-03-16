package com.madapas.mappinfirebaseproject;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Double.parseDouble;

public class Repository {

    private static final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static ArrayList<Pin> pins = new ArrayList<>();
    private static final String key = "pins";
    public static GoogleMap mMap;

    static {
        //listener has to start first
        startPinListener();
    }

    public static void startPinListener() {
        //changes in the db
        db.collection(key).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot values, @Nullable FirebaseFirestoreException e) {
                Repository.pins.clear();
                for (DocumentSnapshot snap : values.getDocuments()) {
                    String lat = snap.get("lat").toString();
                    String lng = snap.get("long").toString();
                    double lat1 = parseDouble(lat);
                    double lng1 = parseDouble(lng);
                    LatLng latLng = new LatLng(lat1, lng1);
                    Repository.pins.add(new Pin(latLng, snap.get("title").toString(), snap.getId()));
                }
                addMarkers();
            }
        });

    }

    public static void addNewPin(String title, LatLng latLng) {
        DocumentReference docRef = db.collection(key).document();

        double lat = latLng.latitude;
        double lng = latLng.longitude;
        //a map of a new document
        Map<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("lat", lat);
        map.put("long", lng);

        //adding pin to the db
        docRef.set(map);
    }

    public static void addMarkers() {
        for (Pin pin : Repository.pins) {
            LatLng position = pin.getLatLng();
            String title = pin.getTitle();
            mMap.addMarker(new MarkerOptions().position(position).title(title));
        }
    }


}