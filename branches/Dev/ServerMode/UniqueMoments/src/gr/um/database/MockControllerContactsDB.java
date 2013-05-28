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
	 
	 /**
	  * MockInitiallize initializes the mock contacts DB
	  * @param contacts contains the contacts from DB
	  */
	 public void MockInitiallize(ArrayList<Contact> contacts)
	 {
		 contactsDB = contacts;
	 }
	 /**
	  * MockControllerContactsDB constructor with one parameter context
	  * @param context
	  */
	 public MockControllerContactsDB(Context context)
	 {
	  
	 }
	 
	 /**
	  * MockControllerContactsDB constructor with no parameters
	  */
	 public MockControllerContactsDB()
	 {
		 contactsDB = new ArrayList<Contact>();
	 }
	 
	 /**
	  * deleteContact(Contact myContact)
	  * @return boolean value false
	  */
	 @Override
	 public boolean deleteContact(Contact myContact)
	 {
		 // TODO Auto-generated method stub
		 return false;
	 }
	 
	 /**
	  * editContact(Contact myContact)
	  * @return boolean value false
	  */
	 @Override
	 public boolean editContact(Contact myContact) 
	 {
		 return false;
	 }
	
	 /**
	  * getContacts() returns the contacts from DB
	  * @return contactsDB an ArrayList<Contact>
	  */
	 @Override
	 public ArrayList<Contact> getContacts()
	 {
		 int contactsDBsize = contactsDB.size();
		 if (contactsDBsize>0 )
			 return contactsDB;  
		 else
			 return null;
	 }
	 
	 /**
	 * importPhonebookData(ContentResolver contentResolver) This method is called onto initializing the application It adds all the Device's contact entries into the application's database
	 * @param cr  an object of the android.content.ContentResolver class which is needed for getting the Device's contact entries
	 * @return returns true if insertion is successful or false otherwise
	 */
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
	
	 /**
	  * initializeDatabase Initialization of the database: Creates all the tables needed for this application to function
	  * @param db an object of the android.database.sqlite.SQLiteDatabase needed to access the application's database
	  */
	 @Override
	 public  void initializeDatabase(SQLiteDatabase db) 
	 {
	  // TODO Auto-generated method stub
	 }
	
	 /**
	  * addContact(Contact myContact) This method is called whenever adding a contact to the database is needed
	  * @param myContact an object of the Contact entity class containing the essential data needed for this method to function
	  * @return returns true if insertion is successful or false otherwise
	  */
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