package com.tutorial2.where_here.fragment;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.tutorial2.where_here.Adapter.List_Reco;
import com.tutorial2.where_here.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;


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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        Reco_data task = new Reco_data();
        task.execute();
        return view;
    }

    private class Reco_data extends AsyncTask<Void, Void, ArrayList<List_Reco>> {



        @Override
        protected ArrayList<List_Reco> doInBackground(Void... voids) {

            ArrayList<List_Reco> arrayList = new ArrayList<List_Reco>();

            try {
                /* Jsoup을 이용해 데이터 가져오기 */
                Document document = Jsoup.connect("https://www.gjw.co.kr/Contents/contents.php?cmsNo=DB0200/view/50").get(); //URL 웹사이트에 있는 html 코드를 다 끌어오기
//                Elements doc = document.select("div.rpsa_detail > div > div");dd
                Elements doc = document.select(".WrapWidth");

                int region_num = 0;
                String image = null;
                String title = null;
                String rating = null;

               for(int i=1; i<doc.size(); i++) {

                    image = doc.get(i).select("h4").text();
                    title = doc.get(i).select("h4").text();
                    rating = doc.get(i).select("h4").text();


                   if(rating.equals("(0)")){
                       rating = "";
                   }

                    arrayList.add(new List_Reco(image, title, rating));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return arrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<List_Reco> arrayList)  {
            ImageView imageView = (ImageView) getView().findViewById(R.id.image);
            // doInBackground 완료 후 실행시킬 코드
        }
    }

}





//       new Thread(){
//@Override
//public void run(){
//        Document doc = null;
//
//        try{
//        doc = (Document) Jsoup.connect(url).get();
//        Element elements = (Element) doc.select(".AttractionsInfo").first();
//        msg = elements.text();
//        bundle.putString("message",msg);// 핸들러 이요ㅗㅇ해서 Thread()가져오기
//        Message msg = handler.obtainMessage();
//        msg.setData(bundle);
//        handler.sendMessage(msg);
//        } catch (IOException e) {
//        e.printStackTrace();
//        }
//        }
//        };