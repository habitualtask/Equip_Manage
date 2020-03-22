package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookClickActivity extends AppCompatActivity {

    private int click_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_click);

        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        ImageView list_image=(ImageView)findViewById(R.id.click_img);
        TextView list_title=(TextView)findViewById(R.id.click_title);
        TextView list_rent=(TextView)findViewById(R.id.click_rent);
        TextView list_return=(TextView)findViewById(R.id.click_return);
        TextView list_state=(TextView)findViewById(R.id.click_state);
        TextView list_category=(TextView)findViewById(R.id.click_category);
        TextView list_company=(TextView)findViewById(R.id.click_company);
        TextView list_serial=(TextView)findViewById(R.id.click_serial);
        TextView list_date=(TextView)findViewById(R.id.click_date);
        TextView list_price=(TextView)findViewById(R.id.click_price);
        TextView list_remark=(TextView)findViewById(R.id.click_remark);

        click_img=Integer.parseInt(intent.getStringExtra("list_image"));
        list_image.setImageResource(click_img);
        list_title.setText(intent.getStringExtra("list_title"));
        list_rent.setText(intent.getStringExtra("list_rent"));
        list_return.setText(intent.getStringExtra("list_return"));
        list_state.setText(intent.getStringExtra("list_state"));
        list_category.setText(intent.getStringExtra("list_category"));
        list_company.setText(intent.getStringExtra("list_company"));
        list_serial.setText(intent.getStringExtra("list_serial"));
        list_date.setText(intent.getStringExtra("list_date"));
        list_price.setText(intent.getStringExtra("list_price"));
        list_remark.setText(intent.getStringExtra("list_remark"));
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
