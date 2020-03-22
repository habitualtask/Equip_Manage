package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PwChActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_ch);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final EditText pwch_pw1=findViewById(R.id.pwch_pw1);
        final EditText pwch_pw2=findViewById(R.id.pwch_pw2);
        final EditText pwch_pw3=findViewById(R.id.pwch_pw3);
        Button pwch_chbtn=findViewById(R.id.pwch_chbtn);
        final int backblue=getResources().getColor(R.color.bg_blue);
        final int backred=getResources().getColor(R.color.bg_red);

        pwch_pw3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                final String pw=pwch_pw2.getText().toString();
                final String pwch=pwch_pw3.getText().toString();
                if (pw.length()>=8&&pwch.length()>=8){
                    if(pw.equals(pwch)){
                        pwch_pw2.setBackgroundColor(backblue);
                        pwch_pw3.setBackgroundColor(backblue);
                    }else{
                        pwch_pw2.setBackgroundColor(backred);
                        pwch_pw3.setBackgroundColor(backred);
                        return;
                    }
                }else{
                    pwch_pw2.setBackgroundColor(backred);
                    pwch_pw3.setBackgroundColor(backred);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });
        pwch_chbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String pw1=pwch_pw1.getText().toString();
                final String pw2=pwch_pw2.getText().toString();
                final String pw3=pwch_pw3.getText().toString();
                if (pw1.length()==0){
                    Toast.makeText(getApplicationContext(),"기존비밀번호 입력하세요",Toast.LENGTH_SHORT).show();
                    pwch_pw1.requestFocus();
                    return;
                }
                if (pw2.length()==0){
                    Toast.makeText(getApplicationContext(),"변경비밀번호 입력하세요",Toast.LENGTH_SHORT).show();
                    pwch_pw2.requestFocus();
                    return;
                }else if(pw2.length()>=8&&pw3.length()>=8){
                    if (!pw2.equals(pw3)){
                        Toast.makeText(getApplicationContext(),"변경비밀번호와 일치하지않습니다.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"비밀번호는 8자리이상 입력해주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pw3.length()==0){
                    Toast.makeText(getApplicationContext(),"변경비밀번호확인 입력하세요",Toast.LENGTH_SHORT).show();
                    pwch_pw3.requestFocus();
                    return;
                }
                Intent intent11 = new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent11);
                finish();
            }
        });

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
