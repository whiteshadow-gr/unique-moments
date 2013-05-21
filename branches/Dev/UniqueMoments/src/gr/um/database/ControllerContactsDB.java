package gr.um.database;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.ContactsContract;
import gr.um.entities.Contact;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ControllerContactsDB extends SQLiteOpenHelper implements InterfaceDatabase 
{
	
	static String dbName = "uniquemoments_DB";
	static final String ContactsTable="Contacts";
	static final String colID="_ContactsID";
	static final String colName="ContactsName";
	static final String colPhone="ContactsPhone";
	static final String colEmail="ContactsEmail";
	static final String colNickName="ContactsNickName";
	static final String colRelationship="ContactsRelationship";
	static final String colBirthDay="ContactsBirthDay";
	//static final String colDate_Id="Date_Id";
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * Constructor
	 */
	public ControllerContactsDB(Context context)
	{
		super(context, dbName, null,01);
	}
	
	public ControllerContactsDB(Context context, String databaseName)
	{
		super(context, databaseName, null,01);
		dbName = databaseName;
	}
	
	public void onCreate(SQLiteDatabase db) 
	{

	}
	
	//------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * Initialization of the database: Creates all the tables needed for this application to function
	 * 
	 * Arguments:
	 * SQLiteDatabase db = an object of the android.database.sqlite.SQLiteDatabase needed to access the
	 * 					   application's database
	 */
	public void initializeDatabase(SQLiteDatabase db)
	{
		
		//db.execSQL("CREATE TABLE IF NOT EXISTS "+ContactsTable+" ("+colID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
		//		  colName+ " VARCHAR, "+colPhone+" VARCHAR,"+colDate_Id+" INT,CONSTRAINT fk_Contact_ID1  FOREIGN KEY (Date_Id) REFERENCES Dates (_D_ID))");
		
		
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ContactsTable+" ("+colID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
						  colName+ " VARCHAR, "+colPhone+" VARCHAR);");
				
		
		//CONSTRAINT fk_Contact_ID1  FOREIGN KEY (_D_ID) REFERENCES DATES (_D_ID)
	
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Database#addContact(entities.Contact)
	 * 
	 * This method is called whenever adding a contact to the database is needed
	 * 
	 * Arguments:
	 * Contact myContact = an object of the Contact entity class containing the essential data needed
	 * 					   for this method to function
	 * 
	 * Returns true if insertion is successful or false otherwise
	 */
	@Override
	public boolean addContact(Contact myContact) 
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();	
		
		cv.put(colName, myContact.getName());
		cv.put(colPhone, myContact.getPhone());
		
		/*	cv.put(colEmail, myContact.getEmail());
			cv.put(colNickName, myContact.getNickname());
			cv.put(colRelationship, myContact.getRelationship());
			cv.put(colBirthDay, myContact.getBirthday());
		*/
		
		if(db.insert(ContactsTable, null, cv)==-1)
			return false;
		else
			return true;
	}
	
	
	/*
	 * This method is used to get all contact entries in the application's database
	 * It returns a cursor containing all the contacts in the database
	 */
	public ArrayList <Contact> getContacts()
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cur = db.rawQuery("SELECT * FROM "+ContactsTable, null);
		
		
		ArrayList <Contact> contactsDB = new ArrayList <Contact>();
		
		
		cur.moveToFirst();
		for(int i=0; i<cur.getCount(); i++)
		{
			Contact temp = new Contact();
				
			 String id = Integer.toString(cur.getInt(cur.getColumnIndex("_ContactsID")));
			 String name   = cur.getString(cur.getColumnIndex("ContactsName"));
			 String number = cur.getString(cur.getColumnIndex("ContactsPhone"));
			
			 temp.setID(id);
			 temp.setName(name);
			 temp.setPhone(number);
			 contactsDB.add(temp);
			 
			 
			 
			 cur.moveToNext();
			
		}
		
		return contactsDB;
		
	}
	
	
	/*
	 * This method is called onto initializing the application
	 * It adds all the Device's contact entries into the application's database
	 * 
	 * Arguments:
	 * ContentResolver cr = an object of the android.content.ContentResolver class
	 * 					    which is needed for getting the Device's contact entries
	 * 
	 * It returns true if insertion is successful or false otherwise
	 */
	public boolean importPhonebookData(ContentResolver cr)
	{		
		Contact tempContact = new Contact();
		Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		String[] projection = new String[] {ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
		String selection= "has_phone_number = ?";
		String[] selectionArgs = {"1"};
		String sortOrder= null;
		
		Cursor cur = cr.query(uri, projection, selection, selectionArgs, sortOrder);
		int indexName = cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
		int indexNumber = cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
		
		if(cur.getCount()>0 )
		{	
			cur.moveToFirst();
			do
			{
			    tempContact.setName(cur.getString(indexName));
			    tempContact.setPhone(cur.getString(indexNumber));
			
			    this.addContact(tempContact);
			    
			} while (cur.moveToNext()); 
		}
		
		return true;
	}
	

	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Database#deleteContact(entities.Contact)
	 * 
	 * This method is called whenever deleting a contact from the database is needed
	 * 
	 * Arguments:
	 * Contact myContact = an object of the Contact entity class containing the essential data needed
	 * 					   for this method to function
	 * 
	 * It returns true if deletion is successful or false otherwise
	 */
	@Override
	public boolean deleteContact(Contact myContact) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Database#editContact(entities.Contact)
	 * 
	 * This method is called whenever editing the information related to a specific contact is needed
	 * 
	 * Arguments:
	 * Contact myContact = an object of the Contact entity class containing the essential data needed
	 * 					   for this method to function
	 * 
	 * It returns true if editing is successful or false otherwise
	 */
	@Override
	public boolean editContact(Contact myContact) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see interfaces.I_Database#searchContact(android.view.View, java.lang.String)
	 * 
	 * This method is called in order to find a single contact entry in the database
	 * 
	 * Arguments:
	 * View view = the view that calls this method
	 * String myName = the name of the entry of the search
	 * 
	 * It returns a Cursor containing the result of the search query
	 */
	@Override
	public ArrayList<Contact> searchContacts(String myName) 
	{
		SQLiteDatabase db = this.getReadableDatabase();
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		Contact temp = new Contact();
		Cursor cur = db.rawQuery("SELECT * FROM " + ContactsTable + " WHERE " + colName + " LIKE '" + myName + "'" , null);
		
		if(cur.getCount()>0 )
		{	
			cur.moveToFirst();
			do
			{
			    temp.setName( cur.getString(cur.getColumnIndex(colName)) );
			    temp.setPhone( cur.getString(cur.getColumnIndex(colPhone)) );
			    contacts.add(temp);
			} 
			while (cur.moveToNext()); 
		}
		
		return contacts;			
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	public void closeDBConn(SQLiteDatabase db)
	{
		db.close();
	}
	
	
}
