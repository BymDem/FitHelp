package com.example.fithelp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView gv = findViewById(R.id.TrainView);
        String[] dataTr = {"Train", "Train", "Train", "Train", "Train", "Train", "Train", "Train"};
        gv.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dataTr ));

        ListView gvD = findViewById(R.id.DietView);
        String[] dataD = {"Diet", "Diet","Diet","Diet","Diet","Diet","Diet","Diet","Diet"};
        gvD.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dataD ));

        ListView gvM = findViewById(R.id.MeasView);
        String[] dataM = {"Meas", "Meas", "Meas", "Meas", "Meas", "Meas", "Meas", "Meas"};
        gvM.setAdapter(new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dataM ));

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
