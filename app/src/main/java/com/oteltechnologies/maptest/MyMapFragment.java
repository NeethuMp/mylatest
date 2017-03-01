package com.oteltechnologies.maptest;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link MyMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyMapFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView tvName;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MapView mMapView;
    private GoogleMap googleMap;
    GPSTracker gps;
    double longitude;
    double latitude;
    private OnFragmentInteractionListeners mListener;

    public MyMapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MyMapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyMapFragment newInstance() {
        MyMapFragment fragment = new MyMapFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_map, container, false);
        tvName = (TextView) rootView.findViewById(R.id.tvName);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {


                gps = new GPSTracker(getActivity());


                if (gps.canGetLocation()) {


                    longitude = gps.getLongitude();
                    Log.d("longitude", "" + longitude);

                    latitude = gps.getLatitude();

                    Log.d("latitude", "" + latitude);
                    Geocoder geocoder;
                    List<Address> addresses = null;
                    geocoder = new Geocoder(getActivity(), Locale.getDefault());


                    try {
                        addresses = geocoder.getFromLocation(latitude, longitude, 1);
                        String city = addresses.get(0).getLocality();
                        String country = addresses.get(0).getCountryName();
                        Log.d("city", "" + city);
                        Log.d("country", "" + country);
                        googleMap = mMap;

                        // For showing a move to my location button
//                googleMap.setMyLocationEnabled(true);

                        // For dropping a marker at a point on the Map
                        LatLng sydney = new LatLng(latitude, longitude);
                        googleMap.addMarker(new MarkerOptions().position(sydney).title(country).snippet(city));

                        // For zooming automatically to the location of the marker
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
                        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//                            @Override
//                            public void onMapClick(LatLng latLng) {
//                                Intent i = new Intent(getActivity(), ShowCementActivity.class);
//                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(i);
//                            }
//                        });


                        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                            @Override
                            public void onInfoWindowClick(Marker marker) {
                                Intent intent1 = new Intent(getActivity(), ShowCementActivity.class);
                                String title = marker.getTitle();
                                intent1.putExtra("markertitle", title);
                                startActivity(intent1);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

//set login name
                String nmeIntent = getActivity().getIntent().getExtras().getString("name");
                tvName.setText(nmeIntent);


            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListeners) {
            mListener = (OnFragmentInteractionListeners) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        Intent i = new Intent(getActivity(), ShowCementActivity.class);
//        startActivity(i);
//        return false;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
