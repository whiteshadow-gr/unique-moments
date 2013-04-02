package com.example.myuniquemoments;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ActivityDailyEvents extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daily_events);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_daily_events, menu);
		return true;
	}

}
