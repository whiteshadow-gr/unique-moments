package gr.um.sms;

import gr.um.interfaces.ISMSReceiver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver implements ISMSReceiver
{

	/**
	 * onReceive this function determines what to do when received an sms
	 */
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		// TODO Auto-generated method stub
		Bundle bundle = intent.getExtras();
		SmsMessage[] messages = null;
		String str= "";

		if (bundle != null) 
		{
			Object[] pdus = (Object[]) bundle.get("pdus");
			messages = new SmsMessage[pdus.length];
			for (int i = 0; i < messages.length; i++)
			{
				messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
				str += "Message from " + messages[i].getOriginatingAddress();
				str += " : ";
				str += messages[i].getMessageBody().toString();
				str += "\n";
			}
			/**
			 * display message
			 */
			Toast.makeText(context, str, Toast.LENGTH_LONG).show();
			
			/**
			 * send a broadcast intent to update the SMS received in a textview
			 */
			Intent broadcastIntent = new Intent();
			broadcastIntent.setAction("SMS_RECEIVED_ACTION");
			broadcastIntent.putExtra("sms", str);
			context.sendBroadcast(broadcastIntent);
		}
	}

	@Override
	public void receiveSms(Context context, Intent intent) 
	{
		// TODO Auto-generated method stub		
	}
}