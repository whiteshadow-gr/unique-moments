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
				/**
				 * display the message in the textview
				 */
				TextView inTxt = (TextView) findViewById(R.id.SMSArea);
				inTxt.setText(intent.getExtras().getString("sms"));
			}
		};
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms_layout);
		
		/**
		 * intent to filter for SMS messages received
		 */
		intentFilter = new IntentFilter();
		intentFilter.addAction("SMS_RECEIVED_ACTION");
		
		Button sendSMS = (Button) findViewById(R.id.SendMessage);
		msgTxT = (EditText) findViewById(R.id.Message);
		numTxT = (EditText) findViewById(R.id.Number);
	}
	
	/**
	 * sendSmsClick this method is called by a button via onclick method, sends the sms.
	 * @param v v is needed in order to have this method called by a button
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
		/**
		 * register the receiver
		 */
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