package com.tutorial2.where_here;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class ListitemAdapter_Reco extends BaseAdapter {
    ArrayList<Listitem_Reco> items = new ArrayList<Listitem_Reco>();
    Context context;

    @Override
    public int getCount(){ //리스트 아이템
        return items.size();
    } // 아이템 길이 반환
    @Override
    public Object getItem(int position){
        return items.get(position);
    } //item 반환
    @Override
    public long getItemId(int position){
        return position;
    } //아이템 ID반환

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        context = parent.getContext();
        Listitem_Reco listitem_reco = items.get(position);

//        "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.reco_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView reco_title = convertView.findViewById(R.id.title_reco);
        TextView reco_intro = convertView.findViewById(R.id.intro_reco);


    // Data Set(Listitme_Reco)에서 position에 위치한 데이터 참조 획득
        reco_title.setText(listitem_reco.getTitle());
        reco_intro.setText(listitem_reco.getIntro());

        return convertView;

    }

    public void addItem(Listitem_Reco item){ items.add(item);} //
}
