//package com.android.orlandosmits.contactapp;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
///**
// * Created by Orlando Smits on 6-9-2016.
// */
//public class UserAdapter extends BaseAdapter {
//
//    Context mContext;
//    LayoutInflater mInflator;
//    ArrayList mUserArrayList;
//
//    public UserAdapter(Context context, LayoutInflater layoutInflater, ArrayList<User> userArrayList)
//    {
//        mContext = context;
//        mInflator = layoutInflater;
//        mUserArrayList = userArrayList;
//    }
//
//    @Override
//    public int getCount() {
//        int size = mUserArrayList.size();
//        Log.i("getCount()", "=" + size);
//        return size;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        Log.i("getItem()", "");
//        return mUserArrayList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) { return position; }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        ViewHolder viewHolder;
//        if (convertView == null) {
//
//            convertView = mInflator.inflate(R.layout.listview_row, null);
//
//            viewHolder = new ViewHolder();
//            viewHolder.id = (TextView) convertView.findViewById(R.id.hueId);
//            viewHolder.state = (TextView) convertView.findViewById(R.id.hueState);
//
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//
//        User user = (User) mUserArrayList.get(position);
//
//        viewHolder.id.setText(user.getFullName());
//        viewHolder.email.setText(user.mEmail);
//        Picasso.with(mContext).load(user.mImage).into(viewHolder.imageView);
//
//        return convertView;
//    }
//
//    private static class ViewHolder {
//        public TextView id;
//        public TextView state;
//
//    }
//}
