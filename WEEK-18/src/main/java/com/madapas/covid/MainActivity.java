package com.madapas.covid;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity
        extends AppCompatActivity {

    // Create the object of TextView
    TextView cases, recovered,
            critical, active,
            todayCases, totalDeaths,
            todayDeaths,
            affectedCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link those objects with their respective id's
        cases
                = findViewById(R.id.cases);
        recovered
                = findViewById(R.id.recovered);
        critical
                = findViewById(R.id.critical);
        active
                = findViewById(R.id.active);
        todayCases
                = findViewById(R.id.todayCases);
        totalDeaths
                = findViewById(R.id.totalDeaths);
        todayDeaths
                = findViewById(R.id.todayDeaths);
        affectedCountries
                = findViewById(R.id.affectedCountries);

        fetchData();
    }

    private void fetchData()
    {

        // Create a String request
        // using Volley Library
        String url = "https://corona.lmao.ninja/v2/all";

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        // Handle the JSON object
                        // inside try and catch
                        try {

                            // Creating object of JSONObject
                            JSONObject jsonObject
                                    = new JSONObject(
                                    response);

                            // Set the data in text view
                            // which are available in JSON format
                            // Note that the parameter inside

                            cases.setText(
                                    jsonObject.getString(
                                            "cases"));
                            recovered.setText(
                                    jsonObject.getString(
                                            "recovered"));
                            critical.setText(
                                    jsonObject.getString(
                                            "critical"));
                            active.setText(
                                    jsonObject.getString(
                                            "active"));
                            todayCases.setText(
                                    jsonObject.getString(
                                            "todayCases"));
                            totalDeaths.setText(
                                    jsonObject.getString(
                                            "deaths"));
                            todayDeaths.setText(
                                    jsonObject.getString(
                                            "todayDeaths"));
                            affectedCountries.setText(
                                    jsonObject.getString(
                                            "affectedCountries"));
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(
                                MainActivity.this,
                                error.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}