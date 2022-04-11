// fragment_map
// naver map api, floating_btn <=> layout:invisible(gone)/visible

package com.tutorial2.where_here.fragment;

import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tutorial2.where_here.R;

public class Fragment_Map extends Fragment {
    //count는 f_btn의 count를 세어 on/off기능을 사용하려 선언
    private int count =0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Fagment에서 view를 정의하여 btn/layout을 표현해야함, 자주쓰기때문에 v라는 이름으로 간단히 선언
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        FloatingActionButton f_btn = (FloatingActionButton) v.findViewById(R.id.map_f_btn);
        LinearLayout bar = (LinearLayout)v.findViewById(R.id.menu_bar);

        //f_btn의 클릭 이벤트 처리를 위해 onclicklistener 부여
        f_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //버튼 반복 터치를 통해 menu bar 나타내기 변경
                if(count%2 == 0) {
                    bar.setVisibility(View.VISIBLE);
                    //버튼 이미지와 색상 변경
//                    f_btn.setBackgroundTintList(ColorstateList.valueof(Color.parseColor("#4caf50")));
                }else{
                    bar.setVisibility(View.GONE);
                }
                count++;
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}