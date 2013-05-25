package gr.um.email;

import gr.um.interfaces.IEmail;
import android.content.Intent;

public class MockEmailSender implements IEmail
{
	private String whereto;
	private String MailHeader;
	private String ActualMessage;
	
	public String[] actual;
	
	public MockEmailSender()
	{
		ActualMessage= "Geia sou";
		MailHeader="Message form Unique_Moments";
		whereto = "tpaito@yahoo.com";
	}
	

	@Override
	public void sendEmail(Intent emailIntent) 
	{	
		
		actual[0]= whereto;
		actual[1]= ActualMessage;
		actual[2] = MailHeader;
	}
}
