package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private ListView main2_list;
    private NoticeAdapter adapter;
    private List<Notice> noticedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        final ImageButton main2_equip=(ImageButton)findViewById(R.id.main2_equip);
        final ImageButton main2_book=(ImageButton)findViewById(R.id.main2_book);
        final ImageButton main2_calendar=(ImageButton)findViewById(R.id.main2_calendar);
        main2_list = (ListView)findViewById(R.id.main2_list);
        noticedList = new ArrayList<Notice>();
        main2_setList();
        adapter = new NoticeAdapter(getApplicationContext(), noticedList);
        main2_list.setAdapter(adapter);

        main2_equip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),EquipActivity.class);
                startActivity(intent);
            }
        });
        main2_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),BookActivity.class);
                startActivity(intent1);
            }
        });
        main2_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),CalendarActivity.class);
                startActivity(intent2);
            }
        });
    }


    private void main2_setList() {
        noticedList = new ArrayList<Notice>();
        noticedList.add(new Notice("공지사항", "이준범", "2018-09-09"));
        noticedList.add(new Notice("공지사항", "최홍준", "2018-09-10"));
        noticedList.add(new Notice("공지사항", "임대동", "2018-09-11"));
        noticedList.add(new Notice("공지사항", "안교준", "2018-09-12"));
        noticedList.add(new Notice("공지사항", "정세연", "2018-09-13"));
        noticedList.add(new Notice("공지사항", "김동훈", "2018-09-14"));
        noticedList.add(new Notice("공지사항", "이윤재", "2018-09-15"));
        noticedList.add(new Notice("공지사항", "조수연", "2018-09-16"));
        noticedList.add(new Notice("공지사항", "이현재", "2018-09-17"));
        noticedList.add(new Notice("공지사항", "이상원", "2018-09-18"));
        noticedList.add(new Notice("공지사항", "이재갑", "2018-09-19"));
        noticedList.add(new Notice("공지사항", "김혜진", "2018-09-20"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_main2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.action_search:
                Intent intent7=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent7);
                return true;

            case R.id.action_mypage:
                Intent intent6 =new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent6);
                return true;

            case R.id.action_setting:
                Intent intent3 =new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent3);
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