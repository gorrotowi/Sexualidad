package com.gorro.sexualidad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.gorro.adapters.AdapterMoreInfo;
import com.gorro.entitys.ItemMoreInfo;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;


public class MoreInfoActivity extends ActionBarActivity implements ObservableScrollViewCallbacks {

    ObservableListView listHistorys;
    AdapterMoreInfo adapter;
    Toolbar toolbar;
    private View mImageView;
    private View mListBackgroundView;
    private int mParallaxImageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        listHistorys = (ObservableListView) findViewById(R.id.listMoreInfo);
        mImageView = findViewById(R.id.imgHeaderMoreInfo);
        toolbar = (Toolbar) findViewById(R.id.toolbarMoreInfo);
        toolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(1, getResources().getColor(R.color.accent)));
        toolbar.setTitle("");

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height_thin);

        listHistorys.setScrollViewCallbacks(this);
        View paddingView = new View(this);
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                120);
        paddingView.setLayoutParams(lp);

        paddingView.setClickable(true);

        listHistorys.addHeaderView(paddingView);
        adapter = new AdapterMoreInfo(MoreInfoActivity.this, R.layout.item_more_info, getData());
        listHistorys.setAdapter(adapter);

        mListBackgroundView = findViewById(R.id.list_backgroundMoreInfo);
        final View contentView = getWindow().getDecorView().findViewById(android.R.id.content);
        contentView.post(new Runnable() {
            @Override
            public void run() {
                mListBackgroundView.getLayoutParams().height = contentView.getHeight();
            }
        });

        listHistorys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtv = (TextView) view.findViewById(R.id.txtItemMoreInfo);
                startActivity(new Intent(MoreInfoActivity.this, MoreInfoDescriptActivity.class).putExtra("title", txtv.getText().toString()));
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private ArrayList<ItemMoreInfo> getData() {
        final ArrayList<ItemMoreInfo> item = new ArrayList<>();
        item.add(new ItemMoreInfo(R.drawable.identity, "Identidad"));
        item.add(new ItemMoreInfo(R.drawable.orientation, "Orientación"));
        return item;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(listHistorys.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.accent);
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
