package com.android.orlandosmits.hue;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @Author: Orlando Smits
 * @Author: Luuk Ros
 */

public class HueAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList hueArrayList;


    public HueAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Hue> hueArrayList){
        this.context = context;
        this.inflater = layoutInflater;
        this.hueArrayList = hueArrayList;
    }

    // Get the size of the ArrayList
    @Override
    public int getCount() {
        int size = hueArrayList.size();
        Log.i("getCount()", "=" + size);
        return size;
    }

    // Get the item on a specific position in the ArrayList
    @Override
    public Object getItem(int position) {
        return hueArrayList.get(position);
    }

    // Return the position of an item
    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // Create a ViewHolder attribute
        ViewHolder viewHolder;

        if(convertView == null) {

            // Bind the convertView to a custom row called listview_row
            convertView = inflater.inflate(R.layout.listview_row, null);

            // Create a new ViewHolder object
            viewHolder = new ViewHolder();

            // Bind the id attribute to the hueId TextView
            viewHolder.id = (TextView) convertView.findViewById(R.id.hueId);

            // Bind the name attribute to the hueName TextView
            viewHolder.name = (TextView) convertView.findViewById(R.id.hueName);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Bind Hue object to the hue in the given position on the ArrayList
        Hue hue = (Hue) hueArrayList.get(position);

        // Set the name to the Hue Name
        viewHolder.name.setText(hue.name);

        // Set the id tot the Hue Id
        viewHolder.id.setText(String.valueOf(hue.on));


        return convertView;

    }

    private static class ViewHolder {
        public TextView id;
        public TextView name;
    }
}
