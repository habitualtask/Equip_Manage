package com.example.androidversion;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {
    Button search_searchbtn;
    private ListView search_list;          //검색보여줄 리스트변수 (빈리스트)
    private SearchAdapter adapter;      //리스트뷰에 연결할 어뎁터
    private ArrayList<Equipment> list;          //데이터 넣은 리스트변수 (전체값리스트)
    private EditText search_keyword;    //검색어 입력할 input창
    private ArrayList<Equipment> arraylist;     //검색해서 걸러낸 리스트
    //search_category의 전체,도서,장비 따라 선택가능하게끔 하는 기능 추가할 것
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Spinner spinner_category=(Spinner)findViewById(R.id.search_category);
        search_keyword=(EditText)findViewById(R.id.search_keyword);
        search_list=(ListView)findViewById(R.id.search_list);
        search_searchbtn=(Button)findViewById(R.id.search_searchbtn);
        list = new ArrayList<Equipment>();     //list생성
        settingList();                      //검색에 사용될 데이터 미리 저장
        arraylist=new ArrayList<Equipment>();  //리스트의 모든 데이터를 arraylist에 복사
        arraylist.addAll(list);             //복사본

        adapter=new SearchAdapter(list,this);   //list에 연동될 어뎁터생성
        search_list.setAdapter(adapter);                //리스트뷰에 어뎁터연결

        search_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent10 =new Intent(getApplicationContext(),SearchClickActivity.class);
                intent10.putExtra("list_image",Integer.toString(list.get(i).getList_image()));
                intent10.putExtra("list_title",list.get(i).getList_title());
                intent10.putExtra("list_category",list.get(i).getList_category());
                intent10.putExtra("list_company",list.get(i).getList_company());
                intent10.putExtra("list_serial",list.get(i).getList_serial());
                intent10.putExtra("list_date",list.get(i).getList_date());
                intent10.putExtra("list_price",list.get(i).getList_price());
                intent10.putExtra("list_remark",list.get(i).getList_remark());
                startActivity(intent10);
            }
        });
        search_keyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                search_searchbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String text=search_keyword.getText().toString();
                        search(text);
                        //키워드와 카테고리를 기반으로 쿼리를 보내서 결과를 받아 비품목록을 뿌려줘야함
                    }
                });
            }
        });
    }

    private void search(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        list.clear();       //리스트 새로 뿌려주기
        if(charText.length()==0){
            list.addAll(arraylist);
        }else{
            for(int i=0;i<arraylist.size();i++){ //list의 모든 데이터 검색
                //arraylist의 모든 데이터에 charText가 포함되어있으면 true
                if(arraylist.get(i).getList_title().toLowerCase().contains(charText)){
                    list.add(arraylist.get(i)); //검색된 데이터를 리스트에 추가
                }
            }
        }adapter.notifyDataSetChanged();    //list데이터가 변경되었음므로 어뎁터 갱신 > 화면에 보냄
    }
    private void settingList() {
        list.add(new Equipment(R.drawable.vim,"빔프로젝트","대여중","2020-03-18-","2020-03-30","D-7","장비","SONY","2143-1001","2020/3/10","250,000","없음"));
        list.add(new Equipment(R.drawable.dell,"모니터01","대여중","2020-03-18-","2020-03-30","D-7","장비","DELL","2111-1111","2016/11/2","330,000","없음"));
        list.add(new Equipment(R.drawable.lg,"모니터02","대여가능","","","","장비","LG","2111-1112","2015/5/4","278,000","없음"));
        list.add(new Equipment(R.drawable.refrigerator,"냉장고","대여불가","","","","기타","삼성","4001-0001","2016/11/11","600,000","대여불가"));
        list.add(new Equipment(R.drawable.hdmi,"HDMI케이블","연체","2019-12.25~","2019-01-03","D+81","장비","SONY","2010-1111","2019/12/25","5,000","크리스마스ㅎㅎ"));
        list.add(new Equipment(R.drawable.nodejs,"도서 - DO IT NodeJS!!!","대여중","2020-03-21~","2020-04-01","D-8","도서","한빛","ISBN 979-11-8737-080-2","2020/3/10","32,000","없음"));
        list.add(new Equipment(R.drawable.network,"도서 - 네트워크해킹과보안","연체","2020-01-01","2020-01-14","D+66","도서","한빛","ISBN 979-11-5664-227-0","2020/3/7","26,000","없음"));
        list.add(new Equipment(R.drawable.cucku,"밥솥","대여불가","","","","기타","LG","4002-0214","2014/2/10","120,000","대여불가"));
        list.add(new Equipment(R.drawable.print,"프린트","대여불가","","","","장비","대구가톨릭대학교","4001-0003","2015/10/8","모름","대여불가"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_search, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.action_mypage:
                Intent intent6 =new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent6);
                finish();
                return true;

            case R.id.action_setting:
                Intent intent3 =new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent3);
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