package gr.um.sms;

import gr.um.interfaces.ISMSSender;
import android.app.PendingIntent;
import android.content.Context;

public class MockSMSSender implements ISMSSender
{

	@Override
	public void sendSms(String number, String message, Context context, PendingIntent sentPI, PendingIntent deliveredPI) 
	{
		// TODO Auto-generated method stub
		
	}

}
