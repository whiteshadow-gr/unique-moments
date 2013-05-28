package gr.um.activities;

import gr.um.sms.SMSSender;
import gr.um.uniquemoments.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivitySMS extends Activity
{
	private EditText msgTxT;
	private EditText numTxT;
	private IntentFilter intentFilter;	
	
	/**
	 * intentReceiver intentReceiver is a BroadcastReceiver and is used to send the data, the message via a button to the right appin order to send the sms succesfully
	 */
	private BroadcastReceiver intentReceiver = new BroadcastReceiver()
		{
			@Override
			public void onReceive(Context context, Intent intent) 
			{
				//display the message in the textview
				TextView inTxt = (TextView) findViewById(R.id.SMSArea);
				inTxt.setText(intent.getExtras().getString("sms"));
			}
		};
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms_layout);
		
		//intent to filter for SMS messages received
		intentFilter = new IntentFilter();
		intentFilter.addAction("SMS_RECEIVED_ACTION");
		
		Button sendSMS = (Button) findViewById(R.id.SendMessage);
		msgTxT = (EditText) findViewById(R.id.Message);
		numTxT = (EditText) findViewById(R.id.Number);
		/*
		sendSMS.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				String myMsg = msgTxT.getText().toString();
				String theNumber = numTxT.getText().toString();
				sendMsg(theNumber, myMsg);
			}
		});
		*/
	}

	/*
	protected void sendMsg(String theNumber, String myMsg) 
	{
		String SENT = "Message Sent";
		String DELIVERED = "Message Delivered";
		
		PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,new Intent(SENT), 0);
		PendingIntent deliveredPI = PendingIntent.getBroadcast(this,0,new Intent(DELIVERED), 0);
		
		registerReceiver (new BroadcastReceiver()
			{	
				@Override
				public void onReceive(Context arg0, Intent arg1)
				{
					switch (getResultCode())
					{
						case Activity.RESULT_OK:
							Toast.makeText(ActivitySMS.this, "SMS Sent", Toast.LENGTH_LONG).show();	
							break;
						case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
							Toast.makeText(getBaseContext(), "Generic Failure", Toast.LENGTH_LONG).show();
							break;
						case SmsManager.RESULT_ERROR_NO_SERVICE:
							Toast.makeText(getBaseContext(), "No Service", Toast.LENGTH_LONG).show();
							break;
					}
				}
			}, new IntentFilter(SENT));
		
		registerReceiver(new BroadcastReceiver() 
			{
				@Override
				public void onReceive(Context arg0, Intent arg1)
				{
					switch (getResultCode())
					{
						case Activity.RESULT_OK:
							Toast.makeText(getBaseContext(), "SMS delivered", Toast.LENGTH_LONG).show();
							break;
						case Activity.RESULT_CANCELED:
							Toast.makeText(getBaseContext(), "SMS not delivered", Toast.LENGTH_LONG).show();
							break;		
					}
				}
			}, new IntentFilter(DELIVERED));
		
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(theNumber, null, myMsg, sentPI, deliveredPI);
	}
	*/
	
	
	public void sendSmsClick(View v)
	{
		String SENT = "Message Sent";
		String DELIVERED = "Message Delivered";
		
		PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,new Intent(SENT), 0);
		PendingIntent deliveredPI = PendingIntent.getBroadcast(this,0,new Intent(DELIVERED), 0);
		
		String number = numTxT.getText().toString();
		String message = msgTxT.getText().toString();
		
		SMSSender sender = new SMSSender();
		sender.sendSms(number, message, this, sentPI, deliveredPI);
	}
	
	@Override
	protected void onResume() 
	{
		//register the receiver
		registerReceiver(intentReceiver, intentFilter);
		super.onResume();
	}
	
	@Override
	protected void onPause() 
	{
		//unregister the receiver 
		unregisterReceiver(intentReceiver);
		super.onPause();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
}