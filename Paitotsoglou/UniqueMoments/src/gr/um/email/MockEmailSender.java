package gr.um.email;

import gr.um.interfaces.IEmail;
import android.content.Intent;
import android.os.Bundle;

public class MockEmailSender implements IEmail
{
	private String whereto;
	private String MailHeader;
	private String ActualMessage;
	
	public String[] actual;
	
	public MockEmailSender()
	{
		
	}
	

	@Override
	public void sendEmail(Intent emailIntent) 
	{	
		MailHeader = emailIntent.getStringExtra("android.intent.extra.EMAIL");
		ActualMessage = emailIntent.getStringExtra("android.intent.extra.SUBJECT");
		whereto = emailIntent.getStringExtra("android.intent.extra.TEXT");
	}

	@Override
	public String[] getIntentData() 
	{
		String[] data = new String[3];
		data[0] = MailHeader;
		data[1] = ActualMessage;
		data[2] = whereto;
		
		return data;
	}
}

