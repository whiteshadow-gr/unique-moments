package gr.um.interfaces;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;

import gr.um.entities.Contact;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public interface IDatabase 
{	
	public boolean addContact(Contact myContact);
	public boolean deleteContact(Contact myContact);
	public boolean editContact(Contact myContact);
	public ArrayList <Contact> getContacts();
	public boolean importPhonebookData(ContentResolver contentResolver);
	public void initializeDatabase(SQLiteDatabase db);	
}