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
	ArrayList<Contact> expectedContacs; 
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
		expectedContacs = new ArrayList<Contact>();
		contacts =  new ArrayList<Contact>();
		names = new ArrayList<String>();
		
	}
	
	public void testfindContactsAll()
	{
		ArrayList<Contact> actualContacs = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");
		
		contacts.add(con);
		
		String nm = "Nikos";
		names.add(nm);
		
		expectedContacs.add(con);
		
		actualContacs = im.findContacts(contacts, names);
		
		assertEquals(actualContacs, expectedContacs);
	}
	
	public void testfindContactsNone()
	{
		ArrayList<Contact> actualContacs = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");
		
		contacts.add(con);
		
		String nm = "Giannis";
		names.add(nm);
		
		
		actualContacs = im.findContacts(contacts, names);
		
		assertEquals(actualContacs, expectedContacs);
	}
	
	public void testfindContactsOneCelebrate()
	{
		ArrayList<Contact> actualContacs = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");

		contacts.add(con);
		
		Contact con2 = new Contact();
		con2.setID("12");
		con2.setName("Giann");
		con2.setPhone("1242341235");

		contacts.add(con2);
		
		
		String nm = "Nikos";
		names.add(nm);
		
		expectedContacs.add(con);
		
		actualContacs = im.findContacts(contacts, names);
		
		assertEquals(actualContacs, expectedContacs);
	}
	
	public void testfindContactsTwoCelebrate()
	{
		ArrayList<Contact> actualContacs = new ArrayList<Contact>();
		
		Contact con = new Contact();
		con.setID("12");
		con.setName("Nikos");
		con.setPhone("1242341235");

		contacts.add(con);
		
		Contact con2 = new Contact();
		con2.setID("12");
		con2.setName("Giann");
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
		
		expectedContacs.add(con);
		expectedContacs.add(con3);
		
		actualContacs = im.findContacts(contacts, names);
		
		assertEquals(actualContacs, expectedContacs);
	}
	
	public void testfindContactsNoneCelebrate()
	{
		ArrayList<Contact> actualContacs = new ArrayList<Contact>();
		
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
		
		
		actualContacs = im.findContacts(contacts, names);
		
		assertEquals(actualContacs, expectedContacs);
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
		
		assertEquals(actualContacs, expectedContacs);
	}
}
