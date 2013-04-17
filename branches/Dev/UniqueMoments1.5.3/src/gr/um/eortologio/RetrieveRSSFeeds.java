package gr.um.eortologio;

import java.util.ArrayList;
import android.os.AsyncTask;
import gr.um.entities.RSSItem;
import gr.um.uniquemoments.ActivityDailyEvents;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class RetrieveRSSFeeds extends AsyncTask<Void, Void, Void>
 {
	
	

	public ArrayList<RSSItem> itemlist = null;
	public ActivityDailyEvents activityDailyEvents = null ;
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	public RetrieveRSSFeeds() 
	{
		
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * This function is responsible for poping the apropriate notification to the user according to how many of
	 * the user's Contacts have their Name Day today
	 */
	public RetrieveRSSFeeds(ActivityDailyEvents activityDailyEvents) 
	{
		this.activityDailyEvents = activityDailyEvents;
	    itemlist = new ArrayList<RSSItem>();
	}

	@Override
    protected Void doInBackground(Void... params) 
	{
        ArrayList<String> importantNames = FindEventsController.getImportantNames(this.activityDailyEvents.getApplicationContext());
            
		if(importantNames!=null)
		{
			this.activityDailyEvents.notifyfunc("You have "+importantNames.size()+" people to say Happy Name Day today!");
		}
		else
		{
			this.activityDailyEvents.notifyfunc("No name days today!");
		}
		
        return null;
     }
      
     @Override
     protected void onCancelled() 
     {
         super.onCancelled();
     }
      
     @Override
     protected void onPreExecute() 
     {      
         super.onPreExecute();
     }
     @Override
     protected void onPostExecute(Void result) 
     {
         // setListAdapter(rssadaptor);     
         super.onPostExecute(result);
     }
      
     @Override
     protected void onProgressUpdate(Void... values) 
     {
         super.onProgressUpdate(values);
     }
 }