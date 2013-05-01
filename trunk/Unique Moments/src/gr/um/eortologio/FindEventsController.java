package gr.um.eortologio;

import java.util.ArrayList;

import android.content.Context;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class FindEventsController 
{
	public static ArrayList<String> importantNames = new ArrayList<String>();
	

	/*
	 * This function compares the names of the Eortologio RSS to the names of the user's Contacts
	 * and returns an ArrayList containing all the Contacts that have their name day today	
	 */
	public FindEventsController()
	{
		
	}
	
	public static String getImportantNames(Context context)
	{
		 
		 int importantContacts = 0;
		 EortologioEventReader reader = new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
        
		 importantNames = reader.getNames();
        
        if (importantNames.isEmpty()) 
        {
        	return "error";    
        }
       // else if (importantNames.get(0).trim().equals("no widely known nameday"))
       // {
      //  	return Integer.toString(importantContacts); 
     //   }
        else
        {
        	importantContacts=importantNames.size();
        	return Integer.toString(importantContacts);    
             
        }       
	}
	
}
