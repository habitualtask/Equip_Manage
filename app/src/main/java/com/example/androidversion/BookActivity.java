package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private ListView book_list;            //빈 리스트
    private SearchAdapter adapter;          //리스트뷰에 연결할 어댑터
    private ArrayList<Equipment> BookList;      //전체값리스트(데이터넣은리스트변수)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        BookList = new ArrayList<Equipment>();
        book_list = (ListView)findViewById(R.id.book_list);
        book_setList();
        adapter=new SearchAdapter(BookList,this);
        book_list.setAdapter(adapter);

        book_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent10 =new Intent(getApplicationContext(),SearchClickActivity.class);
                intent10.putExtra("list_image",Integer.toString(BookList.get(i).getList_image()));
                intent10.putExtra("list_title",BookList.get(i).getList_title());
                intent10.putExtra("list_category",BookList.get(i).getList_category());
                intent10.putExtra("list_company",BookList.get(i).getList_company());
                intent10.putExtra("list_serial",BookList.get(i).getList_serial());
                intent10.putExtra("list_date",BookList.get(i).getList_date());
                intent10.putExtra("list_price",BookList.get(i).getList_price());
                intent10.putExtra("list_remark",BookList.get(i).getList_remark());
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
    private void book_setList(){
        BookList.add(new Equipment(R.drawable.nodejs,"도서 - DO IT NodeJS!!!","도서","한빛","ISBN 979-11-8737-080-2","2020/3/10","32,000","없음"));
        BookList.add(new Equipment(R.drawable.network,"도서 - 네트워크해킹과보안","도서","한빛","ISBN 979-11-5664-227-0","2020/3/7","26,000","없음"));
    }
}
