package com.tutorial2.where_here;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.location.LocationManager;
import android.os.Bundle;

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
import com.tutorial2.where_here.lat_lng.lating;


public class Info_to_Map extends AppCompatActivity implements OnMapReadyCallback{
    public Info info = new Info();
    public int count =0;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;
    private NaverMap naverMap;
    public lating lat_info = new lating();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_to_map);

//위치소스, 각종 버튼 선언
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);




//위치설정
        LocationManager locationManager;
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment) fragmentManager.findFragmentById(R.id.info_to_mapf);

//getMapAsync를 호출하여 비동기로 onMapReady 콜백 매서드 호출(네이버 플렛폼 참고)
        if(mapFragment == null){
            mapFragment = MapFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.info_to_mapf, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);




    }

    //navermap setting
//초기 지도 로딩시 경주월드로 세팅
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        for(int i=0; i<29; i++){
        this.naverMap=naverMap;
        CameraUpdate gyeongjuwd = CameraUpdate.scrollTo(new LatLng(35.8369, 129.2821))
                .animate(CameraAnimation.Fly);

        naverMap.setLocationSource(locationSource);
        naverMap.getUiSettings().setLocationButtonEnabled(true);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Face);
        naverMap.moveCamera(gyeongjuwd);



            if (info.Rides_Index == i) //Info_to_Map에서 Intent 후 클릭한 인덱스 값과 같으면 초기로 마커를 띄움
            setMarker(lat_info.marker_1[i], lat_info.lat_1[i], lat_info.lng_1[i], R.drawable.park, 0);
        }
    }

    //마커 옵션 정의
    private void setMarker(Marker marker, double lat, double lng, int resourceID, int zIndex)
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
        marker.setWidth(100);
        marker.setHeight(100);
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