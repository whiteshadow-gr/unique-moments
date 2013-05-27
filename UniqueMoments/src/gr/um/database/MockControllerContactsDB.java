package gr.um.database;

import gr.um.entities.Contact;
import gr.um.interfaces.IDatabase;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MockControllerContactsDB  implements IDatabase
{
	 static String dbName = "uniquemoments_DB_Mock";
	 static final String ContactsTable = "Contacts";
	 static final String colID = "_ContactsID";
	 static final String colName = "ContactsName";
	 static final String colPhone = "ContactsPhone";
	 
	 private ArrayList<Contact> contactsDB;
	 
	
	 public void MockInitiallize(ArrayList<Contact> contacts)
	 {
	  contactsDB = contacts;
	 }
	
	  //contactsDB = new ArrayList<Contact>();
	 public MockControllerContactsDB(Context context)
	 {
	  //super(context, dbName, null,01);
	  
	 }
	 public MockControllerContactsDB()
	 {
	  contactsDB = new ArrayList<Contact>();
	 }
	 @Override
	 public boolean deleteContact(Contact myContact) {
	  // TODO Auto-generated method stub
	  return false;
	 }
	
	 @Override
	 public boolean editContact(Contact myContact) 
	 {
	  
	  return false;
	 }
	
	 @Override
	 public ArrayList<Contact> getContacts()
	 {
	  int contactsDBsize = contactsDB.size();
	  if (contactsDBsize>0 )
	    return contactsDB;  
	  else
	   return null;
	 }
	
	 @Override
	 public boolean importPhonebookData(ContentResolver contentResolver)
	 { 
	  MockControllerContactsDB asd = new MockControllerContactsDB();
	  Contact myContact = new Contact();
	  if (contentResolver.equals(null))
		  return false;
	  else
	  {
	   asd.addContact(myContact);
	   	return true;
	  }
	   
	 }
	
	 @Override
	 public  void initializeDatabase(SQLiteDatabase db) 
	 {
	  // TODO Auto-generated method stub
	  
	 }
	
	 @Override
	 public boolean addContact(Contact myContact)
	 {
	  
	  if(myContact.getID().equals("") || myContact.getName().equals("") || myContact.getPhone().equals(""))
	   return false;
	  else
	  {
	   contactsDB.add(myContact);
	   return true;
	  }
	 }
 
}

