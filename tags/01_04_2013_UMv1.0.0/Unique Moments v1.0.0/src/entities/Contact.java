package entities;

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
	
	
//constructors
	public Contact()
	{
		ID="";
		Name = "";
		Phone = "";
		Email = "";
		Nickname = "";
		Relationship = "";
		Birthday = "";
		Nameday = "";
	}
	
	public Contact(String myName, String myPhone/*, String myEmail,String myNickname, String myRelationship, String myBirthday, String myNameday*/)
	{
		Name = myName;
		Phone = myPhone;
		/*Email = myEmail;
		/*Nickname = myNickname;
		Relationship = myRelationship;
		Birthday = myBirthday;
		Nameday = myNameday;*/
	}
	
	
//-----------------------------------------------------------------------------------------------------------------------------------------//
	
//get functions	
	public String getID()
	{
		return ID;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getPhone()
	{
		return Phone;
	}
	
	public String getEmail()
	{
		return Email;
	}
	
	public String getNickname()
	{
		return Nickname;
	}
	
	public String getRelationship()
	{
		return Relationship;
	}
	
	public String getBirthday()
	{
		return Birthday;
	}
	
	public String getNameday()
	{
		return Nameday;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------//
	
//set functions
	public void setID(String myId)
	{
		ID = myId;
	}
	
	public void setName (String myName)
	{
		Name = myName;
	}

	
	public void setPhone (String myPhone)
	{
		Phone = myPhone;
	}
		
	public void setEmail (String myEmail)
	{
		Email = myEmail;
	}
	
	public void setNickname (String myNickname)
	{
		Nickname = myNickname;
	}
	
	public void setRelationship (String myRelationship)
	{
		Relationship = myRelationship;
	}
	
	public void setBirthday (String myBirthday)
	{
		Birthday = myBirthday;
	}
	
	public void setNameday (String myNameday)
	{
		Nameday = myNameday;
	}
}
