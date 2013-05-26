package gr.um.database;

import gr.um.entities.Contact;
import gr.um.interfaces.IDatabase;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.ContactsContract;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ControllerContactsDB extends SQLiteOpenHelper implements IDatabase 
{
	
	static String dbName = "uniquemoments_DB";
	static final String ContactsTable = "Contacts";
	static final String colID = "_ContactsID";
	static final String colName = "ContactsName";
	static final String colPhone = "ContactsPhone";
	static final String colEmail = "ContactsEmail";
	static final String colNickName = "ContactsNickName";
	static final String colRelationship = "ContactsRelationship";
	static final String colBirthDay = "ContactsBirthDay";
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * Constructor
	 */
	/*public ControllerContactsDB(Context context)
	{
		super(context, dbName, null,01);
	}*/
	public ControllerContactsDB(Context context)
	{
		super(context, dbName, null,01);
		
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
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ContactsTable+" ("+colID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
						  colName+ " VARCHAR, "+colPhone+" VARCHAR);");
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
		
		if(db.insert(ContactsTable, null, cv) == -1)
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
		for(int i = 0; i<cur.getCount(); i++)
		{
			Contact temp = new Contact();
				
			 String id = Integer.toString(cur.getInt(cur.getColumnIndex("_ContactsID")));
			 String name = cur.getString(cur.getColumnIndex("ContactsName"));
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
	public boolean importPhonebookData(ContentResolver contentResolver)
	{		
		Contact tempContact = new Contact();
		Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		String[] projection = new String[] {ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
		String selection = "has_phone_number = ?";
		//TODO Giati exoume selectionArgs afou einai defined 1?? to idio kai gia tin sortOrder
		String[] selectionArgs = {"1"};
		String sortOrder = null;
		
		Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
		int indexName = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
		int indexNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
		
		if(cursor.getCount() > 0 )
		{	
			cursor.moveToFirst();
			do
			{
			    tempContact.setName(cursor.getString(indexName));
			    //TODO Giati eipame bazoume int se string???
			    tempContact.setPhone(cursor.getString(indexNumber));
			
			    this.addContact(tempContact);
			    
			} while (cursor.moveToNext()); 
		}
		//TODO Stin while i moveToNext leei oti epistrefei false an exoume
		//ftasei sto telos tou pinaka. giati kanoume return true emeis?
		//mallon dimiourgoume problima
		return true;
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
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		
	}
		
	public void phonebookReentry(ContentResolver cr)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		this.errasePhonebook(db);
		this.importPhonebookData(cr);
		
	}
	public void errasePhonebook(SQLiteDatabase db)
	{
		db.delete(ContactsTable, null, null);
	}

	@Override
	public boolean deleteContact(Contact myContact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editContact(Contact myContact) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
