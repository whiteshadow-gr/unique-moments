package gr.um.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ControllerEventsDb extends SQLiteOpenHelper
{
	static final String dbName="uniquemoments_DB";
	static final String EventsTable="Events";
	static final String ContactsTable="Contacts";
	static final String ColID="_E_ID";
	static final String ColDate="E_Date";
	static final String ColName="E_Name";
	static final String ColDescription="E_Description";
	static final String ColPlace="E_Place";

	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * Constructor
	 */
	public ControllerEventsDb(Context context)
	{
		super(context, dbName, null,01);
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	public void initializeDatabase(SQLiteDatabase db)
	{
		db.execSQL("CREATE TABLE IF NOT EXISTS "+EventsTable+" ("+ColID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+ColDate+ " VARCHAR, "+ColName+")");		
	}
	
}
