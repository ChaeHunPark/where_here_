package com.tutorial2.where_here;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Main_where extends AppCompatActivity {


    public static List<String> info_title = new ArrayList<>();
    public static List<String> info_intro = new ArrayList<>();
    public int[] info_images = {R.drawable.rides_1, R.drawable.rides_2, R.drawable.rides_3, R.drawable.rides_4, R.drawable.rides_5,
            R.drawable.rides_6, R.drawable.rides_7, R.drawable.rides_8, R.drawable.rides_9, R.drawable.rides_10,
            R.drawable.rides_11, R.drawable.rides_12, R.drawable.rides_13, R.drawable.rides_14, R.drawable.rides_15,
            R.drawable.rides_16, R.drawable.rides_17, R.drawable.rides_18, R.drawable.rides_19, R.drawable.rides_20,
            R.drawable.rides_21, R.drawable.rides_22, R.drawable.rides_23, R.drawable.rides_24, R.drawable.rides_25,
            R.drawable.rides_26, R.drawable.rides_27, R.drawable.rides_28, R.drawable.rides_29};

    public void readExcel() { // 초기에 놀이기구를 리스트에 넣는 메소드

        try {
            InputStream is = getBaseContext().getResources().getAssets().open("where_rides.xls");
            Workbook wb = Workbook.getWorkbook(is);

            if (wb != null) {
                Sheet sheet = wb.getSheet(0);   // 시트 불러오기
                if (sheet != null) {

                    int colTotal = sheet.getColumns();    // 전체 컬럼
                    int rowIndexStart = 1;                  // row 인덱스 시작
                    int rowTotal = sheet.getColumn(colTotal - 1).length;

                    for (int row = rowIndexStart; row < rowTotal; row++) { // 1; 1<전체로우; 1++
                        String title = sheet.getCell(0, row).getContents(); //1열 부분
                        String intro = sheet.getCell(1, row).getContents(); //2열 부분
                        info_title.add(title);
                        info_intro.add(intro);
                    }
                }
            }
        } catch (IOException e) {
                e.printStackTrace();
        } catch (BiffException e) {
                e.printStackTrace();
        }

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_where);

        readExcel(); // 메소드 실행

        Button btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_where.this, Map.class);
                startActivity(intent);
            }
        });

        Button btn_2 = (Button) findViewById(R.id.button3);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_where.this, Info.class);
                startActivity(intent);
            }
        });
    }
}