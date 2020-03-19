package com.example.androidversion;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchClickActivity extends Activity {

    private int click_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_click);
        Intent intent = getIntent();
        ImageView list_image=(ImageView)findViewById(R.id.click_img);
        TextView list_title=(TextView)findViewById(R.id.click_title);
        TextView list_desc=(TextView)findViewById(R.id.click_desc);

        click_img=Integer.parseInt(intent.getStringExtra("list_image"));
        list_image.setImageResource(click_img);
        list_title.setText(intent.getStringExtra("list_title"));
        list_desc.setText(intent.getStringExtra("list_desc"));
    }
}
