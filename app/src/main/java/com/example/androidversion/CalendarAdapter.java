package com.example.androidversion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CalendarAdapter extends BaseAdapter {
    private Context context;
    private List<Calendarlist> calendarList;
    public CalendarAdapter(Context context,List<Calendarlist> calendarList) {
        this.context=context;
        this.calendarList=calendarList;
    }
    @Override
    public int getCount() { return calendarList.size(); }
    @Override
    public Object getItem(int position) { return calendarList.get(position); }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.calendar_listview,null);

        TextView list_title=(TextView)v.findViewById(R.id.list_title);
        TextView list_time=(TextView)v.findViewById(R.id.list_time);
        TextView list_regist=(TextView)v.findViewById(R.id.list_regist);
        TextView list_participant=(TextView)v.findViewById(R.id.list_participant);
        TextView list_detail=(TextView)v.findViewById(R.id.list_detail);

        list_title.setText(calendarList.get(position).getTitle());
        list_time.setText(calendarList.get(position).getTime());
        list_regist.setText(calendarList.get(position).getRegist());
        list_participant.setText(calendarList.get(position).getParticipant());
        list_detail.setText(calendarList.get(position).getDetail());
        v.setTag(calendarList.get(position).getTitle());
        return v;
    }
}