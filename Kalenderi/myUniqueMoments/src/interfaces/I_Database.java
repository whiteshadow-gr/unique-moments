package interfaces;

import entities.Contact;

public interface I_Database 
{	
	public abstract boolean addContact(Contact myContact);
	public abstract boolean deleteContact(Contact myContact);
	public abstract boolean editContact(Contact myContact);
	public abstract Contact[] searchContact(String myName);
}
