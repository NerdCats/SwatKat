package co.gobd.tracker.ui.fragment;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.gobd.tracker.R;
import co.gobd.tracker.ui.service.LocationService;
import co.gobd.tracker.utility.Constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    private MapView mapView;
    private GoogleMap googleMap;


    private double pickupLat;
    private double pickupLng;
    private String pickupAddress;


    private double deliveryLat;
    private double deliveryLng;
    private String deliveryAddress;


    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        getJobData();

        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        // Needed to get the map to display immediately
        mapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final MarkerOptions pickupMarker = createMarkerOptions(MarkerType.PICKUP, pickupLat, pickupLng, pickupAddress);
        final MarkerOptions deliveryMarker = createMarkerOptions(MarkerType.DELIVERY, deliveryLat, deliveryLng, deliveryAddress);


        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                googleMap = map;
                googleMap.setMyLocationEnabled(true);

                if (LocationService.mCurrentLocation != null) {
                    double lat = LocationService.mCurrentLocation.getLatitude();
                    double lng = LocationService.mCurrentLocation.getLongitude();
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 13.0f));
                }

                googleMap.addMarker(pickupMarker);
                googleMap.addMarker(deliveryMarker);
            }
        });

        return view;
    }

    private void getJobData() {
        // Retrieves passed data from the bundle
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            pickupLat = bundle.getDouble(Constant.Job.PICKUP_LAT);
            pickupLng = bundle.getDouble(Constant.Job.PICKUP_LNG);
            pickupAddress = bundle.getString(Constant.Job.PICKUP_ADDRESS);

            deliveryLat = bundle.getDouble(Constant.Job.DELIVERY_LAT);
            deliveryLng = bundle.getDouble(Constant.Job.DELIVERY_LNG);
            deliveryAddress = bundle.getString(Constant.Job.DELIVERY_ADDRESS);
        }
    }

    @NonNull
    private MarkerOptions createMarkerOptions(MarkerType type, double lat, double lng, String address) {

        switch (type) {
            case PICKUP:
                return new MarkerOptions()
                        .position(new LatLng(lat, lng))
                        .title(address)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            case DELIVERY:
                return new MarkerOptions()
                        .position(new LatLng(lat, lng))
                        .title(address)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        }

        return null;

    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    private enum MarkerType {
        PICKUP,
        DELIVERY
    }
}
