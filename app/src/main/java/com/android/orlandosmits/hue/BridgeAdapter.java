package com.android.orlandosmits.hue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Orlando Smits on 4-11-2016.
 */

public class BridgeAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList bridgeArrayList;

    public BridgeAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Bridge> bridgeArrayList){
        this.context = context;
        this.inflater = layoutInflater;
        this.bridgeArrayList = bridgeArrayList;
    }

    @Override
    public int getCount() {
        int size = bridgeArrayList.size();
        return size;
    }

    @Override
    public Object getItem(int position) {
        return bridgeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
