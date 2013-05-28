package gr.um.contacts;

import gr.um.entities.Contact;
import java.util.ArrayList;

public class ImportantContactsFinder 
{
	/**
	 * ImportantContactsFinder constructor without parameters.
	 */
	public ImportantContactsFinder()
	{
		
	}
	
	/**
	 * findContacts this method finds the contacts that celebrate today via a comparison of the rss names and the names in DB.
	 * @param contactsDB the contacts that are stored in the DB
	 * @param namesRSS the names of the rss that celebrate today
	 * @return ArrayList<Contact> returns an arraylist of contacts that are celebrate today
	 */
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
	
	/**
	 * compareNames this method compares two trimmed strings if they are equals.
	 * @param nameRSS the names from the RSS
	 * @param nameDB the names from the DB
	 * @return returns a boolean value(true of false)
	 */
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