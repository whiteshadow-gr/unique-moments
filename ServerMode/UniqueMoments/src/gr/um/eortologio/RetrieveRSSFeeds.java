package gr.um.eortologio;

import gr.um.activities.ActivityNotification;
import gr.um.database.ControllerEventReader;
import gr.um.entities.RSSItem;
import gr.um.interfaces.ICelebrationEventReader;

import java.util.ArrayList;

import android.os.AsyncTask;

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
	
	/**
	 * RetrieveRSSFeeds constructor with one parameter
	 * @param activityDailyEvents
	 */
	public RetrieveRSSFeeds(ActivityNotification activityDailyEvents) 
	{
		this.activityDailyEvents = activityDailyEvents;
	    itemlist = new ArrayList<RSSItem>();
	}

	/**
	 * doInBackground(Void... params) This function is responsible for poping the apropriate notification to the user according to how many of
	 * the user's Contacts have their Name Day today
	 */
	@Override
    protected Void doInBackground(Void... params) 
	{
		ICelebrationEventReader reader = EventReaderFactory.getInstance(EventReaderTypes.TEST_MODE);
		
		ControllerEventReader controller = new ControllerEventReader(reader);
        int numOfPeopleCelebrating = controller.getHowManyCelebrate();
            
		if(!(numOfPeopleCelebrating == 0))
		{
			this.activityDailyEvents.notifyfunc("Today "+Integer.toString(numOfPeopleCelebrating)+" names are celebrating!");	
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
         super.onPostExecute(result);
     }
      
     @Override
     protected void onProgressUpdate(Void... values) 
     {
         super.onProgressUpdate(values);
     }
 }