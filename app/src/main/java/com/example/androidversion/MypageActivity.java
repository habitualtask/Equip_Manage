package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MypageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        setTitle("과업님의 마이페이지");
        Button mypage_historybtn = (Button)findViewById(R.id.mypage_historybtn);
        Button mypage_pwChangebtn =(Button)findViewById(R.id.mypage_pwChangebtn);
        mypage_historybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 =new Intent(getApplicationContext(),HistoryActivity.class);
                startActivity(intent8);
            }
        });
        mypage_pwChangebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent10 = new Intent(getApplicationContext(),PwChActivity.class);
                startActivity(intent10);
            }
        });
    }
}
