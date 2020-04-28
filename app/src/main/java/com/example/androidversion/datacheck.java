package com.example.androidversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class datacheck extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datacheck);
        textView=(TextView)findViewById(R.id.textView);

        String url = getString(R.string.ip)+"notice/listProcess";
        url = url.replaceAll(" ", "%20");
        Log.d("kkkk",url);
        StringRequest request= new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    public void onResponse(final String response) {
                        try {
                            Log.d("kkkkeeee",response);
                            textView.append(response);
                        } catch (Exception e) {
                            Log.d("kkk2k","string");
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
    }

}
