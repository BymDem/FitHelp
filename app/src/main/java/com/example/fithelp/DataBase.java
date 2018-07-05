package com.example.fithelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBase{

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String dataBaseName;
    private ArrayList<String> listOfSqlExec;
    private static final int version = 1;
    private Context context;


    public DataBase(Context context, String db_name, ArrayList<String> list)
    {
        this.context = context;
        dataBaseName = db_name;
        listOfSqlExec = list;
        ArrayList<String> al = new ArrayList<String>();
        al.add("train");
        al.add("train32");
        al.add("train1234");
        al.add("train487");
        open();
        add("Train", "name", al);
        close();
    }

    public void open(){
        dbHelper = new DBHelper(context, dataBaseName, listOfSqlExec, version);
        db = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        if(dbHelper != null) dbHelper.close();
    }

    public Cursor getAllDataFromTable(String table_name)
    {
        return db.query(table_name, null,null ,null,null,null,null);
    }

    public Cursor getDataFromColumn(String table_name, String columnName)
    {
        String[] cn= {columnName};
        return db.query(table_name,cn,null ,null,null,null,null);
    }

    public String getDataFromItem(String table_name, String columnName, int number)
    {
        Cursor ar =  getAllDataFromTable(table_name);
        ar.moveToPosition(number);
        return ar.getString(ar.getColumnIndex(columnName));
    }

    public void add(String table_name, ArrayList<String[]> columns_name_and_values)
    {
        ContentValues cv = new ContentValues();
        for(String[] map : columns_name_and_values)
        {
            cv.put(map[0], map[1]);
        }
        db.insert(table_name, null, cv);
    }

    public void add(String table_name, String column_name, ArrayList<String> values)
    {
        ContentValues cv = new ContentValues();
        for(String value : values)
        {
            cv.put(column_name, value);
            db.insert(table_name, null, cv);
        }

    }

    public void add(String table_name, String column_name, String values)
    {
        ContentValues cv = new ContentValues();
        cv.put(column_name, values);
        db.insert(table_name, null, cv);
    }
}