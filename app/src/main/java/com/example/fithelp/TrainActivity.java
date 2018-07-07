package com.example.fithelp;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.Exercise;

public class TrainActivity extends AppCompatActivity {

    private ArrayList<Exercise> _exercises = new ArrayList<Exercise>();
    private TextView _tv_name_of_train;
    private int position;
    private boolean IsItNew;
    private DataBase _db_train;


    private ListView.OnItemClickListener onItemClickListener = new ListView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Intent intent = new Intent(TrainActivity.this, ExerciseActivity.class);
            intent.putExtra("exercise_position_activity_train", position);
            startActivityForResult(intent, 1);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setDataOnActivity();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        setTitle("Тренировка");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        _db_train = new DataBase(this, MainActivity.TRAIN_DATABASE_NAME, MainActivity.listOfSqlExec.TrainSql);

        _tv_name_of_train = findViewById(R.id.textView_NameOfTrain);
        IsItNew = (boolean) getIntent().getSerializableExtra("IsItNew");

        _tv_name_of_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewAlertDialog( (String) _tv_name_of_train.getText());
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });

        setDataOnActivity();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_button, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setDataOnActivity()
    {
        if(IsItNew == false){
            _db_train.open();
            position = (int) getIntent().getSerializableExtra("train_position_activity_main");
            String name_of_train = _db_train.getDataFromItem("Train", "name", position);

            _tv_name_of_train.setText(name_of_train);
            _db_train.close();
        }
        else
        {
            NewAlertDialog1("");
        }
    }

    public void NewAlertDialog()
    {
        NewAlertDialog("");
    }

    public void NewAlertDialog1(String begin_value)
    {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        final EditText dialog_text_view = new EditText(this);

        dialog.setTitle("Название тренировки:");
        dialog.setView(dialog_text_view);

        dialog_text_view.setMaxLines(1);
        dialog_text_view.setMaxEms(13);
        dialog_text_view.setText(begin_value);

        dialog.setPositiveButton("Готово",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        _tv_name_of_train.setText(dialog_text_view.getText().toString());
                        _db_train.open();
                        _db_train.add("Train", "name", _tv_name_of_train.getText().toString());
                        _db_train.close();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        dialog.create();
        dialog.show();
    }

    public void NewAlertDialog(String begin_value)
    {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        final EditText dialog_text_view = new EditText(this);

        dialog.setTitle("Название тренировки:");
        dialog.setView(dialog_text_view);

        dialog_text_view.setMaxLines(1);
        dialog_text_view.setMaxEms(13);
        dialog_text_view.setText(begin_value);

        dialog.setPositiveButton("Готово",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        _tv_name_of_train.setText(dialog_text_view.getText().toString());
                        ContentValues cv = new ContentValues();
                        cv.put("name", _tv_name_of_train.getText().toString());
                        _db_train.open();
                        _db_train.update("Train", cv, "id = ?", new String[]{String.valueOf(position + 1)});
                        _db_train.close();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        dialog.create();
        dialog.show();
    }


}
