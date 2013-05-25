package gr.um.uniquemoments.test;

import gr.um.database.MockControllerContactsDB;
import gr.um.entities.Contact;

import java.util.ArrayList;

import android.test.InstrumentationTestCase;

public class ControllerContactsDBUnitTest extends InstrumentationTestCase 
{

	private ArrayList<Contact> initDB;
	private MockControllerContactsDB mockDB;
	
	
	protected void setUp() throws Exception
	{
		super.setUp();
		initDB = new ArrayList<Contact>();
		
		Contact temp = new Contact("George Bush", "1234");
		temp.setID("1");
		initDB.add(temp);
		
		temp = new Contact("Kotsos Mitsos", "2345");
		temp.setID("2");
		initDB.add(temp);
		
		temp = new Contact("Makis Tzikos", "3456");
		temp.setID("3");
		initDB.add(temp);
		
		temp = new Contact("Maria Xatzi", "4567");
		temp.setID("4");
		initDB.add(temp);
		
		temp = new Contact("Matina Kati", "5678");
		temp.setID("5");
		initDB.add(temp);
		
		mockDB = new MockControllerContactsDB();
		mockDB.initializeDatabase(initDB);
	}
	
	public void testGetContacts() 
	{
		assertEquals(mockDB.getContacts(), initDB);
	}

	public void testAddContact() 
	{
		Contact myContact = new Contact();
		myContact.setID("6");
		myContact.setName("Test Test");
		myContact.setPhone("1469");
		
		assertTrue(mockDB.addContact(myContact));
	}

	public void testDeleteContact() 
	{
		Contact myContact = new Contact("Matina Kati", "5678");
		myContact.setID("5");
		
		assertTrue(mockDB.deleteContact(myContact));
	}

	public void testEditContact() 
	{
		Contact myContact = new Contact("Makis Marios", "3456");
		myContact.setID("3");
		assertTrue(mockDB.editContact(myContact));
	}

}
