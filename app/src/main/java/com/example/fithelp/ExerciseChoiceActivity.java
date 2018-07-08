package com.example.fithelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import models.Exercise;

public class ExerciseChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_choice);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lv = findViewById(R.id.ListViewChoiceActivity);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ExerciseChoiceActivity.this, ExerciseActivity.class);
                intent.putExtra("ExerciseName", adapterView.getSelectedItem().toString());
                intent.putExtra("IsItNew", adapterView.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }

}
