package com.gorro.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gorro.entitys.ItemMoreInfo;
import com.gorro.sexualidad.R;

import java.util.ArrayList;

/**
 * Created by gorro on 17/05/15.
 */
public class AdapterMoreInfo extends BaseAdapter {

    private Context context;
    private int layoutResourceId;
    private ArrayList<ItemMoreInfo> data = new ArrayList<>();

    public AdapterMoreInfo(Context context, int layoutResourceId, ArrayList<ItemMoreInfo> data) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class HolderView {
        ImageView img;
        TextView txtV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View fila = convertView;
        HolderView holderView;
        if (fila == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            fila = inflater.inflate(layoutResourceId, parent, false);
            holderView = new HolderView();
            holderView.img = (ImageView) fila.findViewById(R.id.imgItemMoreInfo);
            holderView.txtV = (TextView) fila.findViewById(R.id.txtItemMoreInfo);
            fila.setTag(holderView);
        } else {
            holderView = (HolderView) fila.getTag();
        }

        ItemMoreInfo item = data.get(position);
        holderView.img.setImageResource(item.getResource());
        holderView.txtV.setText(item.getTitle());

        return fila;
    }
}
