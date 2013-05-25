package gr.um.database;

import gr.um.entities.Contact;
import gr.um.interfaces.IDatabase;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;

public class MockControllerContactsDB implements IDatabase
{
	private ArrayList<Contact> contactsDB;
	
	public void initializeDatabase(ArrayList<Contact> contacts)
	{
		contactsDB = contacts;
	}
	
	public MockControllerContactsDB()
	{
		contactsDB = new ArrayList<Contact>();
	}
	
	public boolean addContact(Contact myContact)
	{
		if(myContact==null)
		{
			return false;
		}
		
		else
		{
			contactsDB.add(myContact);
			return true;
		}
	}
	
	public ArrayList <Contact> getContacts()
	{
		return contactsDB;
	}
	
	public boolean deleteContact(Contact myContact)
	{
		for(int i = 0; i<contactsDB.size(); i++)
		{
			if(contactsDB.get(i).getID().equals(myContact.getID()))
			{
				contactsDB.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean editContact(Contact myContact)
	{
		boolean result=false;
		for(int i = 0; i<contactsDB.size(); i++)
		{
			if(contactsDB.get(i).getID().equals(myContact.getID()))
			{
				contactsDB.set(i, myContact);
				result = true;
			}
		}
		return result;
	}
	public boolean erraseAllContacts()
	{
		contactsDB.clear();
		
		if(contactsDB.isEmpty())
			return false;
		else
			return true;
	}

	@Override
	public boolean importPhonebookData(ContentResolver contentResolver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initializeDatabase(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

}