package com.example.androidversion;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login_loginbtn = findViewById(R.id.login_loginbtn);
        TextView login_joinbtn = findViewById(R.id.login_joinbtn);
        final EditText login_id=findViewById(R.id.login_id);
        final EditText login_pw=findViewById(R.id.login_pw);

        login_loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String id=login_id.getText().toString();
                final String pw=login_pw.getText().toString();
                if(id.length()==0){
                    Toast.makeText(getApplicationContext(),"ID 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }if(pw.length()==0){
                    Toast.makeText(getApplicationContext(),"PW 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
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