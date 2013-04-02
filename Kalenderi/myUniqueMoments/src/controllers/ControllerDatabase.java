package controllers;

import interfaces.I_Database;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.ContactsContract;
import entities.Contact;

public class ControllerDatabase extends SQLiteOpenHelper implements I_Database 
{
	static final String dbName="uniquemoments_DB";
	static final String ContactsTable="Contacts";
	static final String colID="_ContactsID";
	static final String colName="ContactsName";
	static final String colPhone="ContactsPhone";
	static final String colEmail="ContactsEmail";
	static final String colNickName="ContactsNickName";
	static final String colRelationship="ContactsRelationship";
	static final String colBirthDay="ContactsBirthDay";
	
	
	
	public ControllerDatabase(Context context)
	{
		super(context, dbName, null,01);
	}
	public void onCreate(SQLiteDatabase db) 
	{

		db.execSQL("CREATE TABLE IF NOT EXISTS "+ContactsTable+" ("+colID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
				  colName+ " VARCHAR, "+colPhone+")");
	};
	
	@Override
	public boolean addContact(Contact myContact) 
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();	
		
		cv.put(colName, myContact.getName());
		cv.put(colPhone, myContact.getPhone());
		/*cv.put(colEmail, myContact.getEmail());
		cv.put(colNickName, myContact.getNickname());
		cv.put(colRelationship, myContact.getRelationship());
		cv.put(colBirthDay, myContact.getBirthday());*/
		
		if(db.insert(ContactsTable, null, cv)==-1)
			return false;
		else
			return true;
	}
	
	public Cursor getAllContacts()
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cur = db.rawQuery("SELECT * FROM "+ContactsTable, null);
				
		return cur;
	}
	
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
		
		return false;
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
	@Override
	public Contact[] searchContact(String myName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
