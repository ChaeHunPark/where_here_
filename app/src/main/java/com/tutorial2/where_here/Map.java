// fab = floating btn..



package com.tutorial2.where_here;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;
import com.tutorial2.where_here.adapter.mapAdapter;
import com.tutorial2.where_here.info_class.lating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    public int count = 0;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    public int markerNum;
    private FusedLocationSource locationSource;
    private NaverMap naverMap;
    public lating lat_info = new lating();
    private InfoWindow infoWindow = new InfoWindow();
    public String selectMarker;
    public List<String> mi = new ArrayList<String>();
    public static Context mContext;


    public String[] find = {"marker1","marker2","marker3","marker4","marker5","marker6","marker7","marker8","marker9","marker10",
            "marker11","marker12","marker13","marker14","marker15","marker16","marker17","marker18","marker19","marker20",
            "marker21","marker22","marker23","marker24","marker25","marker26","marker27", "marker28","marker29"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

//????????????, ?????? ?????? ??????
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.map_f_btn);
        LinearLayout bar = (LinearLayout)findViewById(R.id.menu_bar);
        CheckBox park = (CheckBox) findViewById(R.id.btn_park);
        CheckBox photo = (CheckBox) findViewById(R.id.btn_photo);
        CheckBox rest = (CheckBox) findViewById(R.id.btn_restaurant);
        CheckBox toilet = (CheckBox) findViewById(R.id.btn_toilet);
        CheckBox cigar = (CheckBox) findViewById(R.id.btn_cigar);
        Button btn_main = (Button) findViewById(R.id.btn_main);
        ImageButton btn_reco = (ImageButton) findViewById(R.id.btn_reco);
        Button btn_info = (Button) findViewById(R.id.btn_info);
        CheckBox btn_back = (CheckBox) findViewById(R.id.btn_back);




//????????????
        LocationManager locationManager;
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.map_fragment);

//getMapAsync??? ???????????? ???????????? onMapReady ?????? ????????? ??????(????????? ????????? ??????)
        if(mapFragment == null){
            mapFragment = MapFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.map_fragment, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);

//intent btn setting
        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Map.this, Main_where.class);
                startActivity(intent);
            }
        });
        btn_reco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Map.this, Rating_Bar.class);
                startActivity(intent);
            }
        });
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Map.this, Info.class);
                startActivity(intent);
            }
        });

//fab??? ???????????? ????????? ????????? ?????? ????????? ????????? ??????
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count%2 == 0) {
                    bar.setVisibility(View.VISIBLE);
                    fab.setRotation(45);
                }else{
                    bar.setVisibility(View.GONE);
                    fab.setRotation(0);
                }
                count++;
            }
        });

//checkBox ??????????????? ?????? ????????? ?????? ??????????????????/ ???????????? ??????
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//check checkbox status
                if (park.isChecked()) {
// marker on
                    for(int i = 0; i<=28; i++){
                        setMarker(lat_info.marker_a[i], lat_info.lat_1[i], lat_info.lng_1[i], R.drawable.park, 0);

                    }
                } else {
// marker off

                    for(int i=0;i<=28;i++) {
                        lat_info.marker_a[i].setMap(null);
                    }
                }
            }
        });

//marker??? infowindow ????????????
        for(int i=0; i<lat_info.marker_a.length; i++) {
            markerInfo(lat_info.marker_a[i]);
        }



// ????????? ?????????
//        photo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (park.isChecked()) {
//// marker on
//                    for(int i = 0; i<=4; i++){
//                        setMarker(lat_info.marker_1[i], lat_info.lat_1[i], lat_info.lng_1[i], R.drawable.park, 0);
//                    }
//                } else {
//// marker off
//
//                    for(int i=0;i<=4;i++) {
//                        lat_info.marker_1[i].setMap(null);
//                    }
//                }
//            }
//        });
        rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rest.isChecked()) {
// marker on
                    for(int i = 0; i<=15; i++){
                        setMarker(lat_info.marker_r[i], lat_info.lat_r[i], lat_info.lng_r[i], R.drawable.restaurant, 0);
                    }
                } else {
// marker off

                    for(int i=0;i<=15;i++) {
                        lat_info.marker_r[i].setMap(null);
                    }
                }
            }
        });
        toilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toilet.isChecked()) {
// marker on
                    for(int i = 0; i<=6; i++){
                        setMarker(lat_info.marker_t[i], lat_info.lat_t[i], lat_info.lng_t[i], R.drawable.toilet, 0);
                    }
                } else {
// marker off

                    for(int i=0;i<=6;i++) {
                        lat_info.marker_t[i].setMap(null);
                    }
                }
            }
        });
        cigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cigar.isChecked()) {
// marker on.
                    for(int i = 0; i<=4; i++){
                        setMarker(lat_info.marker_c[i], lat_info.lat_c[i], lat_info.lng_c[i], R.drawable.cigar, 0);
                    }
                } else {
// marker off

                    for(int i=0;i<=4;i++) {
                        lat_info.marker_c[i].setMap(null);
                    }
                }
            }
        });


        mContext = this;
    }

//navermap setting
//?????? ?????? ????????? ??????????????? ??????
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap=naverMap;
        CameraUpdate gyeongjuwd = CameraUpdate.scrollTo(new LatLng(35.8369, 129.2821))
                .animate(CameraAnimation.Fly);

        naverMap.setLocationSource(locationSource);
        naverMap.getUiSettings().setLocationButtonEnabled(true);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Face);
        naverMap.moveCamera(gyeongjuwd);
    }

//infowindow ??????
    public void markerInfo(Marker mar){
        mar.setOnClickListener(new Overlay.OnClickListener() {

            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                List<String> mi = new ArrayList<String>();
                for(int i=0;i<lat_info.marker_a.length;i++) {
                    if (mar == lat_info.marker_a[i]) {
                        mi.add("marker" + (i+1));
                    }
                }
                selectMarker = mi.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
                markerNum = Arrays.asList(find).indexOf(selectMarker);


                ViewGroup rootView = (ViewGroup)findViewById(R.id.map_fragment);
                mapAdapter adapter = new mapAdapter(Map.this, rootView);


                infoWindow.setAdapter(adapter);

                //???????????? ????????????
                infoWindow.setZIndex(10);
                //????????? ??????
                infoWindow.setAlpha(0.9f);
                //????????? ??????
                infoWindow.open(mar);


                return false;
            }
        });
    }

//?????? ?????? ??????
    private void setMarker(Marker marker,  double lat, double lng, int resourceID, int zIndex)
    {
//????????? ??????
        marker.setIconPerspectiveEnabled(true);
//????????? ??????
        marker.setIcon(OverlayImage.fromResource(resourceID));
//????????? ?????????
        marker.setAlpha(0.8f);
//?????? ??????
        marker.setPosition(new LatLng(lat, lng));
//?????? ????????????
        marker.setZIndex(zIndex);
//?????? ??????
        marker.setMap(naverMap);
//?????? ?????????
        marker.setWidth(100);
        marker.setHeight(100);
    }

//?????? ?????? ???????????? ??????
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,  @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) { //?????? ??????if???
            if(!locationSource.isActivated()){
//????????? ????????? ??????
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



}