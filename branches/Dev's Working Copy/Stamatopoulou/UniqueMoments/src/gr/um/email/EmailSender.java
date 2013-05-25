package gr.um.email;

import gr.um.interfaces.IEmail;
import android.app.Activity;
import android.content.Intent;

public class EmailSender implements IEmail
{
	Activity activityEmail;
	
	public EmailSender(Activity act)
	{
		activityEmail = act;
	}
	
	public void sendEmail(Intent emailIntent)
	{
		activityEmail.startActivity(Intent.createChooser(emailIntent, "Email"));
	}
}
