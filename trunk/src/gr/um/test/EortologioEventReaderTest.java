package gr.um.test;

import gr.um.eortologio.EortologioEventReader;
import junit.framework.TestCase;

//-----------------------------------------------------------------------------------------------------------------------------------------//

/*
 * Unit Test Example...! :D
 */

public class EortologioEventReaderTest extends TestCase 
{
	private EortologioEventReader eortologio;
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	protected void setUp() throws Exception 
	{
		super.setUp();
		eortologio = new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
	}

	public void testGetNames() 
	{
		String expected = "σήμερα Τρι 16 Απρ 13 : Γαλήνη, Γαληνός, Νίκη, Χιονία, Χιονούλα, Χιονίτσα, Χιονάτη, Καλλίς, Καλλίδα, Καλλία, Κάλλι, Καλίς, Καλίδα, Καλία, Κάλι (";
		String actual = eortologio.getNames().get(0);
		assertEquals(expected,actual);
	}

}
