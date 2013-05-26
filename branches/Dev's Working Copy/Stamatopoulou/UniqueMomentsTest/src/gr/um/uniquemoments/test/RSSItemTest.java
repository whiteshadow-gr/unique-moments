package gr.um.uniquemoments.test;

import gr.um.entities.RSSItem;

import java.util.ArrayList;

import android.test.InstrumentationTestCase;

public class RSSItemTest extends InstrumentationTestCase 
{
	private RSSItem testItem;
	private ArrayList<String> expectedNames;
	private ArrayList<String> actualNames;
	
	public RSSItemTest()
	{
		super();
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		testItem = new RSSItem();
		expectedNames = new ArrayList<String>();
		actualNames = new ArrayList<String>();
		
		
	}
	
	public void testGenerateArrayListNames1()
	{
		String[] actual=null;
		
		testItem.setLink("eortologio.gr");
		testItem.setTitle("today 13/5 :  Glykeria (source : www.namedays.gr)");
		testItem.generateArrayListNames();
		
		actual = testItem.getNames();
		
		String expected = "Glykeria";
		expectedNames.add(expected);
		
		
		for(int i = 0; i < actual.length; i++)
		{
			actualNames.add(actual[i]);
		}

		
		assertEquals(actualNames, expectedNames);
		
		
	}
	
	public void testGenerateArrayListNames2()
	{
		String[] actual=null;
		
		testItem.setLink("eortologio.gr");
		testItem.setTitle("today 13/5 :  Glykeria, Nikos (source : www.namedays.gr)");
		testItem.generateArrayListNames();
		
		actual = testItem.getNames();
		
		String expected = "Glykeria";
		expectedNames.add(expected);
		String expected2 = "Nikos";
		expectedNames.add(expected2);
		
		
		for(int i = 0; i < actual.length; i++)
		{
			actualNames.add(actual[i]);
		}

		
		assertEquals(actualNames, expectedNames);
		
		
	}
	public void testGenerateArrayListNames3()
	{
		String[] actual=null;
		
		testItem.setLink("eortologio.gr");
		testItem.setTitle("today 13/5 :  Glykeria, Nikos, George (source : www.namedays.gr)");
		testItem.generateArrayListNames();
		
		actual = testItem.getNames();
		
		String expected = "Glykeria";
		expectedNames.add(expected);
		String expected2 = "Nikos";
		expectedNames.add(expected2);
		String expected3 = "George";
		expectedNames.add(expected3);
		
		
		for(int i = 0; i < actual.length; i++)
		{
			actualNames.add(actual[i]);
		}

		
		assertEquals(actualNames, expectedNames);
		
		
	}
	
	public void testGenerateArrayListNamesNoPar()
	{
		String[] actual=null;
		
		testItem.setLink("eortologio.gr");
		testItem.setTitle(":  Glykeria, Nikos, George source : www.namedays.gr)");
		testItem.generateArrayListNames();
		
		actual = testItem.getNames();
		
		String expected = "Glykeria";
		expectedNames.add(expected);
		String expected2 = "Nikos";
		expectedNames.add(expected2);
		String expected3 = "George source";
		expectedNames.add(expected3);
		
		
		for(int i = 0; i < actual.length; i++)
		{
			actualNames.add(actual[i]);
		}

		
		assertEquals(actualNames, expectedNames);
		
		
	}
	
	public void testGenerateArrayListNamesEmpty()
	{
		String[] actual=null;
		
		testItem.setLink("eortologio.gr");
		testItem.setTitle("today 13/5 :  (source : www.namedays.gr)");
		testItem.generateArrayListNames();
		
		actual = testItem.getNames();
		
		String expected = "";
		expectedNames.add(expected);
		
		
		
		for(int i = 0; i < actual.length; i++)
		{
			actualNames.add(actual[i]);
		}

		
		assertEquals(actualNames, expectedNames);
		
		
	}
	
	public void testGenerateArrayListNamesNocelebration()
	{
		String[] actual=null;
		
		testItem.setLink("eortologio.gr");
		testItem.setTitle("today 13/5 : No widely Namedays today (source : www.namedays.gr)");
		testItem.generateArrayListNames();
		
		actual = testItem.getNames();
		
		String expected = "No widely Namedays today";
		expectedNames.add(expected);
		
		
		
		for(int i = 0; i < actual.length; i++)
		{
			actualNames.add(actual[i]);
		}

		
		assertEquals(actualNames, expectedNames);
		
		
	}
	
	public void testGenerateArrayListNamesNoPar2()
	{
		String[] actual=null;
		
		testItem.setLink("eortologio.gr");
		testItem.setTitle("today 13/5 : Nikos");
		testItem.generateArrayListNames();
		
		actual = testItem.getNames();
		
		String expected = "Nikos";
		expectedNames.add(expected);
		
		
		
		for(int i = 0; i < actual.length; i++)
		{
			actualNames.add(actual[i]);
		}

		
		assertEquals(actualNames, expectedNames);
		
		
	}

}
