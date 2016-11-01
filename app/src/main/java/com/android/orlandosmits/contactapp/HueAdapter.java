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
    VolleyHandler volleyHandler;
    String url = "http://192.168.1.179/api/";
    String username = "80b8a9620291a47fec92fa34484f5b";
    String putUrl = url + username + "/lights/";

    public HueAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Hue> hueArrayList){
        this.context = context;
        this.inflater = layoutInflater;
        this.hueArrayList = hueArrayList;
        volleyHandler = new VolleyHandler(context);
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
            viewHolder.hueSwitch = (Switch) convertView.findViewById(R.id.hueSwitch);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Hue hue = (Hue) hueArrayList.get(position);

        viewHolder.name.setText(hue.name);
        viewHolder.id.setText(hue.id);
        viewHolder.hueSwitch.setChecked(hue.on);

        viewHolder.hueSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    volleyHandler.turnOn(putUrl + hue.id + "/state/");
                } else {
                    volleyHandler.turnOff(putUrl + hue.id + "/state/");
                }
            }
        });

        return convertView;

    }

    private static class ViewHolder {
        public TextView id;
        public TextView name;

        public Switch hueSwitch;

    }
}
