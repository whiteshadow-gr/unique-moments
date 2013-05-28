package gr.um.uniquemoments.test;

import gr.um.contacts.ImportantContactsFinder;
import gr.um.entities.Contact;
import gr.um.entities.RSSItem;

import java.util.ArrayList;

import android.test.InstrumentationTestCase;

public class ImportantContactsFinderTest extends InstrumentationTestCase  
{
	ArrayList<Contact> contacts;
	ArrayList<String> names;
	ArrayList<Contact> expectedContacts; 
	private ImportantContactsFinder im;

	public ImportantContactsFinderTest()
	{
		super();
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		im = new ImportantContactsFinder();
		expectedContacts = new ArrayList<Contact>();
		contacts =  new ArrayList<Contact>();
		names = new ArrayList<String>();
		
	}
	
	public void testfindContactsAllCelebrate()
	{
		ArrayList<Contact> actualContacts = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");
		
		contacts.add(con);
		
		String nm = "Nikos";
		names.add(nm);
		
		expectedContacts.add(con);
		
		actualContacts = im.findContacts(contacts, names);
		
		assertEquals(actualContacts, expectedContacts);
	}
	
	public void testfindContactsAllCelebrate2()
	{
		ArrayList<Contact> actualContacts = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");
		
		contacts.add(con);
		
		Contact con2 = new Contact();
		con2.setID("14");
		con2.setName("George");
		con2.setPhone("12426541235");
		
		contacts.add(con2);
		
		String nm = "Nikos";
		names.add(nm);
		
		String nm2 = "George";
		names.add(nm2);
		
		
		expectedContacts.add(con);
		expectedContacts.add(con2);
		
		actualContacts = im.findContacts(contacts, names);
		
		assertEquals(actualContacts, expectedContacts);
	}
	
	public void testfindContactsNone()
	{
		ArrayList<Contact> actualContacts = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");
		
		contacts.add(con);
		
		String nm = "Giannis";
		names.add(nm);
		
		
		actualContacts = im.findContacts(contacts, names);
		
		assertEquals(actualContacts, expectedContacts);
	}
	
	public void testfindContactsOneCelebrate()
	{
		ArrayList<Contact> actualContacts = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");

		contacts.add(con);
		
		Contact con2 = new Contact();
		con2.setID("12");
		con2.setName("Giannis");
		con2.setPhone("1242341235");

		contacts.add(con2);
		
		
		String nm = "Nikos";
		names.add(nm);
		
		expectedContacts.add(con);
		
		actualContacts = im.findContacts(contacts, names);
		
		assertEquals(actualContacts, expectedContacts);
	}
	
	public void testfindContactsTwoCelebrate()
	{
		ArrayList<Contact> actualContacts = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");

		contacts.add(con);
		
		Contact con2 = new Contact();
		con2.setID("12");
		con2.setName("Giannis");
		con2.setPhone("1242341235");

		contacts.add(con2);
		
		Contact con3 = new Contact();
		con3.setID("16");
		con3.setName("George");
		con3.setPhone("124234671235");

		contacts.add(con3);
		
		String nm = "Nikos";
		names.add(nm);
		
		String nm2 = "George";
		names.add(nm2);
		
		String nm3 = "Georgia";
		names.add(nm3);
		
		expectedContacts.add(con);
		expectedContacts.add(con3);
		
		actualContacts = im.findContacts(contacts, names);
		
		assertEquals(actualContacts, expectedContacts);
	}
	
	public void testfindContactsNoneCelebrate()
	{
		ArrayList<Contact> actualContacts = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");

		contacts.add(con);
		
		Contact con2 = new Contact();
		con2.setID("12");
		con2.setName("Giannis");
		con2.setPhone("1242341235");

		contacts.add(con2);
		
		
		String nm = "Niki";
		names.add(nm);
		
		String nm2 = "Maria";
		names.add(nm2);
		
		String nm3 = "Georgia";
		names.add(nm3);
		
		
		actualContacts = im.findContacts(contacts, names);
		
		assertEquals(actualContacts, expectedContacts);
	}
	
	public void testfindContactsNoCelebration()
	{
		ArrayList<Contact> actualContacs = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");
		
		contacts.add(con);
		
		actualContacs = im.findContacts(contacts, names);
		
		assertEquals(actualContacs, expectedContacts);
	}
	
	public void testfindContactsNoContact()
	{
		ArrayList<Contact> actualContacs = new ArrayList<Contact>();
		
		String nm = "Nikos";
		names.add(nm);
		
		
		actualContacs = im.findContacts(contacts, names);
		
		assertEquals(actualContacs, expectedContacts);
	}
}
