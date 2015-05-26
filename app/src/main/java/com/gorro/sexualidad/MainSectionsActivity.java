package com.gorro.sexualidad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


public class MainSectionsActivity extends ActionBarActivity {

    Toolbar toolbar;
    ImageView imgHeader, imgNews, imgHistorys, imgFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sections);

        toolbar = (Toolbar) findViewById(R.id.toolbarheaderSections);
        imgHeader = (ImageView) findViewById(R.id.imgHeaderSections);
        imgNews = (ImageView) findViewById(R.id.imgNews);
        imgHistorys = (ImageView) findViewById(R.id.imgHistorys);
        imgFind = (ImageView) findViewById(R.id.imgFind);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        Picasso.with(MainSectionsActivity.this).load(R.drawable.localize).networkPolicy(NetworkPolicy.OFFLINE).into(imgHeader);
        Picasso.with(MainSectionsActivity.this).load(R.drawable.informate).networkPolicy(NetworkPolicy.OFFLINE).into(imgNews);
        Picasso.with(MainSectionsActivity.this).load(R.drawable.news).networkPolicy(NetworkPolicy.OFFLINE).into(imgHistorys);
        Picasso.with(MainSectionsActivity.this).load(R.drawable.encuentra).networkPolicy(NetworkPolicy.OFFLINE).into(imgFind);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_sections, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_facebook:
                break;
            case R.id.action_twitter:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMoreInfo(View v) {
        startActivity(new Intent(MainSectionsActivity.this, MoreInfoActivity.class));
    }

    public void sendNews(View v) {
        startActivity(new Intent(MainSectionsActivity.this, NewsActivity.class));
    }

    public void sendHistorys(View v) {
        startActivity(new Intent(MainSectionsActivity.this, HistorysActivity.class));
    }
}
