package com.gorro.sexualidad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.gorro.adapters.AdapterHistory;
import com.gorro.entitys.ItemHistory;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;


public class HistorysActivity extends ActionBarActivity implements ObservableScrollViewCallbacks {

    ObservableListView listHistorys;
    AdapterHistory adapter;
    Toolbar toolbar;
    private View mImageView;
    private View mListBackgroundView;
    private int mParallaxImageHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historys);

        listHistorys = (ObservableListView) findViewById(R.id.listHistorys);
        mImageView = findViewById(R.id.imgHeaderHistory);
        toolbar = (Toolbar) findViewById(R.id.toolbarHistorys);
        toolbar.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.primary)));

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);

        listHistorys.setScrollViewCallbacks(this);
        View paddingView = new View(this);
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                mParallaxImageHeight);
        paddingView.setLayoutParams(lp);

        paddingView.setClickable(true);

        listHistorys.addHeaderView(paddingView);
        adapter = new AdapterHistory(HistorysActivity.this, R.layout.item_history, getData());
        listHistorys.setAdapter(adapter);
//        toolbar.setBackground(getResources().getDrawable(R.drawable.historys));

        mListBackgroundView = findViewById(R.id.list_background);
        final View contentView = getWindow().getDecorView().findViewById(android.R.id.content);
        contentView.post(new Runnable() {
            @Override
            public void run() {
                // mListBackgroundView's should fill its parent vertically
                // but the height of the content view is 0 on 'onCreate'.
                // So we should get it with post().
                mListBackgroundView.getLayoutParams().height = contentView.getHeight();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private ArrayList<ItemHistory> getData() {
        final ArrayList<ItemHistory> item = new ArrayList<>();
        item.add(new ItemHistory(getString(R.string.loremipsum)));
        item.add(new ItemHistory(getString(R.string.loremipsum)));
        item.add(new ItemHistory(getString(R.string.loremipsum)));
        item.add(new ItemHistory(getString(R.string.loremipsum)));
        item.add(new ItemHistory(getString(R.string.loremipsum)));
        item.add(new ItemHistory(getString(R.string.loremipsum)));
        item.add(new ItemHistory(getString(R.string.loremipsum)));
        return item;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_historys, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (item.getItemId() == R.id.action_add) {
            newHistory();
        }

        return super.onOptionsItemSelected(item);
    }

    private void newHistory() {
        new MaterialDialog.Builder(HistorysActivity.this)
                .title(R.string.writeYourHistory)
                .customView(R.layout.history_dialog, true)
                .positiveText("Enviar")
                .negativeText("Cancelar")
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        super.onPositive(dialog);
                        String history = ((EditText) dialog.findViewById(R.id.edtxHistoryDialog)).getText().toString();
                        if (history.length() > 10) {
                            sendHistory(history);
                        } else {
                            Toast.makeText(HistorysActivity.this, "Tu historia es muy corta", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        super.onNegative(dialog);
                        dialog.dismiss();
                    }
                })
                .show();
    }

    private void sendHistory(String history) {
        Toast.makeText(HistorysActivity.this, "Tu historia ha sido enviada", Toast.LENGTH_SHORT).show();
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
