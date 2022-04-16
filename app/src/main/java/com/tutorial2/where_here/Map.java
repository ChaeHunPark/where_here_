// fab = floating btn



package com.tutorial2.where_here;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Map extends AppCompatActivity {

    public int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.map_f_btn);
        LinearLayout bar = (LinearLayout)findViewById(R.id.menu_bar);

//fab를 눌렀을때 이벤트 처리를 위한 온클릭 리스너 장착
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count%2 == 0) {
                    bar.setVisibility(View.VISIBLE);
//                    //버튼 이미지와 색상 변경
                    fab.setRotation(45);
                }else{
                    bar.setVisibility(View.GONE);
                    fab.setRotation(0);
                }
                count++;
            }
        });
    }
}