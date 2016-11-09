package com.android.orlandosmits.bridge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.orlandosmits.hue.R;

import java.util.ArrayList;

public class BridgeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView mBridgeListView;
    BridgeAdapter mBridgeAdapter;
    ArrayList<Bridge> bridgeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge);


        mBridgeListView = (ListView) findViewById(R.id.bridgeListView);
//        DatabaseHandler db = new DatabaseHandler(this);
//        Cursor cursor = db.getBridges();
//
//        Log.i("Bridge Cursor Name1", cursor.getString(cursor.getColumnIndex("name")));
//
//        cursor.moveToFirst();
//        while(cursor.moveToNext()) {
//            Bridge bridge = new Bridge();
//            bridge.name = cursor.getString(cursor.getColumnIndex("name"));
//            Log.i("Bridge name", bridge.name);
//            Log.i("Bridge Cursor Name", cursor.getString(cursor.getColumnIndex("name")));
//            bridge.ipadress = cursor.getString(cursor.getColumnIndex("ipadress"));
//            bridge.username = cursor.getString(cursor.getColumnIndex("username"));
//
//            bridgeArrayList.add(bridge);
//        }
//
//        Log.i("ArrayList", bridgeArrayList.toString());

        mBridgeAdapter = new BridgeAdapter(this, getLayoutInflater(), bridgeArrayList);
        mBridgeListView.setAdapter(mBridgeAdapter);
        mBridgeListView.setOnItemClickListener(this);

        mBridgeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
