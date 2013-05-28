package gr.um.interfaces;

import java.util.ArrayList;

import gr.um.entities.RSSItem;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public interface IRSSFeed
{
        public RSSItem retrieveRSSFeed(ArrayList<RSSItem> list);
}