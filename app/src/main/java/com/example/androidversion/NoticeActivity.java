package com.example.androidversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        setTitle("공지사항");
    }
}
