// fab = floating btn.



package com.tutorial2.where_here;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;

public class Map extends AppCompatActivity implements OnMapReadyCallback {

    public int count =0;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;
    private NaverMap naverMap;
    private Marker marker1 = new Marker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

//위치소스, 각종 버튼 선언
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.map_f_btn);
        LinearLayout bar = (LinearLayout)findViewById(R.id.menu_bar);
        CheckBox park = (CheckBox) findViewById(R.id.btn_park);
        CheckBox photo = (CheckBox) findViewById(R.id.btn_photo);
        CheckBox rest = (CheckBox) findViewById(R.id.btn_restaurant);
        CheckBox toilet = (CheckBox) findViewById(R.id.btn_toilet);
        CheckBox cigar = (CheckBox) findViewById(R.id.btn_cigar);


//위치설정
        LocationManager locationManager;
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.map_fragment);

//getMapAsync를 호출하여 비동기로 onMapReady 콜백 매서드 호출(네이버 플렛폼 참고)
        if(mapFragment == null){
            mapFragment = MapFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.map_fragment, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);

//fab를 눌렀을때 이벤트 처리를 위한 온클릭 리스너 장착
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

//checkBox 체크상테별 마커 표시를 위해 온클릭리스너/ 체크상태 확인
        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//check checkbox status
                if (park.isChecked()) {
                    // marker on
                    setMarker(marker1, 35.8373, 129.2821, R.drawable.marker, 0);
                } else {
                    // marker off
//                    setMarker(null);
                    marker1.setMap(null);
                }
            }
        });

    }

//navermap setting
//초기 지도 로딩시 경주월드로 세팅
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

//마커 옵션 정의
    private void setMarker(Marker marker,  double lat, double lng, int resourceID, int zIndex)
    {
//원근감 표시
        marker.setIconPerspectiveEnabled(true);
//아이콘 지정
        marker.setIcon(OverlayImage.fromResource(resourceID));
//마커의 투명도
        marker.setAlpha(0.8f);
//마커 위치
        marker.setPosition(new LatLng(lat, lng));
//마커 우선순위
        marker.setZIndex(zIndex);
//마커 표시
        marker.setMap(naverMap);
//마커 사이즈
        marker.setWidth(200);
        marker.setHeight(200);
    }

//현재 위치 사용권한 요청
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,  @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) { //요청 허용if문
            if(!locationSource.isActivated()){
//요청이 거부된 경우
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}