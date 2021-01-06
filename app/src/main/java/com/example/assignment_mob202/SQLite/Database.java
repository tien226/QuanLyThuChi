package com.example.assignment_mob202.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "qltc.db",null,1);
    }

    public void SendData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE THU(NGAYTHANG NVARCHAR, KHOANTHU NVARCHAR, LOAITHU NVARCHAR,IDTHU INTEGER PRIMARY KEY AUTOINCREMENT)");
        db.execSQL("CREATE TABLE CHI(NGAYTHANG NVARCHAR, KHOANCHI NVARCHAR, LOAICHI NVARHCAR,IDCHI INTEGER PRIMARY KEY AUTOINCREMENT)");
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS THU");
        db.execSQL("DROP TABLE IF EXISTS CHI");
        onCreate(db);
    }
}
