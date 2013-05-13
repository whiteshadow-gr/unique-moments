package gr.um.uniquemoments.test;

import gr.um.entities.RSSItem;
import gr.um.eortologio.EortologioEventReader;

import java.util.ArrayList;

import android.test.InstrumentationTestCase;

public class EortologioEventReaderTest extends InstrumentationTestCase 
{
	private EortologioEventReader eortologio;
	
	protected void setUp() throws Exception 
	{
		super.setUp();
		eortologio = new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
	}

	

	public void testGetNames() 
	{
		
		ArrayList <String> expected = new ArrayList <String>();
		expected.add("Glykeria");
	
		ArrayList <String> actual=new ArrayList <String>();
		actual=eortologio.getNames();
		
		
		assertEquals(actual,expected);
	}
	
	public void testRetrieveRSSFeed()
	{
		ArrayList <RSSItem> listActual = new ArrayList<RSSItem>();
		
		listActual = eortologio.retrieveRSSFeed(listActual);
		
		String expected = "today 13/5 :  Glykeria (source : www.namedays.gr)";
		String actual = listActual.get(0).title;
		
		assertEquals(expected, actual);
	}
}
