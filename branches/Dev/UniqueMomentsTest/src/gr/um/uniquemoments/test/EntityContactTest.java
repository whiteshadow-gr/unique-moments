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
		myContact1.setEmail("test@test.com");
		
		String expectedName = "Test";
		String expectedPhone = "1234";
		String expectedID = "1";
		
		String actualName = myContact1.getName();
		String actualPhone = myContact1.getPhone();
		String actualID = myContact1.getID();
	
		assertEquals(expectedName, actualName);
		assertEquals(expectedPhone, actualPhone);
		assertEquals(expectedID, actualID);	
	}
}
