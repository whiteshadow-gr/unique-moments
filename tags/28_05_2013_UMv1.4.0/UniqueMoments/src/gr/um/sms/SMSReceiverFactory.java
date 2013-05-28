package gr.um.sms;

import gr.um.interfaces.ISMSReceiver;

/**
 * SMSReceiverFactory a factory class for constructing the different types of sms receivers
 */
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