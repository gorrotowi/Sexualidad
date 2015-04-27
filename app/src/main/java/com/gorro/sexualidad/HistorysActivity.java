package com.gorro.sexualidad;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
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
        toolbar.setBackground(getResources().getDrawable(R.drawable.historys));
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHideOnContentScrollEnabled(true);
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
}
