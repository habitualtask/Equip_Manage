package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    Button history_searchbtn;
    private ListView history_list;              //빈 리스트
    private SearchAdapter adapter;              //리스트뷰에 연결할 어뎁터
    private ArrayList<Equipment> HistoryList;   //전체값리스트(데이터넣은 리스트변수)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        history_searchbtn=(Button)findViewById(R.id.history_searchbtn);
        Spinner spinner_startYear=(Spinner)findViewById(R.id.history_startYear);
        Spinner spinner_startMonth=(Spinner)findViewById(R.id.history_startMonth);
        Spinner spinner_startDay=(Spinner)findViewById(R.id.history_startDay);
        Spinner spinner_endYear=(Spinner)findViewById(R.id.history_endYear);
        Spinner spinner_endMonth=(Spinner)findViewById(R.id.history_endMonth);
        Spinner spinner_endDay=(Spinner)findViewById(R.id.history_endDay);

        HistoryList=new ArrayList<Equipment>();
        history_list=(ListView)findViewById(R.id.history_list);
        history_setList();
        adapter=new SearchAdapter(HistoryList,this);
        history_list.setAdapter(adapter);

        history_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent10 =new Intent(getApplicationContext(),SearchClickActivity.class);
                intent10.putExtra("list_image",Integer.toString(HistoryList.get(i).getList_image()));
                intent10.putExtra("list_title",HistoryList.get(i).getList_title());
                intent10.putExtra("list_rent",HistoryList.get(i).getList_rent());
                intent10.putExtra("list_return",HistoryList.get(i).getList_return());
                intent10.putExtra("list_state",HistoryList.get(i).getList_state());
                intent10.putExtra("list_category",HistoryList.get(i).getList_category());
                intent10.putExtra("list_company",HistoryList.get(i).getList_company());
                intent10.putExtra("list_serial",HistoryList.get(i).getList_serial());
                intent10.putExtra("list_date",HistoryList.get(i).getList_date());
                intent10.putExtra("list_price",HistoryList.get(i).getList_price());
                intent10.putExtra("list_remark",HistoryList.get(i).getList_remark());
                startActivity(intent10);
            }
        });

        history_searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"기록이없습니다",Toast.LENGTH_SHORT).show();
                //날짜에 맞는 리스트를 뽑아낼 것
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
    private void history_setList(){
        HistoryList.add(new Equipment(R.drawable.hdmi,"HDMI케이블","연체","2019-12.25~","2019-01-03","D+81","장비","SONY","2010-1111","2019/12/25","5,000","크리스마스ㅎㅎ"));
        HistoryList.add(new Equipment(R.drawable.dell,"모니터01","대여중","2020-03-21~","2020-04-01","D-8","장비","DELL","2111-1111","2016/11/2","330,000","없음"));
    }
}
