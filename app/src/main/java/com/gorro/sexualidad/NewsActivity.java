package com.gorro.sexualidad;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.gorro.adapters.AdapterNews;
import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class NewsActivity extends ActionBarActivity {

    ViewPager viewPager;
    AdapterNews adapterNews;
    Toolbar toolbar;
    ProgressDialog progressDialog;
    ParallaxPagerTransformer parallaxPagerTransformer;

    RequestQueue rq;
    JsonObjectRequest jsonRequest;
    String url = "http://ed-usex.rhcloud.com/ghost/api/v0.1/posts/?status=published";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        viewPager = (ViewPager) findViewById(R.id.pagerNews);
        toolbar = (Toolbar) findViewById(R.id.toolbarNews);
        parallaxPagerTransformer = new ParallaxPagerTransformer((R.id.imgNewBackground));
        progressDialog = new ProgressDialog(NewsActivity.this);
        adapterNews = new AdapterNews(getSupportFragmentManager());

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressDialog.setMessage("Espera un momento por favor");

//        parallaxPagerTransformer.setBorder(30);

        viewPager.setBackgroundColor(getResources().getColor(R.color.background_material_dark));
        viewPager.setPageTransformer(false, parallaxPagerTransformer);

        adapterNews.setPager(viewPager);

        rq = Volley.newRequestQueue(this);

        makePetition();

    }

    private void makePetition() {
        progressDialog.show();
        jsonRequest = new JsonObjectRequest(Request.Method.GET, url, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                Log.e("json", response.toString());
                progressDialog.dismiss();
                try {
                    JSONArray jsonArray = response.getJSONArray("posts");

                    //--------------------------
                    Bundle params = new Bundle();
                    Document doc = Jsoup.parse(jsonArray.getJSONObject(0).getString("html"));
                    Elements imgElements = doc.getElementsByTag("img");
                    if (imgElements.isEmpty()) {
                        params.putString("imagebackground", "");
                    } else {
                        params.putString("imagebackground", imgElements.get(0).attr("src"));
                    }
                    params.putString("title", jsonArray.getJSONObject(0).getString("title"));
                    params.putString("content", jsonArray.getJSONObject(0).getString("html"));
                    params.putInt("color", getResources().getColor(R.color.backgroundcyan));
                    FragmentNews news = new FragmentNews();
                    news.setArguments(params);
                    //--------------------------
                    //--------------------------
                    Bundle params1 = new Bundle();
                    Document doc1 = Jsoup.parse(jsonArray.getJSONObject(1).getString("html"));
                    Elements imgElements1 = doc1.getElementsByTag("img");
                    if (imgElements1.isEmpty()) {
                        params1.putString("imagebackground", "");
                    } else {
                        params1.putString("imagebackground", imgElements1.get(0).attr("src"));
                    }
                    params1.putString("title", jsonArray.getJSONObject(1).getString("title"));
                    params1.putString("content", jsonArray.getJSONObject(1).getString("html"));
                    params1.putInt("color", getResources().getColor(R.color.backgroundgreen));
                    FragmentNews news1 = new FragmentNews();
                    news1.setArguments(params1);
                    //--------------------------
                    //--------------------------
                    Bundle params2 = new Bundle();
                    Document doc2 = Jsoup.parse(jsonArray.getJSONObject(2).getString("html"));
                    Elements imgElements2 = doc2.getElementsByTag("img");
                    if (imgElements2.isEmpty()) {
                        params2.putString("imagebackground", "");
                    } else {
                        params2.putString("imagebackground", imgElements2.get(0).attr("src"));
                    }
                    params2.putString("title", jsonArray.getJSONObject(2).getString("title"));
                    params2.putString("content", jsonArray.getJSONObject(2).getString("html"));
                    params2.putInt("color", getResources().getColor(R.color.backgroundorange));
                    FragmentNews news2 = new FragmentNews();
                    news2.setArguments(params2);
                    //--------------------------
                    //--------------------------
                    Bundle params3 = new Bundle();
                    Document doc3 = Jsoup.parse(jsonArray.getJSONObject(3).getString("html"));
                    Elements imgElements3 = doc3.getElementsByTag("img");
                    if (imgElements3.isEmpty()) {
                        params3.putString("imagebackground", "");
                    } else {
                        params3.putString("imagebackground", imgElements3.get(0).attr("src"));
                    }
                    params3.putString("title", jsonArray.getJSONObject(3).getString("title"));
                    params3.putString("content", jsonArray.getJSONObject(3).getString("html"));
                    params3.putInt("color", getResources().getColor(R.color.backgroundpurple));
                    FragmentNews news3 = new FragmentNews();
                    news3.setArguments(params3);
                    //--------------------------
                    //--------------------------
                    Bundle params4 = new Bundle();
                    Document doc4 = Jsoup.parse(jsonArray.getJSONObject(4).getString("html"));
                    Elements imgElements4 = doc4.getElementsByTag("img");
                    if (imgElements4.isEmpty()) {
                        params4.putString("imagebackground", "");
                    } else {
                        params4.putString("imagebackground", imgElements4.get(0).attr("src"));
                    }
                    params4.putString("title", jsonArray.getJSONObject(4).getString("title"));
                    params4.putString("content", jsonArray.getJSONObject(4).getString("html"));
                    params4.putInt("color", getResources().getColor(R.color.backgroundred));
                    FragmentNews news4 = new FragmentNews();
                    news4.setArguments(params4);
                    //--------------------------

                    adapterNews.add(news);
                    adapterNews.add(news1);
                    adapterNews.add(news2);
                    adapterNews.add(news3);
                    adapterNews.add(news4);
                    viewPager.setAdapter(adapterNews);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(NewsActivity.this, "Verifica tu conexión a internet o intenta nuevamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        rq.add(jsonRequest);
    }

}
