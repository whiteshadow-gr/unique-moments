package com.example.uniquemoments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseController extends SQLiteOpenHelper
{
	static final String dbName="uniquemoments_DB";
	static final String ContactsTable="Contacts";
	static final String colID="_ContactsID";
	static final String colName="ContactsName";
	static final String colNumber="ContactsNumber";
	/*
	 *Consrtuctor klashs 
	*/
	public DatabaseController(Context context)
	{
		super(context, dbName, null,33);
	}
	/*
	 * Struct gia dhmioyrgeia ton pinakon ths bashs sten ekkinhsh ths efarmoghs
	 */
	public void onCreate(SQLiteDatabase db) 
	{
	// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ContactsTable+" ("+colID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
				  colName+ " VARCHAR, "+colNumber+")");
		//db.execSQL("ALTER TABLE Contacts ALTER COLUMN _ContactsID IDENTITY ");
	};
	/*
	 * Enhmwerosh bashs
	 * (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ContactsTable);
		onCreate(db);
	}
	/*
	 *Synarthsh eisagoghs epafon
	 */
	public void insertContacts(Contact temp)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		//cv.put(colID, temp.Contact_getid());
		cv.put(colName, temp.Contact_getName1());
		cv.put(colNumber, temp.Contact_getPhone1());
		db.insert(ContactsTable, colID, cv);
		/*cv.put(colDeptID, 2);
		cv.put(colDeptName, "IT");
		db.insert(deptTable, colDeptID, cv);*/
		db.close();
	}
	/*
	 * Synarthsh Diagrafhs epafhs
	 */
	public void DeleteContact(Contact temp)
	  {
	   SQLiteDatabase db=this.getWritableDatabase();
	   db.delete(ContactsTable,colID+"=?", new String [] {String.valueOf(temp.Contact_getid())});
	   db.close();
	  }
	/*
	 *Synarthsh enhmeroshs epafon sthn bash 
	 */
	Cursor EditContact(Contact temp)
	  {
	   SQLiteDatabase db=this.getReadableDatabase();
	   Cursor cur=db.rawQuery("UPDATE "+colID+" as _id, "+colName+", "+colNumber+" from "+ContactsTable,null);

	   return cur;
	  }
	/*
	 * Synarthsh epistrofhs dedomenon apo thn bash
	 */
	Cursor getAllContacts()
    {
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cur=db.rawQuery("SELECT * from Contacts",null);
		return cur;
    }

}
