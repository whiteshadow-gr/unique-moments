package gr.um.entities;

import java.util.ArrayList;


//-----------------------------------------------------------------------------------------------------------------------------------------//
 
public class RSSItem 
{
	
    public String title;
    public String link;
    public String[] names;
	
    //-------------------------------------------------------------------------------------------------------------------------------------//
   
    /*
     * constructor
     */
    public RSSItem()
    {
    	title = "";
    	link = "";
    	names = null;
    }
    
    
    /*
     * Constructor
     */

    public RSSItem(String myTitle, String myLink)
    {
    	title = myTitle;
    	link = myLink;
    }
    
    public RSSItem( String myLink)
    {
    	link = myLink;
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------// 
    
    /*
     * get functions 
     */
 
    public String getTitle() 
    {
		return title;
	}

	public String getLink() 
	{
		return link;
	}

	public String[] getNames()
	{
		return names;
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------//	
  
	/*
	 * set functions
	 */

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

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

	public void generateArrayListNames()
	{
		names = title.split("\\(");
		names = names[0].split(":");
		names = names[1].split(",");
	}
	
}