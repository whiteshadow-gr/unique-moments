package gr.um.eortologio;

import java.util.ArrayList;

import gr.um.entities.RSSItem;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public interface InterfaceRSSFeed 
{
	public RSSItem retrieveRSSFeed(ArrayList<RSSItem> list);
}
