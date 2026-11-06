package com.bintang.rumahsakit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MemberDbHelper extends SQLiteOpenHelper {

    public MemberDbHelper(Context context) {
        super(context, "members.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE members (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, username TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS members");
        onCreate(db);
    }

    public void insert(String name, String username) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("username", username);
        getWritableDatabase().insert("members", null, cv);
    }

    public List<Member> getAll() {
        List<Member> list = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT id, name, username FROM members ORDER BY name", null);
        while (c.moveToNext()) {
            list.add(new Member(c.getInt(0), c.getString(1), c.getString(2)));
        }
        c.close();
        return list;
    }

    public void update(int id, String name, String username) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("username", username);
        getWritableDatabase().update("members", cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void delete(int id) {
        getWritableDatabase().delete("members", "id=?", new String[]{String.valueOf(id)});
    }
}