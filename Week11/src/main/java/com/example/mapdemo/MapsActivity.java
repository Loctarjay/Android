package com.example.mapdemo;

import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Telephony;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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
        Log.i("all", "Map has been loaded");
        // Add a marker in Sydney and move the camera
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                markerPlaced(latLng);
            }
        });

//        LatLng sydney = new LatLng(55.6761, 12.5683);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private void markerPlaced(final LatLng latLng) {
        final MarkerOptions marker = new MarkerOptions().position(latLng);
        final AlertDialog.Builder alertBox = new AlertDialog.Builder(MapsActivity.this);
        alertBox.setTitle("Enter the title for your marker");
        final EditText input = new EditText(MapsActivity.this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        alertBox.setView(input)

        // Specifying a listener allows you to take an action before dismissing the dialog.
        // The dialog is automatically dismissed when a dialog button is clicked.
            .setPositiveButton("Save title", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Marker current = mMap.addMarker(marker);
                current.setTitle(input.getText().toString());
                current.showInfoWindow();
            }
        })
        // A null listener allows the button to dismiss the dialog and take no further action.
        .setNegativeButton("Cancel", null)
        .show();
    }
}
