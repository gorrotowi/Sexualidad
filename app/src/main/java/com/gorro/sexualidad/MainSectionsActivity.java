package com.gorro.sexualidad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
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

        Picasso.with(MainSectionsActivity.this).load(R.drawable.header).into(imgHeader, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                imgHeader.setBackgroundColor(getResources().getColor(R.color.primary));
            }
        });

        Picasso.with(MainSectionsActivity.this).load(R.drawable.news).into(imgNews);
        Picasso.with(MainSectionsActivity.this).load(R.drawable.historys).into(imgHistorys);
        Picasso.with(MainSectionsActivity.this).load(R.drawable.localize).into(imgFind);


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
}
