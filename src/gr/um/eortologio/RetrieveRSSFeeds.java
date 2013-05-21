package gr.um.eortologio;

import java.util.ArrayList;
import android.os.AsyncTask;
import gr.um.entities.RSSItem;
import gr.um.uniquemoments.ActivityDailyEvents;
import gr.um.uniquemoments.ActivityNotification;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class RetrieveRSSFeeds extends AsyncTask<Void, Void, Void>
 {
	
	public ArrayList<RSSItem> itemlist = null;
	public ActivityNotification activityDailyEvents = null ;
	
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
	public RetrieveRSSFeeds(ActivityNotification activityDailyEvents) 
	{
		this.activityDailyEvents = activityDailyEvents;
	    itemlist = new ArrayList<RSSItem>();
	}

	@Override
    protected Void doInBackground(Void... params) 
	{
       String importantNames = FindEventsController.getImportantNames(this.activityDailyEvents.getApplicationContext());
     
            
		if(!importantNames.equals("0"))
		{
			if(importantNames.equals("error"))
			{
				this.activityDailyEvents.notifyfunc(importantNames);
			}
			else
			{
				this.activityDailyEvents.notifyfunc("You have "+importantNames+" people to say Happy Name Day today!");
			}
				
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