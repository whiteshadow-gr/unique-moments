package gr.um.eortologio;

import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import gr.um.entities.RSSItem;
import gr.um.interfaces.ICelebrationEventReader;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class EortologioEventReader implements ICelebrationEventReader 
{

	private String urlToRssFeed;
		
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	/**
	 * EortologioEventReader constructor with 1 parameter
	 * @param urlToRssFeed String it is the URL of the RSS feed
	 */
	public EortologioEventReader(String urlToRssFeed)
	{
		this.urlToRssFeed = urlToRssFeed;
	}
	
	/**
	 * getRSSNames() This function returns an ArrayList containing all the names of the Eortologio RSS Feed
	 * @return ArrayList<String> names containing all the names of the Eortologio RSS Feed
	 */
	@Override
	public ArrayList<String> getRSSNames()
	{
		ArrayList <RSSItem> namesRSS = new ArrayList <RSSItem>();
		ArrayList <String> names = new ArrayList <String>();
		
		namesRSS = retrieveRSSFeed(namesRSS);
        namesRSS.get(0).generateArrayListNames();
        
        String [] namesArrayRSS = namesRSS.get(0).names; 
        for (int i = 0; i < namesArrayRSS.length; i++)
        {
        	names.add(namesArrayRSS[i]);
        }
        return names;
	}
	
	/**
	 * retrieveRSSFeed(ArrayList<RSSItem> list) This function connects to the RSS Feed and fetches the names of the current Name Day
	 * @return ArrayList <RSSItem> list containing tha names that celebrate today
	 */
	public ArrayList <RSSItem> retrieveRSSFeed(ArrayList <RSSItem> list)
	 {
	     try
	     {
	        URL url = new URL(this.urlToRssFeed);
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser parser = factory.newSAXParser();
	        XMLReader xmlreader = parser.getXMLReader();
	        RSSParser theRssHandler = new RSSParser(list);
	
	        xmlreader.setContentHandler(theRssHandler);
	
	        InputSource inputSource = new InputSource(url.openStream());
	
	        xmlreader.parse(inputSource);  
	     }
	     catch (Exception e)
	     {
	         e.printStackTrace();
	     }
	     return list;
	 }
}