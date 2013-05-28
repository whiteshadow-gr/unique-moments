package gr.um.activities;

import gr.um.controllers.ControllerContactsDB;
import gr.um.entities.RSSItem;
import gr.um.eortologio.EortologioEventReader;
import gr.um.uniquemoments.R;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityMainMenu extends Activity 
{
	public static int counter = 0;
	Button button;
	private EortologioEventReader rss = new EortologioEventReader("127.0.0.1:8000");
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		ControllerContactsDB data = new ControllerContactsDB(this);
		
		ContentResolver cr = getContentResolver();
	 	boolean firstrun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("firstrun", true);
	    if(firstrun)
	    {
	    	data.initializeDatabase(data.getWritableDatabase());
	    	data.importPhonebookData(cr);
	    }
	    
	    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("firstrun", false).commit();
	    
	    button = (Button)findViewById(R.id.buttonContacts);
	    registerForContextMenu(button);
	    
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
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) 
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		
		Menu mMenu = menu;
		mMenu.add(Menu.NONE, 0, Menu.NONE, "Test Mode");
	}
	
	
	@SuppressLint("NewApi")
	@Override
	public boolean onContextItemSelected(MenuItem item) 
	{		
		switch (item.getItemId()) 
		{
			case 0:
				ArrayList <String> namesnew = new ArrayList <String>();
				namesnew = rss.getRSSNames();
				Toast.makeText(getApplicationContext(), namesnew.toString(), Toast.LENGTH_SHORT).show();
				break;
		}
		return super.onContextItemSelected(item);
	}
	
	
	public boolean onLongClick(View v) 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
