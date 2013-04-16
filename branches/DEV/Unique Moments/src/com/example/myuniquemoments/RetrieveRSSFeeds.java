package com.example.myuniquemoments;

import java.util.ArrayList;

import android.os.AsyncTask;
import entities.RSSItem;

class RetrieveRSSFeeds extends AsyncTask<Void, Void, Void>
 {
	static ArrayList<RSSItem> itemlist = null;

 	//ektelesi tis sundesis sto rssfeed me tin voitheia tou AsyncTask i opoia ektelei tin diadikasia sto background
    
     
             /**
	 * 
	 */
	private final ActivityDailyEvents activityDailyEvents;

	/**
	 * @param activityDailyEvents
	 */
	RetrieveRSSFeeds(ActivityDailyEvents activityDailyEvents) {
		this.activityDailyEvents = activityDailyEvents;
	    itemlist = new ArrayList<RSSItem>();
	}

			@Override
             protected Void doInBackground(Void... params) {
                    
                    this.activityDailyEvents.notifyfunc(FindEventsController.getImportantNames(this.activityDailyEvents.getApplicationContext()));

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