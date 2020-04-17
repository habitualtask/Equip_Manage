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

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private ListView main2_list;
    private NoticeAdapter adapter;
    private List<Notice> noticedList;
    private IntentIntegrator qrScan;                                                        //qr code scanner object

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
        final Button buttonScan = (Button) findViewById(R.id.buttonScan);                   //QR코드 버튼

        qrScan = new IntentIntegrator(this);                                        //intializing scan object
        main2_list = (ListView)findViewById(R.id.main2_list);
        noticedList = new ArrayList<Notice>();
        main2_setList();
        adapter = new NoticeAdapter(getApplicationContext(), noticedList);
        main2_list.setAdapter(adapter);

        main2_equip.setOnClickListener(new View.OnClickListener() {                         //장비 button onClick
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),EquipActivity.class);
                startActivity(intent);
            }
        });
        main2_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                            //도서 button onClick
                Intent intent1 = new Intent(getApplicationContext(),BookActivity.class);
                startActivity(intent1);
            }
        });
        main2_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                        //달력 button onClick
                Intent intent2 = new Intent(getApplicationContext(),CalendarActivity.class);
                startActivity(intent2);
            }
        });
        buttonScan.setOnClickListener(new View.OnClickListener() {                          //QR button onClick
            public void onClick(View v) {
                //scan option
                qrScan.setPrompt("Scanning...");
                //qrScan.setOrientationLocked(false);
                qrScan.initiateScan();
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
    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //qrcode 가 없으면
            if (result.getContents() == null) {
                Toast.makeText(Main2Activity.this, "스캔취소", Toast.LENGTH_SHORT).show();
            } else {
                //qrcode 결과가 있으면
                Toast.makeText(Main2Activity.this, "스캔완료", Toast.LENGTH_SHORT).show();

                try {
                    //url을 토스트로 띄우는 테스트(값이 제대로 넘어가는지)
                    String re = result.getContents();
                    Toast.makeText(Main2Activity.this,re,Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}