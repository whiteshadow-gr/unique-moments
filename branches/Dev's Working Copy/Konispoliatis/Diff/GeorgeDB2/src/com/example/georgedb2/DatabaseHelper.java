package com.example.georgedb2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
	static final String dbName="demoDB";
	static final String employeeTable="Groups";
	static final String colID="EmployeeID";
	static final String colName="EmployeeName";
	
	public DatabaseHelper(Context context)
	{
		  super(context, dbName, null,33);
	}
	public void onCreate(SQLiteDatabase db) {
		  // TODO Auto-generated method stub

		  db.execSQL("CREATE TABLE "+employeeTable+" ("+colID+ " INTEGER PRIMARY KEY , "+
				  colName+ " TEXT)");
		  SQLiteDatabase db1=this.getWritableDatabase();
		  ContentValues cv=new ContentValues();
		    cv.put(colID, 1);
		    cv.put(colName, "Giorgos");
		    db1.insert(colID,colName, cv);

		    cv.put(colID, 2);
		    cv.put(colName, "Nikos");
		    db1.insert(colID, colName, cv);
		    db1.close();
		    
		    
		//Inserts pre-defined departments
		  //InsertDepts(db);
	};
	/*Public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		  // TODO Auto-generated method stub

		  db.execSQL("DROP TABLE IF EXISTS "+employeeTable);
		  onCreate(db);
	}*/
	Cursor getAllDepts()
    {
     SQLiteDatabase db=this.getReadableDatabase();
     Cursor cur=db.rawQuery("SELECT "+colID+" as _id, "+colName+" from "+employeeTable,new String [] {});

     return cur;
    }
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}
