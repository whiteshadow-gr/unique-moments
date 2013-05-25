package com.example.uniquemoments;

import android.R.bool;

import com.example.uniquemoments.R.string;

//needs to import Contact Class file

interface I_Database
{
	public string[] getContactList(); 					//This method returns
															//the contacts from the 
															//database into a table of strings

	public Contact fetchAContact(string name);  			//Returns an object of the "contact" 
															//class from the database
												
	public bool CreateContact(Contact myContact);			//Adds a new contact to the database
	
	public bool DeleteContact(string name, string surname); //Deletes a contact from the database
	
	public bool EditContact(Contact myContact);				//Changes specific attributes of a
															//contact in the database
}