/*
package com.gmail.tarasov1998.demoapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EmployeesDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_CATCH_PHRASE = "catchPhrase";
    private static final String COLUMN_WEBSITE = "website";
    private static final String COLUMN_AVATAR = "avatar";


    public UserDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "    " + COLUMN_ID + " INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    " + COLUMN_NAME + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_USERNAME + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_EMAIL + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_PHONE + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_CATCH_PHRASE + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_WEBSITE + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_AVATAR + " int NOT NULL\n" +
                ");";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(sql);
        onCreate(db);
    }

    boolean addEmployee(String name, String username, String email, double salary, String joiningdate, String joiningdate, String joiningdate, int joiningdate) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PHONE, salary);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_CATCH_PHRASE, dept);
        contentValues.put(COLUMN_WEBSITE, joiningdate);
        contentValues.put(COLUMN_AVATAR, salary);
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TABLE_NAME, null, contentValues) != -1;
    }
}
*/
