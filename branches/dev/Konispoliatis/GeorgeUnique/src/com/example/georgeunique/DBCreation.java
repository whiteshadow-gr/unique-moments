package com.example.georgeunique;

public class DBCreation
{
	public String Create_Groups="CREATE  TABLE IF NOT EXISTS Groups(_G_ID INT AUTO_INCREMENT , G_Name VARCHAR(15),PRIMARY KEY (_G_ID) );";
	public String Create_Dates="CREATE  TABLE IF NOT EXISTS Dates ( _D_ID INT AUTO_INCREMENT , D_Date DATE , Date_Types__DT_ID INT , PRIMARY KEY (_D_ID) , CONSTRAINT fk_Dates_Date_Types1 FOREIGN KEY (Date_Types__DT_ID ) REFERENCES Date_Types (_DT_ID ));";
    public String Create_Date_Types="CREATE  TABLE IF NOT EXISTS Date_Types (_DT_ID INT  AUTO_INCREMENT , DT_Type VARCHAR(15) NULL , DT_Fix_Date_Switch BINARY , PRIMARY KEY (_DT_ID) );";	
	public String Create_Messages="CREATE  TABLE IF NOT EXISTS Messages ( _M_ID INT AUTO_INCREMENT , M_Last_Recieved VARCHAR(255) , M_Last_Sent VARCHAR(255) , M_Date DATE , Message_Types__MT_ID INT , PRIMARY KEY (_M_ID) , CONSTRAINT fk_Messages_Message_Types1 FOREIGN KEY (Message_Types__MT_ID ) REFERENCES Message_Types (_MT_ID ));";
    public String Create_Message_Types="CREATE  TABLE IF NOT EXISTS Message_Types (_MT_ID INT   AUTO_INCREMENT , MT_Type VARCHAR(6)   , PRIMARY KEY (_MT_ID) );";
    public String Create_Events="CREATE  TABLE IF NOT EXISTS Events ( _E_ID INT AUTO_INCREMENT , E_Date DATETIME , E_Name VARCHAR(80) , E_Description VARCHAR(255) , E_Place VARCHAR(80) , PRIMARY KEY (_E_ID) );";
    public String Create_Number_Types="CREATE  TABLE IF NOT EXISTS Number_Types (_NT_type_ID INT   AUTO_INCREMENT , NT_Type VARCHAR(10)   , PRIMARY KEY (_NT_type_ID) );";
	public String Create_Numbers="CREATE  TABLE IF NOT EXISTS Numbers (_N_ID INT   AUTO_INCREMENT , N_Number VARCHAR(14)   , NT_Type INT   , PRIMARY KEY (_N_ID) , INDEX fk_Numbers_Number_Types1_idx (NT_Type ASC) , CONSTRAINT fk_Numbers_Number_Types1 FOREIGN KEY (NT_Type ) REFERENCES Number_Types (_NT_type_ID ) );";
    public String Create_Relationships="CREATE  TABLE IF NOT EXISTS Relationships (_R_ID INT   AUTO_INCREMENT , R_Name VARCHAR(25)   , R_Surname VARCHAR(25)   , R_Relathions VARCHAR(20)   , PRIMARY KEY (_R_ID) );";
	public String Create_Contacts="CREATE  TABLE IF NOT EXISTS Contacts ( _C_ID AUTO_INCREMENT ,  C_Name_1 VARCHAR(20) , C_Name_2 VARCHAR(20) , C_Surname_1 VARCHAR(25) , C_Surname_2 VARCHAR(255) , C_email VARCHAR(40) , C_Nickname VARCHAR(20) , Relationships__R_ID INT , Numbers__N_ID INT , Groups__G_ID INT , Events__E_ID INT , Messages__M_ID INT , Dates__D_ID INT , PRIMARY KEY (_C_ID) ,  CONSTRAINT fk_Contacts_Relationships1 FOREIGN KEY (Relationships__R_ID ) REFERENCES Relationships (_R_ID ) , CONSTRAINT fk_Contacts_Numbers1 FOREIGN KEY (Numbers__N_ID ) REFERENCES Numbers (_N_ID ) , CONSTRAINT fk_Contacts_Groups1 FOREIGN KEY (Groups__G_ID ) REFERENCES Groups (_G_ID ), CONSTRAINT fk_Contacts_Events1 FOREIGN KEY (Events__E_ID ) REFERENCES Events (_E_ID ), CONSTRAINT fk_Contacts_Messages1 FOREIGN KEY (Messages__M_ID ) REFERENCES Messages (_M_ID ), CONSTRAINT fk_Contacts_Dates1 FOREIGN KEY (Dates__D_ID ) REFERENCES Dates (_D_ID ));";
    
    public String getContacts()
	{
	    return this.Create_Contacts;
	}
    
    public String getRelationships()
	{
	    return this.Create_Relationships;
	}

    public String getNumbers()
	{
    	return this.Create_Numbers;
	}

	public String getNumber_Types()
	{
    	return this.Create_Number_Types;
	}

	public String getEvents()
	{
    	return this.Create_Events;
	}

	public String getMessage_Types()
	{
    	return this.Create_Message_Types;
	}
	
	public String getMessages()
	{
    	return this.Create_Messages;
	}
	
	public String getDate_Types()
	{
    	return this.Create_Date_Types;
	}
	
	public String getDates()
	{
    	return this.Create_Dates;
	}
	
	public String getGroups()
	{
		return this.Create_Groups;
	}
}