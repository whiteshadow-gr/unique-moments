package gr.um.email;

import gr.um.interfaces.IEmail;
import android.app.Activity;

/**
 *EmailSenderFactory A factory class for constructing the desired email types.
 */
public class EmailSenderFactory 
{
	public static IEmail getInstance(EmailSenderTypes type, Activity activityEmail)
	{
		switch (type)
		{
		case EMAIL_SENDER:
			return new EmailSender(activityEmail);
		case MOCK_EMAIL_SENDER:
			return new MockEmailSender();
		default:
			return new EmailSender(activityEmail);
		}
	}
}