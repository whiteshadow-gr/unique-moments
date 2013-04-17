package gr.um.uniquemoments;

import gr.um.database.ControllerContactsDb;
import gr.um.database.ControllerDatesDb;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityMainMenu extends Activity 
{
	public static int counter=0;;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		ControllerDatesDb datesData=new ControllerDatesDb(this);
		ControllerContactsDb data = new ControllerContactsDb(this);
		

		ContentResolver cr = getContentResolver();
	 	boolean firstrun = getSharedPreferences("PREFERENCE",MODE_PRIVATE).getBoolean("firstrun", true);
	    if(firstrun)
	    {
	    	data.initializeDatabase(data.getWritableDatabase());
	    	data.importPhonebookData(cr);
	    	//data.close();
	    	datesData.initializeDatabase(datesData.getWritableDatabase());
	    	//datesData.close();
	    }
	    
	    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun",false).commit();
	    
	    if(counter==0)
	    {
	    	counter++;
	    	 Intent i = new Intent(this, ActivityDailyEvents.class);
	 		startActivity(i);
	 		
	    }
	    	    
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		return true;
	}
	
	
	public void goToContacts(View view)
	{
		Intent i = new Intent(this, ActivityContacts.class);
		startActivity(i);
	}
	
	
	public void goToDailyEvents(View view)
	{
		Intent i = new Intent(this, ActivityDailyEvents.class);
		startActivity(i);
	}
	
	
	public void goToCalendar(View view)
	{
		Intent i = new Intent(this, ActivityCalendar.class);
		startActivity(i);
	}
	
	
	public void goToManageEvents(View view)
	{
		Intent i = new Intent(this, ActivityManageEvents.class);
		startActivity(i);
	}
	
	
	/*
	 * Enarksh efarmoghs mhn ylopoihshmo
	 */
	boolean appStarted()
	{
		return true;
	}
	

}
