package com.example.myuniquemoments;

import controllers.ControllerDatabase;
import entities.Contact;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class ActivityMainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		ControllerDatabase data=new ControllerDatabase(this);
		data.getWritableDatabase();
		Contact testContact=new Contact("asd","asd");
		boolean test=data.addContact(testContact);
		ContentResolver cr = getContentResolver();
		data.importPhonebookData(cr);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
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
