package com.example.myuniquemoments;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import controllers.ControllerDatesDb;
import controllers.RSSParser;
import entities.RSSItem;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityDailyEvents extends ListActivity 
{

	private static ArrayList<RSSItem> itemlist = null;
	public static NotificationManager nm;
	public static int uniqueID = 1;
	
    
//-----------------------------------------------------------------------------------------------------------------------------------------//
    
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    
	    itemlist = new ArrayList<RSSItem>();
	    	    
	    new RetrieveRSSFeeds().execute();
	    
	    Intent i = new Intent(this, ActivityMainMenu.class);
		startActivity(i);
	    
	}
	
	
	 
	 public static void retrieveRSSFeed(String urlToRssFeed,ArrayList<RSSItem> list)
	 {
	     	//sunartisi i opoia ulopoiei tin sundesi sto rssfeed.
	     try
	     {
	        URL url = new URL(urlToRssFeed);
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser parser = factory.newSAXParser();
	        XMLReader xmlreader = parser.getXMLReader();
	        RSSParser theRssHandler = new RSSParser(list);
	  
	        xmlreader.setContentHandler(theRssHandler);
	  
	        InputSource is = new InputSource(url.openStream());
	  
	        xmlreader.parse(is);
	        
	     }
	     catch (Exception e)
	     {
	         e.printStackTrace();
	     }
	     
	    // RSSItem data = list.get(0);
	     //return(data.title);
	 }
	 
	 @SuppressWarnings("deprecation")
	public void notifyfunc(String namedays) {
			
			nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			nm.cancel(uniqueID);
			Intent intent = new Intent(ActivityDailyEvents.this, ActivityMainMenu.class);
			PendingIntent pi = PendingIntent.getActivity(ActivityDailyEvents.this, 0, intent, 0);
			
			String body = namedays;
			String title = "Namedays !";
			
			Notification n = new Notification(R.drawable.ic_launcher, body, System.currentTimeMillis());
			n.setLatestEventInfo(ActivityDailyEvents.this, title, body, pi);
			n.defaults = Notification.DEFAULT_ALL;
			nm.notify(uniqueID, n);
			
			
		}
	     
	  
	 private class RetrieveRSSFeeds extends AsyncTask<Void, Void, Void>
	 {
	 	//ektelesi tis sundesis sto rssfeed me tin voitheia tou AsyncTask i opoia ektelei tin diadikasia sto background
	    
	     
	             @Override
	             protected Void doInBackground(Void... params) {
	                               
	             		retrieveRSSFeed("http://www.eortologio.gr/rss/si_en.xml",itemlist);
	                    itemlist.get(0).generateArrayListNames();
	                    
	 
	                   
	                     String[] names=itemlist.get(0).title.split("\\(");
	                     notifyfunc(names[0]);
	                    ControllerDatesDb db=new ControllerDatesDb(getApplicationContext()); 
	                   db.addDates(itemlist.get(0).getNames());
	                  

	                     return null;
	             }
	      
	             @Override
	             protected void onCancelled() {
	                     super.onCancelled();
	             }
	              
	             @Override
	             protected void onPreExecute() {      
	                     super.onPreExecute();
	             }
	             @Override
	             protected void onPostExecute(Void result) {
	                   // setListAdapter(rssadaptor);
	                      
	                     super.onPostExecute(result);
	             }
	              
	             @Override
	             protected void onProgressUpdate(Void... values) {
	                     super.onProgressUpdate(values);
	             }
	 }
	  
}