package gr.um.uniquemoments.test;

import gr.um.eortologio.EortologioEventReader;

import java.io.File;
import java.util.ArrayList;

import android.test.InstrumentationTestCase;

public class EortologioEventReaderTest extends InstrumentationTestCase 
{
	private EortologioEventReader eortologio;
	
	public EortologioEventReaderTest()
	{
		super();
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		File xmlFile = new File("C://Users//Stelios//Workspace//UniqueMomentsEortologioTest//src//gr//um//UniqueMoments//test//MockEortologio.xml");
		
		eortologio = new EortologioEventReader(xmlFile.toURI().toString());
	}
	
	public void testGetNames() 
	{
		
		ArrayList <String> expectedNames = new ArrayList <String>();
		expectedNames.add("Glykeria");
		
		ArrayList <String> actualNames = new ArrayList <String>();
		actualNames = eortologio.getNames();
		
		if(actualNames.isEmpty() || expectedNames.isEmpty())
		{
			fail();
		}
		else
		{
			assertEquals(actualNames,expectedNames);
		}
	}
	
}
