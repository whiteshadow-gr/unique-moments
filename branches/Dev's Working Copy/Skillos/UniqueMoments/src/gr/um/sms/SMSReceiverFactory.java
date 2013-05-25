package gr.um.sms;

import gr.um.interfaces.ISMSReceiver;

public class SMSReceiverFactory 
{
	public static ISMSReceiver getInstance(SMSReceiverTypes type)
	{
		switch (type)
		{
		case SMS_RECEIVER:
			return new SMSReceiver();
		case MOCK_SMS_RECEIVER:
			return new MockSMSReceiver();
		default:
			return new SMSReceiver();
		}
	}
}
