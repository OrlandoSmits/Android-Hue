package com.android.orlandosmits.bridge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.orlandosmits.handler.DatabaseHandler;
import com.android.orlandosmits.hue.R;

import java.util.ArrayList;

/**
 * Created by Orlando Smits on 4-11-2016.
 */

public class BridgeAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<Bridge> bridgeArrayList;
    DatabaseHandler dbHandler;

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
    public Object getItem(int position)
    {
        return bridgeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.bridge_listview_row, null);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.bridgeName);
            viewHolder.ipadress = (TextView) convertView.findViewById(R.id.bridgeIp);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        dbHandler = new DatabaseHandler(context);
        dbHandler.getBridges(bridgeArrayList);

        Bridge bridge = bridgeArrayList.get(position);

        viewHolder.name.setText(bridge.getName());
        viewHolder.ipadress.setText(bridge.getIpadress());

        return convertView;
    }

    private static class ViewHolder {
        public TextView name;
        public TextView ipadress;
    }
}
