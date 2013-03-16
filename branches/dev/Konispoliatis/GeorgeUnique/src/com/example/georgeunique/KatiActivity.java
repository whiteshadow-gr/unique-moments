package com.example.georgeunique;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

public class KatiActivity extends Activity {
	SQLiteDatabase db;
	String temp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kati);
		// Show the Up button in the action bar.
		DBCreation k1=new DBCreation();
		db=openOrCreateDatabase("unique_moments_db.db",MODE_PRIVATE, null);
		temp=k1.getGroups();
		db.execSQL(temp);
		temp=k1.getNumber_Types();
		db.execSQL(temp);
		db.execSQL(temp);
		temp=k1.getMessage_Types();
		db.execSQL(temp);
		temp=k1.getMessages(); //not work
		db.execSQL(temp); //not work
		temp=k1.getRelationships();
		db.execSQL(temp);
		temp=k1.getContacts(); //not work
		db.execSQL(temp); //not work
		temp=k1.getDate_Types();//fixed
		db.execSQL(temp);//fixed
		temp=k1.getDates();//not work
		db.execSQL(temp);//not work
		temp=k1.getEvents();//fixed
		db.execSQL(temp);//fixed
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kati, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void ClickOpen()
	{
		DBConnection start=new DBConnection();
		start.open_DB();	
	}
	public void ClickClose()
	{
		DBConnection start=new DBConnection();
		start.close_DB();
	}
}
