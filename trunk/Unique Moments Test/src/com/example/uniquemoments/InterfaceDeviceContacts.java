package com.example.uniquemoments;

import android.R.bool;

import com.example.uniquemoments.R.string;

//needs to import Contact Class file

interface I_DeviceContacts
{
	public Contact[] getDeviceContacts();					//Returns the contacts of the user's
																//device (mobile phone) into an array
																//of objects of the "contact" class
														
	public bool createContactToDevice(Contact myContact);		//Adds a new contact to the user's
																//device (phone) phonebook
																
	public bool deleteContactFromDevice(string name, string surname);  //Deletes a contact from the
																	   //user's device phonebook
																	   
	public bool editContactToDevice(Contact myContact);			//Changes specific attributes of a
																//contact in the user's device
																//phonebook
}