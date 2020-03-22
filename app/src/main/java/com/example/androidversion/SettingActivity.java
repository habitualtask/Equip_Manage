package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_setting, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.action_search:
                Intent intent7=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent7);
                finish();
                return true;

            case R.id.action_mypage:
                Intent intent6 =new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent6);
                finish();
                return true;

            case R.id.action_logout:
                Toast.makeText(getApplicationContext(),"로그아웃 중...",Toast.LENGTH_LONG).show();
                Intent intent5=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent5);
                finish();
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
