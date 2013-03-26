package com.example.example;

import java.util.Calendar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button button1 = (Button) findViewById(R.id.button1);
		
		button1.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// A date-time specified in milliseconds since the epoch.
				long startMillis = 0;
				Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
				builder.appendPath("time");
				ContentUris.appendId(builder, startMillis);
				Intent intent = new Intent(Intent.ACTION_VIEW)
				    .setData(builder.build());
				startActivity(intent);
			}
		});
		
		final Button button2 = (Button)  findViewById(R.id.button2);
		
		button2.setOnClickListener(new View.OnClickListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				long calID = 3;
				long startMillis = 0; 
				long endMillis = 0;     
				Calendar beginTime = Calendar.getInstance();
				beginTime.set(2012, 9, 14, 7, 30);
				startMillis = beginTime.getTimeInMillis();
				Calendar endTime = Calendar.getInstance();
				endTime.set(2012, 9, 14, 8, 45);
				endMillis = endTime.getTimeInMillis();
			
				ContentResolver cr = getContentResolver();
				ContentValues values = new ContentValues();
				values.put(Events.DTSTART, startMillis);
				values.put(Events.DTEND, endMillis);
				values.put(Events.TITLE, "Jazzercise");
				values.put(Events.DESCRIPTION, "Group workout");
				values.put(Events.CALENDAR_ID, calID);
				values.put(Events.EVENT_TIMEZONE, "America/Los_Angeles");
				Uri uri = cr.insert(Events.CONTENT_URI, values);

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
