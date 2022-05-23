package com.tutorial2.where_here.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.naver.maps.map.overlay.InfoWindow;
import com.tutorial2.where_here.R;

public class mapAdapter extends InfoWindow.DefaultViewAdapter
{
    private final Context mContext;
    private final ViewGroup mParent;

    public mapAdapter(@NonNull Context context, ViewGroup parent)
    {
        super(context);
        mContext = context;
        mParent = parent;
    }

    @NonNull
    @Override
    protected View getContentView(@NonNull InfoWindow infoWindow)
    {

        View view = (View) LayoutInflater.from(mContext).inflate(R.layout.map_info, mParent, false);

        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        ImageView rideName = (ImageView) view.findViewById(R.id.rideName);
        Button btn_back = (Button) view.findViewById(R.id.btn_back);

        txtName.setText("놀이기구");
        rideName.setImageResource(R.drawable.rides_1);


        return view;
    }
}
