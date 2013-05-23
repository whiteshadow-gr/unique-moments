package gr.um.contacts;

import gr.um.entities.Contact;
import java.util.ArrayList;

public class ImportantContactsFinder 
{
	public ImportantContactsFinder()
	{
		
	}
	
	
	public ArrayList<Contact> findContacts(ArrayList<Contact> contactsDB, ArrayList<String> namesRSS)
	{
		ArrayList<Contact> names = new ArrayList<Contact>();
		
		if(namesRSS.size() == 0 || contactsDB.size() == 0)
		{
			return names;
		}
		
		for(int i = 0; i < namesRSS.size(); i++)
		{
			for(int j = 0; j<contactsDB.size(); j++)
			{
				if(compareNames(namesRSS.get(i), contactsDB.get(j).getName()))
				{
					names.add(contactsDB.get(j));
				}
			}
		}
		
		return names;
	}
	
	public boolean compareNames(String nameRSS, String nameDB)
	{
		if(nameRSS.trim().equals(nameDB.trim()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
