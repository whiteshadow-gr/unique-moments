package controllers;

import java.util.ArrayList;

import entities.RSSItem;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public interface InterfaceRSSFeed 
{
	public RSSItem retrieveRSSFeed(ArrayList<RSSItem> list);
}
