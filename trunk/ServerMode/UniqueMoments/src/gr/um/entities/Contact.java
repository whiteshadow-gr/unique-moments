package gr.um.entities;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class Contact 
{
	private String ID;
	private String Name;
	private String Phone;
	private String Email;
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/**
	 * Contact() constructor without parameters
	 */
	public Contact()
	{
		this.ID = "";
		this.Name = "";
		this.Phone = "";
		this.Email = "";
	}
	
	/**
	 * Contact(String myName, String myPhone) Constructor with 2 parameters
	 * @param myName String containing the name of the contact
	 * @param myPhone String containing the phone of the contact
	 */
	public Contact(String myName, String myPhone)
	{
		this.Name = myName;
		this.Phone = myPhone;
	}
		
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/**
	 * GetID() returns the ID of the contact
	 * @return String ID containing the ID of the contact	
	 */
	public String getID()
	{
		return this.ID;
	}
	
	/**
	 * getName() returns the name of the contact
	 * @return String Name containing the name of the contact
	 */
	public String getName()
	{
		return this.Name;
	}
	
	/**
	 * getPhone() returns the phone of the contact
	 * @return String Phone containing the phone of the contact
	 */
	public String getPhone()
	{
		return this.Phone;
	}
	
	/**
	 * getEmail() returns the email of the contact
	 * @return String Email containing the email of the contact
	 */
	public String getEmail()
	{
		return this.Email;
	}
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/**
	 * setID() adds the ID of the contact
	 */
	public void setID(String myId)
	{
		this.ID = myId;
	}
	
	/**
	 * setName() adds the name of the contact
	 */
	public void setName (String myName)
	{
		this.Name = myName;
	}
	
	/**
	 * setPhone() adds the phone of the contact
	 */
	public void setPhone (String myPhone)
	{
		this.Phone = myPhone;
	}
	
	/**
	 * setEmail() adds the email of the contact
	 */
	public void setEmail (String myEmail)
	{
		this.Email = myEmail;
	}
}