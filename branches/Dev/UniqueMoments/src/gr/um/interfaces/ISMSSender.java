package gr.um.interfaces;

import android.app.PendingIntent;
import android.content.Context;

public interface ISMSSender 
{
	public void sendSms(String number, String message, Context context, PendingIntent sentPI, PendingIntent deliveredPI);
}
