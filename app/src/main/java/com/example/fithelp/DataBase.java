package com.example.fithelp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataBase{
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private String dataBaseName;
    private ArrayList<String> listOfSqlExec;
    private static final int version = 1;
    Context context;


    public DataBase(Context c, String db_name, ArrayList<String> list)
    {
        context = c;
        dataBaseName = db_name;
        listOfSqlExec = list;
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
        return getDataFromColumn(table_name, null);
    }

    public Cursor getDataFromColumn(String table_name, String columnName)
    {
        String[] cn= {columnName};
        return db.query(table_name,cn,null ,null,null,null,null);
    }

    public Cursor getDataFromItem(String table_name, String columnName, int number)
    {
        String[] cn= {columnName};
        return db.query(table_name,cn,"id=" + number ,null,null,null,null);
    }

//    public void add(String title, String)
//    {
//
//    }
}