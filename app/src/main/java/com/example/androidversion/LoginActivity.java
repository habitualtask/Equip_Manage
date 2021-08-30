package com.example.androidversion;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
                /*String login_url = getString(R.string.ip)+"loginResult?id="+id+"&"+"pw="+pw;
                Log.d("jkdd",login_url);

                login_url = login_url.replaceAll(" ","%20");

               StringRequest request= new StringRequest(Request.Method.GET, login_url,
                        new Response.Listener<String>() {
                            public void onResponse(final String response) {
                                try {
                                    JsonParser parser = new JsonParser();
                                    JsonObject jsonObj = (JsonObject)parser.parse(response);
                                    Log.d("kkkk1",response);
                                    JsonArray jsonArray = (JsonArray) jsonObj.get("data");

                                    JsonObject object = (JsonObject) jsonArray.get(0);
                                    String result= object.get("result").getAsString();

                                    if(result.equals("1")){
                                        Intent intent2 = new Intent(getApplicationContext(),Main2Activity.class);
                                        startActivity(intent2);
                                        finish();
                                    }else {
                                        Toast.makeText(getApplicationContext(),"일치하는 정보가 없습니다.",Toast.LENGTH_SHORT);
                                        Log.d("jkd",result);
                                    }
                                    //textView.append(response);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                error.printStackTrace();
                            }
                        }){
                    protected Map<String, String> getParams(){
                        Map<String,String> params = new HashMap<>();
                        params.put("Content-Type","application/json; charset=utf-8");
                        return params;
                    }
                };
                request.setShouldCache(false);
                Volley.newRequestQueue(LoginActivity.this).add(request);*/
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

        Button login_data = findViewById(R.id.login_data);
        login_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent100 = new Intent(getApplicationContext(),datacheck.class);
                startActivity(intent100);
            }
        });





    }
}