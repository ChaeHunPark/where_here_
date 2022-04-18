package com.tutorial2.where_here;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Reco extends AppCompatActivity {
    private String htmlPageUrl = "https://www.gjw.co.kr/Contents/contents.php?cmsNo=DB0200";
    private String htmlContentInStringFormat;
    private TextView textviewHtmlDocument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reco);


        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();
    }

private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //arrt은 태그이름 반환 (속성:href), .text는 태그안에 있는 요소만 반환
        //.trim() 앞뒤로 공백없애줌
        try {
            Document doc = Jsoup.connect(htmlPageUrl).get();
            Elements links = doc.select("div#50");

            for (Element link : links) {
                htmlContentInStringFormat += (link.text().trim() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        ListView listView = (ListView) findViewById(R.id.list_reco); // 리스트의 아이디
        ListitemAdapter_Reco adapter = new ListitemAdapter_Reco(); // adapter에 어댑터 클래스 참조
        listView.setAdapter(adapter); // 찾은 아이디에 어댑터 지정
        adapter.addItem(new Listitem_Reco("123123", htmlContentInStringFormat)); // 어댑터에 additem

    }
}

}