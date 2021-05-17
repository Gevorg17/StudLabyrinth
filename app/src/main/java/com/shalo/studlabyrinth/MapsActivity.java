package com.shalo.studlabyrinth;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.os.Parcelable;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.shalo.studlabyrinth.models.Point;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Point> points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Bundle arguments = getIntent().getExtras();
        points = (List<Point>) (Parcelable) arguments.get("points");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        PolylineOptions line = new PolylineOptions();

        for (Point point : points)
            line.add(new LatLng(point.getX(),point.getY()));

        LatLng endPoint = line.getPoints().get(line.getPoints().size() - 1);

        mMap.addMarker(new MarkerOptions().position(endPoint).title("Endpoint"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(endPoint));
        mMap.addPolyline(line);
    }
}