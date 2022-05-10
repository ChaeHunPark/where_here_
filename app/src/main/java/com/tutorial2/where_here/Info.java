package com.tutorial2.where_here;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tutorial2.where_here.Info_Strings.Info_Strings;

public class Info extends AppCompatActivity {

    public Info_Strings info_strings = new Info_Strings();
    public static int Rides_Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ListView listView = (ListView) findViewById(R.id.list_info); // 리스트의 아이디
        ListitemAdapter_Info adapter = new ListitemAdapter_Info(); // adapter에 어댑터 클래스 참조
        listView.setAdapter(adapter); // 찾은 아이디에 어댑터 지정

        for (int i = 0; i < 29; i++){
            adapter.addItem(new Listitem_Info(info_strings.info_title[i],info_strings.info_intro[i],
                    info_strings.info_images[i])); // 커스텀 리스트 add
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // 인덱스 클릭했을때 이벤트 지정
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Listitem_Info item = (Listitem_Info) parent.getItemAtPosition(position); //item에 포지션 반환

                String title = item.getTitle();
                String intro = item.getIntro();

                for(int i = 0; i<29; i++) {

                    if (title.substring(0) == info_strings.info_title[i]) { // 다이얼로그
                        Rides_Index = i; //Info_to_Map에서 인덱스으로 값 사용
                        AlertDialog.Builder builder = new AlertDialog.Builder(Info.this);
                        builder.setTitle(title);
                        builder.setMessage(intro);
                        builder.setPositiveButton(info_strings.info_title[i]+" 타러가기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Info.this, Info_to_Map.class);
                                startActivity(intent);
                            }
                        });
                        builder.setNeutralButton("닫기", null);
                        builder.create().show();
                    }

                }


            }
        });


//        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
//        jsoupAsyncTask.execute();
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//    }
    //private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
//
//    private String htmlPageUrl = "https://www.gjw.co.kr/Contents/contents.php?cmsNo=DA0200";
////            "https://www.gjw.co.kr/Contents/contents.php?cmsNo=DB0200";
//    private String htmlContentInStringFormat = "";
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//    }
//
//    @Override
//    protected Void doInBackground(Void... params) {
//        try {
//            Document doc = Jsoup.connect(htmlPageUrl).get();
////            Elements links = doc.select("a[href]");
//            Elements links = doc.select("html");
//            for (Element link : links) { //스트링으로 포맷
//                htmlContentInStringFormat += ( link.text().trim() + "\n");
//
//
//                //arrt은 태그이름 반환 (속성:href), .text는 태그안에 있는 요소만 반환
//                //.trim() 앞뒤로 공백없애줌
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(Void result) {
//
//    }
//}

}