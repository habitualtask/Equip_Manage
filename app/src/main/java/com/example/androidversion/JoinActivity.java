package com.example.androidversion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
        final EditText join_id =(EditText)findViewById(R.id.join_id);
        final EditText join_pw =(EditText) findViewById(R.id.join_pw);
        final EditText join_pwch=(EditText)findViewById(R.id.join_pwch);
        final EditText join_name=(EditText)findViewById(R.id.join_name);
        final EditText join_major=(EditText)findViewById(R.id.join_major);
        final EditText join_email=(EditText)findViewById(R.id.join_email);
        final int backblue=getResources().getColor(R.color.bg_blue);
        final int backred=getResources().getColor(R.color.bg_red);


        join_pwch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                final String pw=join_pw.getText().toString();
                final String pwch=join_pwch.getText().toString();
                if (pw.length()>=8&&pwch.length()>=8){
                    if(pw.equals(pwch)){
                        join_pw.setBackgroundColor(backblue);
                        join_pwch.setBackgroundColor(backblue);
                    }else{
                        join_pw.setBackgroundColor(backred);
                        join_pwch.setBackgroundColor(backred);
                        return;
                    }
                }else{
                    join_pw.setBackgroundColor(backred);
                    join_pwch.setBackgroundColor(backred);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        join_joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String id=join_id.getText().toString();
                final String pw=join_pw.getText().toString();
                final String pwch=join_pwch.getText().toString();
                final String name=join_name.getText().toString();
                final String major=join_major.getText().toString();
                final String email=join_email.getText().toString();
                if (id.length()==0){
                    Toast.makeText(getApplicationContext(),"ID 입력하세요",Toast.LENGTH_SHORT).show();
                    join_id.requestFocus();
                    return;
                }
                if (pw.length()==0){
                    Toast.makeText(getApplicationContext(),"PassWord 입력하세요",Toast.LENGTH_SHORT).show();
                    join_pw.requestFocus();
                    return;
                }else if(pw.length()>=8&&pwch.length()>=8){
                    if (!pw.equals(pwch)){
                        Toast.makeText(getApplicationContext(),"pw와 pwch가 일치하지않습니다.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Password는 8자리이상 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwch.length()==0){
                    Toast.makeText(getApplicationContext(),"PassWord Check입력하세요",Toast.LENGTH_SHORT).show();
                    join_pwch.requestFocus();
                    return;
                }if (name.length()==0){
                    Toast.makeText(getApplicationContext(),"Name 입력하세요",Toast.LENGTH_SHORT).show();
                    join_name.requestFocus();
                    return;
                }if (major.length()==0){
                    Toast.makeText(getApplicationContext(),"Mojor 입력하세요",Toast.LENGTH_SHORT).show();
                    join_major.requestFocus();
                    return;
                }if (email.length()==0){
                    Toast.makeText(getApplicationContext(),"Email 입력하세요",Toast.LENGTH_SHORT).show();
                    join_email.requestFocus();
                    return;
                }
                Intent intent4 = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent4);
                finish();
                //여기서는 pw중복,pw길이제한,전부 다 입력해줬는지 코딩할 것
                //서버에서 무슨 에러인지 보내주면 json에 담아주면 토스트로 보내줌
            }
        });
    }
}
