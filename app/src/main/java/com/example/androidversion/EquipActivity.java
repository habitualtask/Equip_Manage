package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EquipActivity extends AppCompatActivity {
    private ListView equip_list;            //빈 리스트
    private SearchAdapter adapter;          //리스트뷰에 연결할 어댑터
    private ArrayList<Equipment> EquipList;      //전체값리스트(데이터넣은리스트변수)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equip);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        EquipList = new ArrayList<Equipment>();                 //리스트생성
        equip_list=(ListView)findViewById(R.id.equip_list);
        equip_setList();
        adapter=new SearchAdapter(EquipList,this);      //list에 연동될 어뎁터생성
        equip_list.setAdapter(adapter);                         //리스트뷰에 어뎁터연결

        equip_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent10 =new Intent(getApplicationContext(),SearchClickActivity.class);
                intent10.putExtra("list_image",Integer.toString(EquipList.get(i).getList_image()));
                intent10.putExtra("list_title",EquipList.get(i).getList_title());
                intent10.putExtra("list_category",EquipList.get(i).getList_category());
                intent10.putExtra("list_company",EquipList.get(i).getList_company());
                intent10.putExtra("list_serial",EquipList.get(i).getList_serial());
                intent10.putExtra("list_date",EquipList.get(i).getList_date());
                intent10.putExtra("list_price",EquipList.get(i).getList_price());
                intent10.putExtra("list_remark",EquipList.get(i).getList_remark());
                startActivity(intent10);
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

    private void equip_setList(){
        EquipList.add(new Equipment(R.drawable.hdmi,"HDMI케이블","장비","SONY","2010-1111","2019/12/25","5,000","크리스마스ㅎㅎ"));
        EquipList.add(new Equipment(R.drawable.dell,"모니터01","장비","DELL","2111-1111","2016/11/2","330,000","없음"));
    }
}
