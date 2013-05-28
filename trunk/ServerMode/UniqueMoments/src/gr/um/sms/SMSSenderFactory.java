package gr.um.sms;

import gr.um.interfaces.ISMSSender;

/**
 * SMSSenderFactory a factory class for constructing the different types of sms senders
 */
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