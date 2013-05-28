package gr.um.eortologio;

import gr.um.entities.RSSItem;
import gr.um.interfaces.ICelebrationEventReader;

import java.util.ArrayList;

public class MockEventReader implements ICelebrationEventReader 
{

	@Override
	public ArrayList<String> getRSSNames() 
	{
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}

	@Override
	public ArrayList<RSSItem> retrieveRSSFeed(ArrayList<RSSItem> list) {
		// TODO Auto-generated method stub
		return null;
	}
}