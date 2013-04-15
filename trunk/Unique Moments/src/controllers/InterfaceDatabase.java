package controllers;

import java.util.ArrayList;

import entities.Contact;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public interface InterfaceDatabase 
{	
	public boolean addContact(Contact myContact);
	public boolean deleteContact(Contact myContact);
	public boolean editContact(Contact myContact);
	public ArrayList<Contact> searchContact(String myName);
}
