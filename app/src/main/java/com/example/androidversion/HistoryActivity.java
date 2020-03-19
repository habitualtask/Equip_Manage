package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class HistoryActivity extends AppCompatActivity {
    Button history_searchbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("비품대여기록");
        history_searchbtn=(Button)findViewById(R.id.history_searchbtn);
        Spinner spinner_startYear=(Spinner)findViewById(R.id.history_startYear);
        Spinner spinner_startMonth=(Spinner)findViewById(R.id.history_startMonth);
        Spinner spinner_startDay=(Spinner)findViewById(R.id.history_startDay);
        Spinner spinner_endYear=(Spinner)findViewById(R.id.history_endYear);
        Spinner spinner_endMonth=(Spinner)findViewById(R.id.history_endMonth);
        Spinner spinner_endDay=(Spinner)findViewById(R.id.history_endDay);
        history_searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"기록이없습니다",Toast.LENGTH_SHORT).show();
                //날짜에 맞는 리스트를 뽑아낼 것
            }
        });
    }
}
