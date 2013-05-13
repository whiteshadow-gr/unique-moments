package gr.um.uniquemoments.test;

import gr.um.entities.RSSItem;

import java.util.ArrayList;

import android.test.InstrumentationTestCase;

public class EntityRSSItemTest extends InstrumentationTestCase 
{
	private RSSItem testItem;
	private ArrayList <String> nameList;
	
	public EntityRSSItemTest()
	{
		super();
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		nameList = new ArrayList<String>();
		
		nameList.add("Stelios");
		nameList.add("Theo");
		nameList.add("Mario");
		
		testItem = new RSSItem(nameList.size());
	}
	
	public void testRSSITemEntitySetters()
	{
		testItem.setTitle("today 13/5 :  Glykeria (source : www.namedays.gr)");
		testItem.setLink("http://test.com");
		testItem.generateArrayListNames();
		
		String expectedTitle = "today 13/5 :  Glykeria (source : www.namedays.gr)";
		String expectedLink = "http://test.com";
		String[] expectedNames = new String[1];
		expectedNames[0] = "Glykeria";
		
		String actualTitle = testItem.getTitle();
		String actualLink = testItem.getLink();
		String actualNames[] = testItem.names;
		
		assertEquals(expectedTitle, actualTitle);
		assertEquals(expectedLink, actualLink);
		assertEquals(expectedNames[0].trim(), actualNames[0].trim());
	}
	
	public void testSetNames()
	{
		testItem.setNames(nameList);
		String[] actualNames = testItem.getNames();
		
		String[] expectedNames = new String[3];
		expectedNames[0] = "Stelios";
		expectedNames[1] = "Theo";
		expectedNames[2] = "Mario";
		
		assertEquals(expectedNames[0], actualNames[0]);
		assertEquals(expectedNames[1], actualNames[1]);
		assertEquals(expectedNames[2], actualNames[2]);
	}
}
