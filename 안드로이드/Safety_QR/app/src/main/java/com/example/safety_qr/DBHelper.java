package com.example.sqliteexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Memo.db";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 데이터베이스가 생성이 될 때 호출
        db.execSQL("CREATE TABLE IF NOT EXISTS MemoList (id INTEGER PRIMARY KEY AUTOINCREMENT, searchDate TEXT NOT NULL, url TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    // SELECT
    public ArrayList<MemoItem> getMemoList(){
        ArrayList<MemoItem> memoItems = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM MemoList ORDER BY searchDate DESC", null);
        if(cursor.getCount() != 0){
            // 조회한 데이터가 있을 때 수행
            while(cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String searchDate = cursor.getString(cursor.getColumnIndex("searchDate"));
                String url = cursor.getString(cursor.getColumnIndex("url"));

                MemoItem memoItem = new MemoItem();
                memoItem.setId(id);
                memoItem.setSearchDate(searchDate);
                memoItem.setUrl(url);
                memoItems.add(memoItem);
            }
        }
        cursor.close();

        return memoItems;
    }

    // INSERT
    public void InsertMemo(String _searchDate, String _url){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO MemoList (searchDate, url) VALUES('" + _searchDate + "', '" + _url + "');");
    }

    // DELETE
    public void DeleteMemo(int _id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM MemoList WHERE id = '" + _id + "'");
    }
}
