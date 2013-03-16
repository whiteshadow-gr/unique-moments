package com.example.georgeunique;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;


public class DBConnection 
{

	SQLiteDatabase db;
	public void open_DB()
	{
		//db.openDatabase("unique_moments_db.db", null, SQLiteDatabase.OPEN_READWRITE);
		db.execSQL("INSERT INTO Groups VALUES (1, kalh); ");
	}
	public void close_DB()
	{
        db.close();
	}
}
