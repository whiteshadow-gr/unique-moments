package gr.um.activities;

import gr.um.eortologio.RetrieveRSSFeeds;
import gr.um.uniquemoments.R;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityNotification extends ListActivity 
{
	public NotificationManager nm;
	public int uniqueID = 1;
	   
	//-------------------------------------------------------------------------------------------------------------------------------------//
    
	/**
	 * onCreate initializing notification
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	        	    
	    new RetrieveRSSFeeds(this).execute();
	    
	    Intent i = new Intent(this, ActivityMainMenu.class);
	    startActivity(i);   
	}
		 
	/**
	 * notifyfunc is the method that displays the notification on the upperside of the screen. 
	 * @param namedays is the string that will appear.
	 */
	@SuppressWarnings("deprecation")
	public void notifyfunc(String namedays) 
	{		
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(uniqueID);
		Intent intent = new Intent(ActivityNotification.this, ActivityDailyEvents.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(ActivityNotification.this, 0, intent, 0);
		
		String body = namedays;
		String title = "Namedays !";
		
		Notification notification = new Notification(R.drawable.ic_launcher, body, System.currentTimeMillis());
		notification.setLatestEventInfo(ActivityNotification.this, title, body, pendingIntent);
		notification.defaults = Notification.DEFAULT_ALL;
		nm.notify(uniqueID, notification);
	}
}