package gr.um.activities;

import gr.um.uniquemoments.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityManageEvents extends Activity 
{
	/**
	 * onCreate initializes the activity manage events
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_events);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		/**
		 * Inflate the menu; this adds items to the action bar if it is present.
		 */
		getMenuInflater().inflate(R.menu.activity_manage_events, menu);
		return true;
	}
}