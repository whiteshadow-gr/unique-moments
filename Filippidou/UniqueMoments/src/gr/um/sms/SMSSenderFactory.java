package gr.um.sms;

import gr.um.interfaces.ISMSSender;

public class SMSSenderFactory 
{
	public static ISMSSender getInstance(SMSSenderTypes type)
	{
		switch (type)
		{
		case SMS_SENDER:
			return new SMSSender();
		case MOCK_SMS_SENDER:
			return new MockSMSSender();
		default:
			return new SMSSender();
		}
	}
}
