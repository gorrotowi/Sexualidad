package com.gorro.sexualidad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.gorro.adapters.AdapterHistory;
import com.gorro.entitys.ItemHistory;

import java.util.ArrayList;


public class HistorysActivity extends ActionBarActivity {

    ListView listHistorys;
    AdapterHistory adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historys);

        listHistorys = (ListView) findViewById(R.id.listHistorys);
        toolbar = (Toolbar) findViewById(R.id.toolbarHistorys);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new AdapterHistory(HistorysActivity.this, R.layout.item_history, getData());
        listHistorys.setAdapter(adapter);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
