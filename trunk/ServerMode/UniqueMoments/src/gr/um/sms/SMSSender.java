package gr.um.sms;

import gr.um.interfaces.ISMSSender;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.gsm.SmsManager;
import android.widget.Toast;

public class SMSSender implements ISMSSender
{
	private String SENT = "Message Sent";
	private String DELIVERED = "Message Delivered";
	
	/**
	 * sendSms this function determines what to do in order to send an sms
	 */
	@Override
	public void sendSms(String number, String message, Context context, PendingIntent sentPI, PendingIntent deliveredPI) 
	{		
		context.registerReceiver (new BroadcastReceiver()
		{	
			@Override
			public void onReceive(Context arg0, Intent arg1)
			{
				switch (getResultCode())
				{
					case Activity.RESULT_OK:
						break;
					case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
						break;
					case SmsManager.RESULT_ERROR_NO_SERVICE:
						break;
				}
			}
		}, new IntentFilter(SENT));
		
		context.registerReceiver(new BroadcastReceiver() 
		{
			@Override
			public void onReceive(Context arg0, Intent arg1)
			{
				switch (getResultCode())
				{
					case Activity.RESULT_OK:
						break;
					case Activity.RESULT_CANCELED:
						break;		
				}
			}
		}, new IntentFilter(DELIVERED));
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(number, null, message, sentPI, deliveredPI);
	}
}