package com.example.uniquemoments;

class Contact
{
	private String Contact_id;
	private String Contact_name1;
	private String Contact_name2;
	private String Contact_surname1;
	private	String Contact_surname2;
	private String Contact_phone1;
	private String Contact_phone2;
	private String Contact_phone3;
	private String Contact_email;
	private String Contact_nickname;
	private String Contact_relationship;
	private String Contact_birthday;
	private String Contact_nameday;
	
	
	//constructor
	public Contact()
	{
		Contact_id="";
		Contact_name1 = "";
		Contact_name2 = "";
		Contact_surname1 = "";
		Contact_surname2 = "";
		Contact_phone1 = "";
		Contact_phone2 = "";
		Contact_phone3 = "";
		Contact_email = "";
		Contact_nickname = "";
		Contact_relationship = "";
		Contact_birthday = "";
		Contact_nameday = "";
	}
	
	//constructor
	public Contact(String myName, String mySurname, String myPhone)
	{
		Contact_id=myName;
		Contact_name1 = myName;
		Contact_name2 = "";
		Contact_surname1 = mySurname;
		Contact_surname2 = "";
		Contact_phone1 = myPhone;
		Contact_phone2 = "";
		Contact_phone3 = "";
		Contact_email = "";
		Contact_nickname = "";
		Contact_relationship = "";
		Contact_birthday = "";
		Contact_nameday = "";
	}
	
	
	//get functions
	
	public String Contact_getid()
	{
		return Contact_id;
	}
	
	public String Contact_getName1()
	{
		return Contact_name1;
	}
	
	public String Contact_getName2()
	{
		return Contact_name2;
	}
	
	public String Contact_getSurname1()
	{
		return Contact_surname1;
	}
	
	public String Contact_getSurname2()
	{
		return Contact_surname2;
	}
	
	public String Contact_getPhone1()
	{
		return Contact_phone1;
	}
	
	public String Contact_getPhone2()
	{
		return Contact_phone2;
	}
	
	public String Contact_getPhone3()
	{
		return Contact_phone3;
	}
	
	public String Contact_getEmail()
	{
		return Contact_email;
	}
	
	public String Contact_getNickname()
	{
		return Contact_nickname;
	}
	
	public String Contact_getRelationship()
	{
		return Contact_relationship;
	}
	
	public String Contact_getBirthday()
	{
		return Contact_birthday;
	}
	
	public String Contact_getNameday()
	{
		return Contact_nameday;
	}
	
	
	//set functions
	
	public void Contact_setid(String myid)
	{
		Contact_id = myid;
	}
	
	public void Contact_setName1 (String myName)
	{
		Contact_name1 = myName;
	}
	
	public void Contact_setName2 (String myName)
	{
		Contact_name2 = myName;
	}
	
	public void Contact_setSurname1 (String mySurname)
	{
		Contact_surname1 = mySurname;
	}
	
	public void Contact_setSurname2 (String mySurname)
	{
		Contact_surname2 = mySurname;
	}
	
	public void Contact_setPhone1 (String myPhone)
	{
		Contact_phone1 = myPhone;
	}
	
	public void Contact_setPhone2 (String myPhone)
	{
		Contact_phone2 = myPhone;
	}
	
	public void Contact_setPhone3 (String myPhone)
	{
		Contact_phone3 = myPhone;
	}
	
	public void Contact_setEmail (String myEmail)
	{
		Contact_email = myEmail;
	}
	
	public void Contact_setNickname (String myNickname)
	{
		Contact_nickname = myNickname;
	}
	
	public void Contact_setRelationship (String myRelationship)
	{
		Contact_relationship = myRelationship;
	}
	
	public void Contact_setBirthday (String myBirthday)
	{
		Contact_birthday = myBirthday;
	}
	
	public void Contact_setNameday (String myNameday)
	{
		Contact_nameday = myNameday;
	}
}