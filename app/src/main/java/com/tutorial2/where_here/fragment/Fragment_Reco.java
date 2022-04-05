package com.tutorial2.where_here.fragment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Message;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.tutorial2.where_here.R;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.IOException;


public class Fragment_Reco extends Fragment {

    Handler handler = new Handler();

    //발키리 url
    String url = "https://www.gjw.co.kr/Contents/contents.php?cmsNo=DB0200/view/50";
    String msg;
    final Bundle bundle = new Bundle();

//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = (TextView) getView().findViewById(R.id.title);
        return inflater.inflate(R.layout.activity_fragment_reco, container, false);

        new Thread(){
            @Override
            public void run(){
                Document doc = null;

                try{
                    doc = (Document) Jsoup.connect(url).get();
                    Element elements = (Element) doc.select(".AttractionsInfo").first();
                    msg = elements.text();
                    bundle.putString("message",msg);// 핸들러 이요ㅗㅇ해서 Thread()가져오기
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }




}