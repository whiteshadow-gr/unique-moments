package gr.um.eortologio;

import java.util.ArrayList;
import android.content.Context;
import gr.um.database.ControllerContactsDb;
import gr.um.entities.Contact;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class FindEventsController 
{

	/*
	 * This function compares the names of the Eortologio RSS to the names of the user's Contacts
	 * and returns an ArrayList containing all the Contacts that have their name day today	
	 */
	public static ArrayList<String> getImportantNames(Context context)
	{
		ArrayList<String> namesRSS = new ArrayList<String>();
		ArrayList<Contact> temp = new ArrayList<Contact>();
		ArrayList<Contact> importantContacts = new ArrayList<Contact>();
		EortologioEventReader reader = new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
        
		namesRSS = reader.getNames();	
        
        if (namesRSS.isEmpty()) 
        {
        	return null;
        }
        else
        {
        	ControllerContactsDb db = new ControllerContactsDb(context);
        	for(int i=0; i < namesRSS.size(); i++)
        	{
        		temp = db.searchContacts(namesRSS.get(i));
        		
        		for(int j=0; j<temp.size(); j++)
        		{
        			importantContacts.add(temp.get(j));
        		}
        	}
        	
        	return null;
        }
        
        /*
        for(int i=0; i<names.size(); i++){
        	if(i==names.size()-1)
        	{
        			allnames+=names.get(i);
        	}
        	else
        	{
        		allnames+=names.get(i)+",";
        	}
        	
        }
       return allnames;
       */
        
	}
}
