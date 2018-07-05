package com.example.fithelp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TrainActivity extends AppCompatActivity {

    DataBase db_train;

    private ListView.OnItemClickListener onItemClickListener = new ListView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Intent intent = new Intent(TrainActivity.this, ExerciseActivity.class);
            intent.putExtra("exercise_position_activity_train", position);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        setTitle("Упражнения");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });



        int position = (int) getIntent().getSerializableExtra("train_position_activity_main");

        db_train = new DataBase(this, MainActivity.TRAIN_DATABASE_NAME, MainActivity.listOfSqlExec.TrainSql);
        db_train.open();
        String att = db_train.getDataFromItem("Train", "name", position);

        ListView lv = findViewById(R.id.ListView_train_activity);
        lv.setOnItemClickListener(onItemClickListener);
        String[] ff = {att};
        lv.setAdapter(new ArrayAdapter<String>(TrainActivity.this, R.layout.support_simple_spinner_dropdown_item, ff));

    }

}
