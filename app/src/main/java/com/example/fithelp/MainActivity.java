package com.example.fithelp;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import models.SqlLists;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private static final String TRAIN_DATABASE_NAME = "TrainFitHelper";
    private static final String DIET_DATABASE_NAME = "DietFitHelper";
    private static final String MEAS_DATABASE_NAME = "MeasFitHelper";
    private static final int VERSION = 1;
    SQLiteDatabase train;
    DBHelper trainDataBase;
    SqlLists listOfSqlExec;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_train:
                    findViewById(R.id.TrainView).setVisibility(View.VISIBLE);
                    findViewById(R.id.DietView).setVisibility(View.INVISIBLE);
                    findViewById(R.id.MeasView).setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    findViewById(R.id.TrainView).setVisibility(View.INVISIBLE);
                    findViewById(R.id.DietView).setVisibility(View.VISIBLE);
                    findViewById(R.id.MeasView).setVisibility(View.INVISIBLE);
                    return true;
                case R.id.navigation_notifications:
                    findViewById(R.id.TrainView).setVisibility(View.INVISIBLE);
                    findViewById(R.id.DietView).setVisibility(View.INVISIBLE);
                    findViewById(R.id.MeasView).setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    private ListView.OnItemClickListener onItemClickListener = new ListView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            switch (adapterView.getId()){
                case R.id.TrainView:
                    Intent intent = new Intent(MainActivity.this, TrainActivity.class);
                    intent.putExtra("train_position_activity_main", position);
                    startActivity(intent);
                    break;
                case R.id.DietView:
                    break;
                case R.id.MeasView:
                    break;
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView gv = findViewById(R.id.TrainView);
        String[] dataTr = {"Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train"};
        gv.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dataTr ));

        gv.setOnItemClickListener(onItemClickListener);

        //trainDataBase = new DBHelper( train, TRAIN_DATABASE_NAME, listOfSqlExec.TrainSql,VERSION);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
