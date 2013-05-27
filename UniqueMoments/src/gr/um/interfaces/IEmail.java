package gr.um.interfaces;

import android.content.Intent;

public interface IEmail 
{
	public void sendEmail(Intent emailIntent);
	public String[] getIntentData();
}
