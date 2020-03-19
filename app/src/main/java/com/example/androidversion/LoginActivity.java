package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("키퍼로그인");
        Button login_loginbtn = findViewById(R.id.login_loginbtn);
        TextView login_joinbtn = findViewById(R.id.login_joinbtn);
        login_loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent2);
                finish();
            }
        });
        login_joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(),JoinActivity.class);
                startActivity(intent3);
                finish();
            }
        });
    }
}