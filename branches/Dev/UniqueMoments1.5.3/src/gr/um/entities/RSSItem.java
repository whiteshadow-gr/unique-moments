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
    	
    	//this.names.add("");
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
		//this.names.clear();
		//this.names.addAll(nameList.toArray());
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------//

	public void generateArrayListNames()
	{
		names=title.split("\\(");
		names = names[0].split(":");
		names=names[1].split(",");
	}
	
}