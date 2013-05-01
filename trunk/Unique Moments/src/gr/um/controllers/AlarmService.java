package gr.um.controllers;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class AlarmService extends Service
{
	 private Alarm alarm = new Alarm();
	 
	//-------------------------------------------------------------------------------------------------------------------------------------//
	 
	 
	 /*
	  * Constructor
	  */
	 public void onCreate()
	 {
		 super.onCreate();       
	 }

	 public void onStart(Context context,Intent intent, int startId)
	 {
	     alarm.SetAlarm(context);
	 }

	 @Override
	 public IBinder onBind(Intent intent) 
	 {
	     return null;
	 }
	 
}
