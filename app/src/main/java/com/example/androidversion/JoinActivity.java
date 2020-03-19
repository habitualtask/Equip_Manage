package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class JoinActivity extends AppCompatActivity {
    Button join_joinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        setTitle("키퍼회원가입");

        join_joinbtn=(Button)findViewById(R.id.join_joinbtn);
        Spinner spinner_company = (Spinner)findViewById(R.id.join_company);
        Spinner spinner_rank = (Spinner)findViewById(R.id.join_rank);

        join_joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent4);
                finish();
            }
        });
    }
}
