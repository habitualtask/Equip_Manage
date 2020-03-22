package com.example.androidversion;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchClickActivity extends AppCompatActivity {

    private int click_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_click);

        Toolbar toolbar=(Toolbar)findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        ImageView list_image=(ImageView)findViewById(R.id.click_img);
        TextView list_title=(TextView)findViewById(R.id.click_title);
        TextView list_category=(TextView)findViewById(R.id.click_category);

        click_img=Integer.parseInt(intent.getStringExtra("list_image"));
        list_image.setImageResource(click_img);
        list_title.setText(intent.getStringExtra("list_title"));
        list_category.setText(intent.getStringExtra("list_category"));
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
