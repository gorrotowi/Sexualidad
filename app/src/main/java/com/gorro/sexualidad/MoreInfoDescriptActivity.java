package com.gorro.sexualidad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;

import com.github.ksoichiro.android.observablescrollview.ObservableGridView;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.gorro.adapters.AdapterMoreInfoDescr;
import com.gorro.entitys.ItemMoreInfo;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;


public class MoreInfoDescriptActivity extends ActionBarActivity implements ObservableScrollViewCallbacks {

    ObservableGridView listHistorys;
    AdapterMoreInfoDescr adapter;
    Toolbar toolbar;
    private View mImageView;
    private View mListBackgroundView;
    private int mParallaxImageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info_descript);

        listHistorys = (ObservableGridView) findViewById(R.id.listMoreInfoDesc);
        mImageView = findViewById(R.id.imgHeaderMoreInfoDescr);
        toolbar = (Toolbar) findViewById(R.id.toolbarMoreInfoDescr);
        toolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(1, getResources().getColor(R.color.primary)));

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height_thin);

        listHistorys.setScrollViewCallbacks(this);
        View paddingView = new View(this);
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                mParallaxImageHeight);
        paddingView.setLayoutParams(lp);

        paddingView.setClickable(true);

//        listHistorys.addHeaderView(paddingView);
        adapter = new AdapterMoreInfoDescr(MoreInfoDescriptActivity.this, R.layout.item_more_info_descr, getData());
        listHistorys.setAdapter(adapter);

        mListBackgroundView = findViewById(R.id.list_backgroundMoreInfoDescr);
        final View contentView = getWindow().getDecorView().findViewById(android.R.id.content);
        contentView.post(new Runnable() {
            @Override
            public void run() {
                mListBackgroundView.getLayoutParams().height = contentView.getHeight();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private ArrayList<ItemMoreInfo> getData() {
        final ArrayList<ItemMoreInfo> item = new ArrayList<>();
        item.add(new ItemMoreInfo(R.drawable.sexo, "Identidad"));
        item.add(new ItemMoreInfo(R.drawable.genero, "Orientación"));
        item.add(new ItemMoreInfo(R.drawable.sexo, "Identidad"));
        item.add(new ItemMoreInfo(R.drawable.genero, "Orientación"));
        item.add(new ItemMoreInfo(R.drawable.sexo, "Identidad"));
        item.add(new ItemMoreInfo(R.drawable.genero, "Orientación"));
        item.add(new ItemMoreInfo(R.drawable.sexo, "Identidad"));
        item.add(new ItemMoreInfo(R.drawable.genero, "Orientación"));
        item.add(new ItemMoreInfo(R.drawable.sexo, "Identidad"));
        item.add(new ItemMoreInfo(R.drawable.genero, "Orientación"));
        item.add(new ItemMoreInfo(R.drawable.sexo, "Identidad"));
        item.add(new ItemMoreInfo(R.drawable.genero, "Orientación"));
        return item;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_more_info_descript, menu);
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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(listHistorys.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.primary);
        float alpha = 1 - (float) Math.max(0, mParallaxImageHeight - scrollY) / mParallaxImageHeight;
        toolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mImageView, -scrollY / 2);

        // Translate list background
        ViewHelper.setTranslationY(mListBackgroundView, Math.max(0, -scrollY + mParallaxImageHeight));
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}
