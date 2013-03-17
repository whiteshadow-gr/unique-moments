import junit.framework.TestCase;


public abstract class RecallLastCommunication extends TestCase {

	protected static void setUpBeforeClass() throws Exception {
	}

	public boolean RecallLastSentMSG(String Name1,String Name2)
	{
		return false;
	}
	
	public String getReturnLastSentMSG(String Name1,String Name2)
	{
		return getName();
	}
	
	public boolean RecallLastReceivedMSG(String Name1,String Name2)
	{
		return false;
	}
	
	
	public String getReturnLastReceivedMSG(String Name1,String Name2)
	{
		return getName();
	}
	
	
	
	
	
	
}
