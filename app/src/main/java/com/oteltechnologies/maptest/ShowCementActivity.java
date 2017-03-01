package com.oteltechnologies.maptest;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class ShowCementActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    ShowCementAdapter adapter;
    private List<ShowCementData> cementDataList;
    Button filterButton, settingsButton, sortButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        showCement();
        filterButton = (Button) findViewById(R.id.filter);
        sortButton = (Button) findViewById(R.id.sort);
        settingsButton = (Button) findViewById(R.id.settings);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dilalogfilter = new Dialog(ShowCementActivity.this);
                dilalogfilter.setContentView(R.layout.filter_dialogue);
                WindowManager.LayoutParams dialogwindow = dilalogfilter.getWindow()
                        .getAttributes();
                dialogwindow.gravity = Gravity.BOTTOM;
                dilalogfilter.show();

            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialosettings = new Dialog(ShowCementActivity.this);
                dialosettings.setContentView(R.layout.settings_dialogue);
                WindowManager.LayoutParams settingswindow = dialosettings.getWindow()
                        .getAttributes();
                settingswindow.gravity = Gravity.BOTTOM;
                dialosettings.show();
            }
        });
        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialogsort = new Dialog(ShowCementActivity.this);
                dialogsort.setContentView(R.layout.sort_dialogue);
                WindowManager.LayoutParams sortwindow = dialogsort.getWindow()
                        .getAttributes();
                sortwindow.gravity = Gravity.BOTTOM;
                dialogsort.show();
            }
        });

    }

    public void showCement() {
        cementDataList = new ArrayList<>();

        ShowCementData a = new ShowCementData("Acc Cement", "Rs.700/bag", R.drawable.acc);
        cementDataList.add(a);

        a = new ShowCementData("Ambuja Cement", "Rs.700/bag", R.drawable.ambuja);
        cementDataList.add(a);

        a = new ShowCementData("Birla White Cement", "Rs.700/bag", R.drawable.birlawhite);
        cementDataList.add(a);

        a = new ShowCementData("JSW Cement", "Rs.700/bag", R.drawable.jsw);
        cementDataList.add(a);

        a = new ShowCementData("JAYPEE Cement", "Rs.700/bag", R.drawable.cement);
        cementDataList.add(a);

        a = new ShowCementData("Acc Cement", "Rs.700/bag", R.drawable.acc);
        cementDataList.add(a);

        a = new ShowCementData("Ambuja Cement", "Rs.700/bag", R.drawable.ambuja);
        cementDataList.add(a);

        a = new ShowCementData("Birla White Cement", "Rs.700/bag", R.drawable.birlawhite);
        cementDataList.add(a);

        a = new ShowCementData("JSW Cement", "Rs.700/bag", R.drawable.jsw);
        cementDataList.add(a);

        a = new ShowCementData("JAYPEE Cement", "Rs.700/bag", R.drawable.cement);
        cementDataList.add(a);

        a = new ShowCementData("Acc Cement", "Rs.700/bag", R.drawable.acc);
        cementDataList.add(a);

        a = new ShowCementData("Ambuja Cement", "Rs.700/bag", R.drawable.ambuja);
        cementDataList.add(a);

        a = new ShowCementData("Birla White Cement", "Rs.700/bag", R.drawable.birlawhite);
        cementDataList.add(a);

        a = new ShowCementData("JSW Cement", "Rs.700/bag", R.drawable.jsw);
        cementDataList.add(a);

        a = new ShowCementData("JAYPEE Cement", "Rs.700/bag", R.drawable.cement);
        cementDataList.add(a);

        adapter = new ShowCementAdapter(this, cementDataList);
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.show_cement, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        switch (item.getItemId()) {
//            case android.R.id.home:
//                Intent i = new Intent(getApplicationContext(), MyMapActivity.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
//                return true;
//            default:
                return super.onOptionsItemSelected(item);

        }

    }


