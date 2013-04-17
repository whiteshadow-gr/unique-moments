package gr.um.eortologio;

import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import gr.um.entities.RSSItem;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class EortologioEventReader 
{

	private String urlToRssFeed;
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	
	/*
	 * This function sets the RSS URL for the object of this class
	 */
	public EortologioEventReader(String urlToRssFeed)
	{
		this.urlToRssFeed = urlToRssFeed;
	}
	
	/*
	 * This function returns an ArrayList containing all the names of the Eortologio RSS Feed 
	 */
	public ArrayList<String> getNames()
	{
		ArrayList<RSSItem> namesRSS = new ArrayList<RSSItem>();
		namesRSS = this.retrieveRSSFeed(namesRSS);
        namesRSS.get(0).generateArrayListNames();
        ArrayList<String> names = new ArrayList<String>();
        String [] namesArray = namesRSS.get(0).getNames();
        
        for (int i = 0; i < namesArray.length; i++)
        {
        	names.add(namesArray[i]);
        	//names.add(list.get(i).getNames().toString());
        }
        
        return names;
	}
	
	/*
	 * This function connects to the RSS Feed and fetches the names of the current Name Day
	 */
	public ArrayList<RSSItem> retrieveRSSFeed(ArrayList<RSSItem> list)
	 {
	     	//sunartisi i opoia ulopoiei tin sundesi sto rssfeed.
	     try
	     {
	        URL url = new URL(this.urlToRssFeed);
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser parser = factory.newSAXParser();
	        XMLReader xmlreader = parser.getXMLReader();
	        RSSParser theRssHandler = new RSSParser(list);
	
	        xmlreader.setContentHandler(theRssHandler);
	
	        InputSource is = new InputSource(url.openStream());
	
	        xmlreader.parse(is);
	        
	     }
	     catch (Exception e)
	     {
	         e.printStackTrace();
	     }
	     
	     return list;
	     // RSSItem data = list.get(0);
	     //return(data.title);
	 }

}
