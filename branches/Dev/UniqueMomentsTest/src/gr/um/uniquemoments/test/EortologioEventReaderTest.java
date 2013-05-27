package gr.um.uniquemoments.test;

import gr.um.entities.RSSItem;
import gr.um.eortologio.EventReaderFactory;
import gr.um.eortologio.EventReaderTypes;
import gr.um.interfaces.ICelebrationEventReader;

import java.util.ArrayList;

import android.content.Context;
import android.test.AndroidTestCase;

public class EortologioEventReaderTest extends AndroidTestCase 
{

	private ICelebrationEventReader reader = null;
	private Context context = null;
	
	@SuppressWarnings("static-access")
	protected void setUp() throws Exception 
	{
		super.setUp();
		this.context = getContext();
		reader = new EventReaderFactory(context).getInstance(EventReaderTypes.TEST_EVENT_READER);
		
	}

	public void testRetrieveRSSFeedMock()
	{
		String Expectedtitle = "today 17/5 :  Andronikos, Androniki, Iounia, Solon, Solonas, Solohon (source : www.namedays.gr)";
		ArrayList<RSSItem> list = new ArrayList<RSSItem>();
		
		
		list = reader.retrieveRSSFeed(list);
		
		String Actualtitle = list.get(0).title;
		
		assertEquals(Expectedtitle, Actualtitle);
	
		
	}
	
	public void testgetRSSNames()
	{
		ArrayList<String> expectedList = new ArrayList<String>();
		ArrayList<String> actualList = new ArrayList<String>();
		
		expectedList.add("Andronikos");
		expectedList.add("Androniki");
		expectedList.add("Iounia");
		expectedList.add("Solon");
		expectedList.add("Solonas");
		expectedList.add("Solohon");
		
		actualList = reader.getRSSNames();
		
		assertEquals(expectedList, actualList);
		
	}

	
	
	
	
}
