package com.example.androidversion;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {
    private ListView calendar_list;
    private CalendarAdapter adapter;
    private List<Calendar> calendarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        calendar_list=(ListView)findViewById(R.id.calendar_list);
        calendarList=new ArrayList<Calendar>();
        calendar_setList();
        adapter=new CalendarAdapter(getApplicationContext(),calendarList);
        calendar_list.setAdapter(adapter);
    }
    private void calendar_setList(){
        calendarList=new ArrayList<Calendar>();
        calendarList.add(new Calendar("취업준비스터디","17:00-20:00","임대동","취업준비생","취업을 준비하는 모든 사람들이 들을 수 있는 수업이 되었으면 좋겠습니다."));
        calendarList.add(new Calendar("c스터디","16:30-18:00","최홍준","1학년","1학년 1학기 c프로그래밍"));

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}