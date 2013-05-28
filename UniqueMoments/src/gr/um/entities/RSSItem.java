package gr.um.entities;

import java.util.ArrayList;


//-----------------------------------------------------------------------------------------------------------------------------------------//
 
public class RSSItem 
{
    public String title;
    public String link;
    public String[] names;
	
    //-------------------------------------------------------------------------------------------------------------------------------------//
   
    /**
     * RSSItem() constructor without parameters
     */
    public RSSItem()
    {
    	title = "";
    	link = "";
    	names = null;
    }
    
    /**
     * RSSItem(String myTitle, String myLink) constructor with two parameters
     * @param myTitle String Containing the title of the RSSItem
     * @param myLink String Containing the link of the RSSItem
     */
    public RSSItem(String myTitle, String myLink)
    {
    	title = myTitle;
    	link = myLink;
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------// 
    
    /**
     * getTitle() returns the title of the RSSItem
     * @return title String containing the title of the RSSItem
     */
    public String getTitle() 
    {
		return title;
	}

    /**
     * getLink() returns the link of the RSSItem
     * @return link String containing the link of the RSSItem
     */
	public String getLink() 
	{
		return link;
	}

	/**
     * getNames() returns the names of the RSSItem
     * @return title String containing the names of the RSSItem
     */
	public String[] getNames()
	{
		return names;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------//	
  
	/**
     * setTitle() adds the title of the RSSItem
     */
	public void setTitle(String title) 
	{
		this.title = title;
	}

	/**
     * setLink() adds the link of the RSSItem
     */
	public void setLink(String link)
	{
		this.link = link;
	}

	/**
     * setNames() adds the names of the RSSItem
     */
	public void setNames(ArrayList<String> nameList)
	{
		if(nameList.isEmpty())
		{
			for(int i=0; i<nameList.size(); i++)
			{
				names[i] = nameList.get(i);
			}
		}
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------//

	/**
	 * generateArrayListNames() this function generates the names from the RSS by splitting them in the right places
	 */
	public void generateArrayListNames()
	{
		names = title.split("\\(");
		names = names[0].split(":");
		names = names[1].split(",");
		
		for(int i = 0; i<names.length; i++)
        {
                names[i] = names[i].trim();
        }

	}
}