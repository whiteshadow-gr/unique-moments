package gr.um.database;

import java.util.ArrayList;
import gr.um.entities.Contact;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public interface InterfaceDatabase 
{	
	public boolean addContact(Contact myContact);
	public boolean deleteContact(Contact myContact);
	public boolean editContact(Contact myContact);
	public ArrayList<Contact> searchContacts(String myName);
}
