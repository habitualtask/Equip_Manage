package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
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
import java.util.List;
import java.util.Map;

public class EquipActivity extends AppCompatActivity {
    private ListView equip_list;            //빈 리스트
    private BookAdapter adapter;          //리스트뷰에 연결할 어댑터
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

        String url = getString(R.string.ip)+"notice/listProcess";
        url = url.replaceAll(" ", "%20");

        StringRequest request= new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    public void onResponse(final String response) {
                        try {
                            JsonParser parser = new JsonParser();
                            JsonObject jsonObj = (JsonObject)parser.parse(response);
                            Log.d("kkkk1",response);
                            JsonArray jsonArray = (JsonArray) jsonObj.get("data");
                            EquipList = new ArrayList<Equipment>();
                            for(int i=0;i<jsonArray.size();i++){
                                JsonObject object = (JsonObject) jsonArray.get(i);
                                Integer list_image = object.get("사진").getAsInt();
                                String list_title = object.get("헤진이가주는 변수이름").getAsString();
                                String list_state = object.get("notice_title").getAsString();
                                String list_rent = object.get("user_name").getAsString();
                                String list_return = object.get("user_name").getAsString();
                                String list_dday = object.get("user_name").getAsString();
                                String list_category = object.get("분류").getAsString();
                                String list_company = object.get("회사").getAsString();
                                String list_serial = object.get("시리얼 번호").getAsString();
                                String list_date = object.get("날짜?").getAsString();
                                String list_price = object.get("가격").getAsString();
                                String list_remark = object.get("비고").getAsString();
                                EquipList.add(new Equipment(list_image,list_title,list_state,list_rent,list_return,list_dday,list_category,list_company,list_serial,list_date,list_price,list_remark));
                            }

                            adapter = new BookAdapter(EquipList,this);
                            equip_list.setAdapter(adapter);

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
        Volley.newRequestQueue(this).add(request);


        adapter=new BookAdapter(EquipList,this);      //list에 연동될 어뎁터생성
        equip_list.setAdapter(adapter);                         //리스트뷰에 어뎁터연결

        equip_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent10 =new Intent(getApplicationContext(),BookClickActivity.class);
                intent10.putExtra("list_image",Integer.toString(EquipList.get(i).getList_image()));
                intent10.putExtra("list_title",EquipList.get(i).getList_title());
                intent10.putExtra("list_rent",EquipList.get(i).getList_rent());                 //빌린날짜
                intent10.putExtra("list_return",EquipList.get(i).getList_return());             //반납예정일
                intent10.putExtra("list_state",EquipList.get(i).getList_state());               //상태(대여중,연체)
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


}
