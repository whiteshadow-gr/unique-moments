package gr.um.uniquemoments;

import gr.um.eortologio.RetrieveRSSFeeds;
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
    
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	        	    
	    new RetrieveRSSFeeds(this).execute();
	    
	    Intent i = new Intent(this, ActivityMainMenu.class);
	    startActivity(i);
	    
	}
	
	 
	@SuppressWarnings("deprecation")
	public void notifyfunc(String namedays) 
	{
			
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(uniqueID);
		Intent intent = new Intent(ActivityNotification.this, ActivityDailyEvents.class);
		PendingIntent pi = PendingIntent.getActivity(ActivityNotification.this, 0, intent, 0);
		
		String body = namedays;
		String title = "Namedays !";
		
		Notification n = new Notification(R.drawable.ic_launcher, body, System.currentTimeMillis());
		n.setLatestEventInfo(ActivityNotification.this, title, body, pi);
		n.defaults = Notification.DEFAULT_ALL;
		nm.notify(uniqueID, n);
		
	}
	  
}