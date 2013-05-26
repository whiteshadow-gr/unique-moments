package gr.um.email;

import gr.um.interfaces.IEmail;
import android.app.Activity;
import android.content.Intent;

public class EmailSender implements IEmail
{
	public Activity activityEmail;
	private String whereto;
	private String MailHeader;
	private String ActualMessage;
	
	public EmailSender(Activity act)
	{
		activityEmail = act;
	}
	
	public void sendEmail(Intent emailIntent)
	{
		MailHeader = emailIntent.EXTRA_SUBJECT;
		ActualMessage = emailIntent.EXTRA_TEXT;
		whereto = emailIntent.EXTRA_EMAIL;
		activityEmail.startActivity(Intent.createChooser(emailIntent, "Email"));
	}

	@Override
	public String[] getIntentData() 
	{
		// TODO Auto-generated method stub
		String[] data = new String[3];
		data[0] = MailHeader;
		data[1] = ActualMessage;
		data[2] = whereto;
		
		return data;
	}
}

