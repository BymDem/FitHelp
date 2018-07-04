package com.example.fithelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    ArrayList<String> sql;
    SQLiteDatabase dbase;

    Context mContext;
    int mVersion;

    public DBHelper(Context context, String name, ArrayList<String> sqls, int version) {
        super(context, name, null, version);

        sql = sqls;
        mContext = context;
        mVersion = version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String exec : sql) {
            db.execSQL(exec);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addRow(String table_name, String column_name, String value)
    {
        dbase.execSQL("INSERT INTO " + table_name + " (" + column_name + ") VALUE (" + value + ")");
    }

}
