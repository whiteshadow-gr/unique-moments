package gr.um.database;

import java.util.Calendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ControllerDatesDb extends SQLiteOpenHelper
{
	
	static final String dbName="uniquemoments_DB";
	static final String Dates_Table="Dates";
	static final String colD_ID="_D_ID";
	static final String colD_Date="D_Date";
	static final String colD_Type="D_Type";
	static final String colContacts_Id="Contacts_Id";
	static final String namedays="NameDays";
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	
	/*
	 * Constructor
	 */
	public ControllerDatesDb(Context context) 
	{
		super(context, dbName, null,01);
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------//

	public void initializeDatabase(SQLiteDatabase db)
	{
		
		//db.execSQL("CREATE TABLE IF NOT EXISTS "+Dates_Table+" ("+colD_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
		//		  colD_Date+ " VARCHAR, "+colD_Type+" VARCHAR );");
				  
			db.execSQL("CREATE TABLE IF NOT EXISTS "+Dates_Table+" ("+colD_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
						  colD_Date+ " VARCHAR, "+colD_Type+" VARCHAR, "+colContacts_Id+" INT,CONSTRAINT fk_Date_ID1  FOREIGN KEY (Contacts_Id) REFERENCES Contacts (_ContactsID));");
				  
		//db.execSQL("");
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		
	}
	
	public void addDates(String[] k) 
	{
		
		Calendar c = Calendar.getInstance();
		String sDate = c.get(Calendar.DAY_OF_MONTH)+ "-" + c.get(Calendar.MONTH) + "-" +c.get(Calendar.YEAR);	
		SQLiteDatabase db = this.getWritableDatabase();
		
		
		/*for(int i=0; i<k.length;i++)
		{
			//db.execSQL("INSERT INTO Dates, Contacts (Dates.D_Date, Dates.D_Type) VALUES('"+sDate+"','"+namedays+"') WHERE Contacts.Date_Id=Dates._D_ID AND Contacts.ContactsName like '"+k[i]+"';");
			//db.execSQL("UPDATE Dates INNER JOIN Contacts ON Contacts.Date_Id=Dates._D_ID SET Dates.D_Date='"+sDate+"', Dates.D_Type='"+namedays+"' WHERE Contacts.ContactsName like '"+k[i]+"';");
			//db.execSQL("INSERT INTO Dates (D_Type) VALUES('"+sDate+"');");
			
		}
		*/	
	}
	
}
