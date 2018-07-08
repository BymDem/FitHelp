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
import models.Train;

public class TrainActivity extends AppCompatActivity {

    private ArrayList<Exercise> _exercises = new ArrayList<Exercise>();
    private TextView _tv_name_of_train;
    private Train train;
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
        setTitle(getString(R.string.title_train));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        IsItNew = (boolean) getIntent().getSerializableExtra("IsItNew");
        _db_train = new DataBase(this, MainActivity.TRAIN_DATABASE_NAME, MainActivity.listOfSqlExec.TrainSql);

        ListView train_list = findViewById(R.id.ListView_train_activity);
        _tv_name_of_train = findViewById(R.id.textView_NameOfTrain);
        FloatingActionButton fab = findViewById(R.id.ActionBtn_activityTrain);


        train_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NewAlertDialog(adapterView.getAdapter().getItem(i).toString());
            }
        });

        _tv_name_of_train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewAlertDialog( (String) _tv_name_of_train.getText());
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainActivity.this, ExerciseChoiceActivity.class);
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
            NewAlertDialog();
        }
    }

    public void NewAlertDialog()
    {
        NewAlertDialog("");
    }

    public void NewAlertDialog(String begin_value)
    {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        final EditText dialog_text_view = new EditText(this);

        dialog.setTitle(getString(R.string.title_name_of_train) + ":");
        dialog.setView(dialog_text_view);

        dialog_text_view.setMaxLines(1);
        dialog_text_view.setMaxEms(13);
        dialog_text_view.setText(begin_value);

        dialog.setPositiveButton(getString(R.string.btn_ok),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        _tv_name_of_train.setText(dialog_text_view.getText().toString());
                        _db_train.open();
                        if(IsItNew) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                            String currentDate = sdf.format(new Date());
                            ArrayList<String[]> args = new ArrayList<String[]>();
                            args.add(new String[]{"name", dialog_text_view.getText().toString()});
                            args.add(new String[]{"data", currentDate});
                            _db_train.add("Train", args);
                        }
                        else {
                            ContentValues cv = new ContentValues();
                            cv.put("name", _tv_name_of_train.getText().toString());
                            _db_train.update("Train", cv, "id = ?", new String[]{String.valueOf(position + 1)});
                        }
                        _db_train.close();
                        dialog.cancel();
                    }
                })
                .setNegativeButton(getString(R.string.btn_cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                if(IsItNew)
                                    finish();
                            }
                        });

        dialog.create();
        dialog.show();
    }
}
