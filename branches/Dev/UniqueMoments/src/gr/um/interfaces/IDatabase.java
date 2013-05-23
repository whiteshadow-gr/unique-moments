package gr.um.interfaces;

import gr.um.entities.Contact;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public interface IDatabase 
{	
	public boolean addContact(Contact myContact);
	public boolean deleteContact(Contact myContact);
	public boolean editContact(Contact myContact);
}
