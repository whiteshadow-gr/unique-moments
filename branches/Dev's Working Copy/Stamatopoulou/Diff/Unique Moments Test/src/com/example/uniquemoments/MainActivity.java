package com.example.uniquemoments;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	public void gotodaily (View view )
	 {
	  Intent intent= new Intent (MainActivity.this, DailyEventsActivity.class);
	  startActivity(intent);
	 }
	
	public void gotocalendar (View view )
	 {
	  Intent intent= new Intent (MainActivity.this, CalendarActivity.class);
	  startActivity(intent);
	 }
	
	public void gotomanageevents (View view )
	 {
	  Intent intent= new Intent (MainActivity.this, ManageEventsActivity.class);
	  startActivity(intent);
	 }
	
	public void gotocontacts (View view )
	 {
	  Intent intent= new Intent (MainActivity.this, ContactsActivity.class);
	  startActivity(intent);
	 }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DatabaseController dbController = new DatabaseController(this);        
	    SQLiteDatabase db = dbController.getWritableDatabase();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
