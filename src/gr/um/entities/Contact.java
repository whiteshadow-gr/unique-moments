package gr.um.entities;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class Contact 
{
	private String ID;
	private String Name;
	private String Phone;
	private String Email;
	private String Nickname;
	private String Relationship;
	private String Birthday;
	private String Nameday;
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/*
	 * constructor
	 */
	public Contact()
	{
		this.ID="";
		this.Name = "";
		this.Phone = "";
		this.Email = "";
		this.Nickname = "";
		this.Relationship = "";
		this.Birthday = "";
		this.Nameday = "";
	}
	
	
	/*
	 * Constructor
	 */
	public Contact(String myName, String myPhone/*, String myEmail,String myNickname, String myRelationship, String myBirthday, String myNameday*/)
	{
		this.Name = myName;
		this.Phone = myPhone;
		
		/*	this.Email = myEmail;
			this.Nickname = myNickname;
			this.Relationship = myRelationship;
			this.Birthday = myBirthday;
			this.Nameday = myNameday;
		*/
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
	
	public String getNickname()
	{
		return this.Nickname;
	}
	
	public String getRelationship()
	{
		return this.Relationship;
	}
	
	public String getBirthday()
	{
		return this.Birthday;
	}
	
	public String getNameday()
	{
		return this.Nameday;
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
	
	public void setNickname (String myNickname)
	{
		this.Nickname = myNickname;
	}
	
	public void setRelationship (String myRelationship)
	{
		this.Relationship = myRelationship;
	}
	
	public void setBirthday (String myBirthday)
	{
		this.Birthday = myBirthday;
	}
	
	public void setNameday (String myNameday)
	{
		this.Nameday = myNameday;
	}
	
}
