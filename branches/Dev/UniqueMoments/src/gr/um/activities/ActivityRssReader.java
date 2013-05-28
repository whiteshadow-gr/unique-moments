package gr.um.activities;
 
import gr.um.entities.RSSItem;
import gr.um.eortologio.RSSParser;
import gr.um.eortologio.RetrieveRSSFeeds;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.os.Bundle;

//-----------------------------------------------------------------------------------------------------------------------------------------//
 
public class ActivityRssReader extends ListActivity 
{
    @SuppressWarnings("unused")
    
	private ArrayList<RSSItem> itemlist = null;    
  //---------------------------------------------------------------------------------------------------------------------------------------//
    
    /**
     * ActivityRssReader() Constructor with no parameters
     */
    public ActivityRssReader() 
    {
		super();
		// TODO Auto-generated constructor stub
	}
    
    //-------------------------------------------------------------------------------------------------------------------------------------//
     
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState); 
	    itemlist = new ArrayList<RSSItem>();   
	    new RetrieveRSSFeeds().execute();  
	}
  
    /**
     * retrieveRSSFeed retrieveRSSFeed is called at the begining of the app start up
     * in order to retrieve the rss.
     * @param urlToRssFeed urlToRssFeed is the URL of the site we want to connect and read the rss
     * @param list is the list of names
     * @return String returns the string of rss feed
     */
	public static String retrieveRSSFeed(String urlToRssFeed,ArrayList<RSSItem> list)
    {
	    try
	    {
	       URL url = new URL(urlToRssFeed);
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
	    RSSItem data = list.get(0);
	    return(data.title);
    }
}