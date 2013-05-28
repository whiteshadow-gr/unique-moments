package gr.um.entities;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class Contact 
{
	private String ID;
	private String Name;
	private String Phone;
	private String Email;
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * constructor
	 */
	public Contact()
	{
		this.ID = "";
		this.Name = "";
		this.Phone = "";
		this.Email = "";
	}
	
	
	/*
	 * Constructor
	 */
	public Contact(String myName, String myPhone)
	{
		this.Name = myName;
		this.Phone = myPhone;
	}
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * get functions	
	 */
	public String getID()
	{
		return this.ID;
	}
	
	public String getName()
	{
		return this.Name;
	}
	
	public String getPhone()
	{
		return this.Phone;
	}
	
	public String getEmail()
	{
		return this.Email;
	}
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * set functions
	 */
	public void setID(String myId)
	{
		this.ID = myId;
	}
	
	public void setName (String myName)
	{
		this.Name = myName;
	}

	
	public void setPhone (String myPhone)
	{
		this.Phone = myPhone;
	}
		
	public void setEmail (String myEmail)
	{
		this.Email = myEmail;
	}
}
