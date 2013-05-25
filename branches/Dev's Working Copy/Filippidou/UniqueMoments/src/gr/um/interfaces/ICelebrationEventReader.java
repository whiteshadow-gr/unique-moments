package gr.um.interfaces;

import gr.um.entities.RSSItem;

import java.util.ArrayList;

import android.content.Context;

public interface ICelebrationEventReader 
{
	/*
	 * This function returns an ArrayList containing all the names of the Eortologio RSS Feed
	 */
	public ArrayList<String> getRSSNames();
	
	public ArrayList <RSSItem> retrieveRSSFeed(ArrayList <RSSItem> list);
}