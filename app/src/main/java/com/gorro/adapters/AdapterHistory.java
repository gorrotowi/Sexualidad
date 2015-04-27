package com.gorro.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gorro.entitys.ItemHistory;
import com.gorro.sexualidad.R;

import java.util.ArrayList;

/**
 * Created by gorro on 26/04/15.
 */
public class AdapterHistory extends BaseAdapter {

    private Context context;
    private int layoutResourceId;
    private ArrayList<ItemHistory> data = new ArrayList<>();

    public AdapterHistory(Context context, int layoutResourceId, ArrayList<ItemHistory> data) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class HolderView {
        TextView txtHystory;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View fila = convertView;
        HolderView holder = null;
        if (fila == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            fila = inflater.inflate(layoutResourceId, parent, false);
            holder = new HolderView();
            holder.txtHystory = (TextView) fila.findViewById(R.id.txtHistoryCard);
            fila.setTag(holder);
        } else {
            holder = (HolderView) fila.getTag();
        }

        ItemHistory item = data.get(position);
        holder.txtHystory.setText(item.getHistory());
        return fila;
    }
}
