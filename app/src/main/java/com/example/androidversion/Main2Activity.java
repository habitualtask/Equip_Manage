package com.example.androidversion;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
        setTitle("과업님! 키퍼의 메인페이지입니다.");
        Button main2_logoutbtn=findViewById(R.id.main2_logoutbtn);
        Button main2_mypagebtn=findViewById(R.id.main2_mypagebtn);
        Button main2_searchbtn=findViewById(R.id.main2_searchbtn);

        main2_logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"로그아웃 중...",Toast.LENGTH_LONG).show();
                Intent intent5=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent5);
                finish();
            }
        });
        main2_mypagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 =new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent6);
            }
        });
        main2_searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7=new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(intent7);
            }
        });

        main2_list = (ListView)findViewById(R.id.main2_list);
        noticedList = new ArrayList<Notice>();
        main2_setList();
        adapter = new NoticeAdapter(getApplicationContext(), noticedList);
        main2_list.setAdapter(adapter);
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
}