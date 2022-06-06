package com.tutorial2.where_here.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naver.maps.map.overlay.Marker;
import com.tutorial2.where_here.Main_where;
import com.tutorial2.where_here.info_class.lating;
import com.tutorial2.where_here.Map;

import androidx.annotation.NonNull;

import com.naver.maps.map.overlay.InfoWindow;
import com.tutorial2.where_here.R;

import java.util.Arrays;

public class mapAdapter extends InfoWindow.DefaultViewAdapter
{
    private final Context mContext;
    public Map sm = new Map();
    public String select;
    private final ViewGroup mParent;
    public lating lat_info = new lating();


    public int selectMarker;
    public String[] find = {"marker1","marker2","marker3","marker4","marker5","marker6","marker7","marker8","marker9","marker10",
            "marker11","marker12","marker13","marker14","marker15","marker16","marker17","marker18","marker19","marker20",
            "marker21","marker22","marker23","marker24","marker25","marker26","marker27", "marker28","marker29"};
    public String[] info = {"파에톤","메가드롭","토네이도","그랜드캐년대탐험","볼하우스","위자드트레인","매직펌킨","문라이트세일","클라우드라이드","캐로셀",
            "매직카","매직트리","미로탐험","비룡열차","패밀리바이킹","서라벌관람차","타가디스코","킹바이킹","에어벌룬","바운스스핀",
            "댄싱컵","급류타기","가족열차","범퍼카","섬머린스플래쉬","드래곤레이스","크라크","드라켄","발키리"};
    public int[] info_images = {R.drawable.rides_1, R.drawable.rides_2, R.drawable.rides_3, R.drawable.rides_4, R.drawable.rides_5,
            R.drawable.rides_6, R.drawable.rides_7, R.drawable.rides_8, R.drawable.rides_9, R.drawable.rides_10,
            R.drawable.rides_11, R.drawable.rides_12, R.drawable.rides_13, R.drawable.rides_14, R.drawable.rides_15,
            R.drawable.rides_16, R.drawable.rides_17, R.drawable.rides_18, R.drawable.rides_19, R.drawable.rides_20,
            R.drawable.rides_21, R.drawable.rides_22, R.drawable.rides_23, R.drawable.rides_24, R.drawable.rides_25,
            R.drawable.rides_26, R.drawable.rides_27, R.drawable.rides_28, R.drawable.rides_29};

    public mapAdapter(@NonNull Context context, ViewGroup parent)
    {
        super(context);
        mContext = context;
        mParent = parent;
        selectMarker =((Map)Map.mContext).markerNum;


    }


    @NonNull
    @Override
    protected View getContentView(@NonNull InfoWindow infoWindow)
    {


        View view = (View) LayoutInflater.from(mContext).inflate(R.layout.map_info, mParent, false);

        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        ImageView rideName = (ImageView) view.findViewById(R.id.rideName);



        txtName.setText(info[selectMarker]);
        rideName.setImageResource(info_images[selectMarker]);



        return view;
    }
}
