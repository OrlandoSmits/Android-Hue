package com.android.orlandosmits.contactapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.android.orlandosmits.contactapp.Hue;
import com.android.volley.Request;

import java.util.ArrayList;

/**
 * Created by Orlando Smits on 29-10-2016.
 */

public class HueAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList hueArrayList;
    Hue hue;


    public HueAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Hue> hueArrayList){
        this.context = context;
        this.inflater = layoutInflater;
        this.hueArrayList = hueArrayList;
    }

    @Override
    public int getCount() {
        int size = hueArrayList.size();
        Log.i("getCount()", "=" + size);
        return size;
    }

    @Override
    public Object getItem(int position) {
        return hueArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null) {

            convertView = inflater.inflate(R.layout.listview_row, null);

            viewHolder = new ViewHolder();
            viewHolder.id = (TextView) convertView.findViewById(R.id.hueId);
            viewHolder.name = (TextView) convertView.findViewById(R.id.hueName);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Hue hue = (Hue) hueArrayList.get(position);

        viewHolder.name.setText(hue.name);
        viewHolder.id.setText(String.valueOf(hue.on));
        return convertView;

    }

    private static class ViewHolder {
        public TextView id;
        public TextView name;

        public Switch hueSwitch;

    }
}
