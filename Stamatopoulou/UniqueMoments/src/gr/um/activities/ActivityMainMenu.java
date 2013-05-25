package gr.um.activities;

import gr.um.database.ContactDBTypes;
import gr.um.database.ContactsDBFactory;
import gr.um.database.ControllerContactsDB;
import gr.um.interfaces.IDatabase;
import gr.um.uniquemoments.R;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityMainMenu extends Activity 
{
	public static int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		IDatabase data =new ContactsDBFactory(getApplicationContext()).getInstance(ContactDBTypes.CONTACTS_SQLITE_DATABASE);
		ControllerContactsDB data1 = new ControllerContactsDB(this);
		
		
		ContentResolver cr = getContentResolver();
	 	boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
	    if(firstrun)
	    {
	    	data.initializeDatabase(data1.getWritableDatabase());
	    	data.importPhonebookData(cr);
	    }
	    
	    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();
	    
	    if(counter == 0)
	    {
	    	counter++;
	    	Intent i = new Intent(this, ActivityNotification.class);
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
		
		
	public void goToManageEvents(View view)
	{
		Intent i = new Intent(this, ActivityManageEvents.class);
		startActivity(i);
	}
		
	//Not Used!!
	boolean appStarted()
	{
		return true;
	}
}
