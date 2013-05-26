package gr.um.email;

import android.content.Intent;

public class EmailBuilder 
{
	private String[] to = null;
	private String subject = "";
	private Intent emailIntent = null;
	
	public EmailBuilder()
	{
		to = new String[]{""};
		subject = ("A message from Unique-Moments");
		emailIntent = new Intent(Intent.ACTION_SEND);
	}
	

	public Intent createEmailIntent(String message) 
	{
		emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, message);
		emailIntent.setType("message/rfc822");
		
		return emailIntent;
	}
}
