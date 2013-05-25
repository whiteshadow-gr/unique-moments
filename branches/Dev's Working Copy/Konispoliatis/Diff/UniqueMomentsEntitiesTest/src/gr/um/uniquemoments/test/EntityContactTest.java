package gr.um.uniquemoments.test;

import gr.um.entities.Contact;
import android.test.InstrumentationTestCase;

public class EntityContactTest extends InstrumentationTestCase 
{
	private Contact myContact1;
	
	public EntityContactTest()
	{
		super();
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		myContact1 = new Contact();
	}
	
	public void testContactEntitySetters()
	{
		myContact1.setName("Test");
		myContact1.setPhone("1234");
		myContact1.setID("1");
		myContact1.setBirthday("1/1/1");
		myContact1.setEmail("test@test.com");
		myContact1.setNameday("2/2/2");
		myContact1.setNickname("Testaki");
		myContact1.setRelationship("Dev");
		
		String expectedName = "Test";
		String expectedPhone = "1234";
		String expectedID = "1";
		String expectedBirthday = "1/1/1";
		String expectedEmail = "test@test.com";
		String expectedNameday = "2/2/2";
		String expectedNickname = "Testaki";
		String expectedRelationship = "Dev";
		
		String actualName = myContact1.getName();
		String actualPhone = myContact1.getPhone();
		String actualID = myContact1.getID();
		String actualBirthday = myContact1.getBirthday();
		String actualEmail = myContact1.getEmail();
		String actualNameday = myContact1.getNameday();
		String actualNickname = myContact1.getNickname();
		String actualRelationship = myContact1.getRelationship();
		
		assertEquals(expectedName, actualName);
		assertEquals(expectedPhone, actualPhone);
		assertEquals(expectedID, actualID);
		assertEquals(expectedBirthday, actualBirthday);
		assertEquals(expectedEmail, actualEmail);
		assertEquals(expectedNameday, actualNameday);
		assertEquals(expectedNickname, actualNickname);
		assertEquals(expectedRelationship, actualRelationship);		
	}
}
