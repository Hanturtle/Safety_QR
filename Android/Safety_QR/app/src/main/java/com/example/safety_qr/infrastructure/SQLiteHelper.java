package com.example.safety_qr.infrastructure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.safety_qr.domain.History;

import java.util.ArrayList;

public class SQLiteHelper {


    private static final String dbName = "History";
    private static final String table1 = "HistoryTB";
    private static final int dbVersion = 1;

    private OpenHelper opener;
    private SQLiteDatabase db;

    private Context context;

    public SQLiteHelper(Context context) {
        this.context = context;
        this.opener = new OpenHelper(context, dbName, null, dbVersion);
        db = opener.getWritableDatabase();
    }

    private class OpenHelper extends SQLiteOpenHelper{

        public OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String create = "CREATE TABLE "+ table1 + "(" +
                    "'id' integer PRIMARY KEY AUTOINCREMENT, "+
                    "'url' text,"+
                    "'result' text)";
            sqLiteDatabase.execSQL(create);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table1);
            onCreate(sqLiteDatabase);
        }
    }

    public void insertHistory(History history){
        db = opener.getWritableDatabase();
        //String sql = "INSERT INTO "+table1+" VALUES('"+history.url+"','"+history.result+"');";
        String sql = "INSERT INTO HistoryTB (url, result) VALUES('" + history.url + "', '" + history.result + "');";

        db.execSQL(sql);
    }



    // DELETE FROM MemoTable WHERE seq = 0;
    public void deleteHistory(int seq){

        String sql = "DELETE FROM "+table1+" WHERE id = "+seq+";";
        db.execSQL(sql);

    }

    // SELECT * FROM HistoryTB
    public ArrayList<History> selectALL(){
        ArrayList<History> historyItems = new ArrayList<>();

        db = opener.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM HistoryTB ORDER BY id DESC", null);
        if(cursor.getCount()!=0){
            while(cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String url = cursor.getString(cursor.getColumnIndex("url"));
                String result = cursor.getString(cursor.getColumnIndex("result"));

                History history = new History(url, result);
                history.setId(id);
                history.setUrl(url);
                history.setResult(result);
                historyItems.add(history);

            }
        }
        cursor.close();

        return historyItems;
    }


    // SELECT * FROM MemoTable;
/*
    public ArrayList<History> selectALL(){
        String sql = "SELECT * FROM "+table1;
        ArrayList<History> list = new ArrayList<>();

        Cursor results = db.rawQuery(sql, null);
        results.moveToFirst();
        //int index = results.getColumnIndex(0);
        while (!results.isAfterLast()) {

            History history = new History(results.getString(0), results.getString(1));
            list.add(history);
            results.moveToNext();

        }
        results.close();

        return list;
    }
*/


}
