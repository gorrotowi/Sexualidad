package com.gorro.sexualidad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.json.XML;


public class NewsActivity extends ActionBarActivity {


    RequestQueue rq;
    StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        rq = Volley.newRequestQueue(this);

        stringRequest = new StringRequest("http://blog-gorrotowi.rhcloud.com/rss/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response rss", "-------------------------------------------------");
//                Log.e("response rss", response);
                try {
                    JSONObject json = XML.toJSONObject("<?xml version=\"1.0\"?>"+response);
                    Log.e("json", json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.e("response rss", "-------------------------------------------------");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        rq.add(stringRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
