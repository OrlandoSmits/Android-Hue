package com.android.orlandosmits.hue;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
        DatabaseHandler db = new DatabaseHandler(this);
        Cursor cursor = db.getBridges();

        cursor.moveToFirst();
        while(cursor.moveToNext()) {
            Bridge bridge = new Bridge();
            bridge.name = cursor.getString(cursor.getColumnIndex("name"));
            bridge.ipadress = cursor.getString(cursor.getColumnIndex("ipadress"));
            bridge.username = cursor.getString(cursor.getColumnIndex("username"));

            bridgeArrayList.add(bridge);
        }

        mBridgeAdapter = new BridgeAdapter(this, getLayoutInflater(), bridgeArrayList);
        mBridgeListView.setAdapter(mBridgeAdapter);
        mBridgeListView.setOnItemClickListener(this);

        mBridgeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
