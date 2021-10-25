package com.example.myapplication;

import android.app.LauncherActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter aAdapter;

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mListView = (ListView) findViewById(R.id.mobile_list);
        aAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mobileArray);
        mListView.setAdapter(aAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String team = ((TextView) v).getText().toString();
                Toast.makeText(ListViewActivity.this, "Selected :" + " " + team, Toast.LENGTH_SHORT).show();
            }
        });
        /*String[] teams = getResources().getStringArray(R.array.teams);

        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.textview, teams));

        ListView lv = getListView();
        // listening to single list item on click

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // selected item
                String team = ((TextView) view).getText().toString();
                Toast.makeText(getApplicationContext(), team, Toast.LENGTH_LONG).show();
            }
        });*/
    }
}
