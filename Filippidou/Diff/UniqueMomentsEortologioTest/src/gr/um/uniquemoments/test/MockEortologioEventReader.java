package gr.um.uniquemoments.test;

import gr.um.entities.RSSItem;
import gr.um.eortologio.RSSParser;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class MockEortologioEventReader 
{

	private String urlToRssFeed;
	
	public MockEortologioEventReader(String urlToRssFeed)
	{
		this.urlToRssFeed = urlToRssFeed;
	}
	
	public ArrayList<String> getNames()
	{
		
		ArrayList <RSSItem> namesRSS = new ArrayList <RSSItem>();
		ArrayList <String> names = new ArrayList <String>();
		
		namesRSS = retrieveRSSFeed(namesRSS);
        namesRSS.get(0).generateArrayListNames();
        
        String [] namesArray = namesRSS.get(0).names; 
        for (int i = 0; i < namesArray.length; i++)
        {
        	names.add(namesArray[i]);
        	//names.add(list.get(i).getNames().toString());
        }
        

        return names;
		
		
		
		/*
		ArrayList<String> names = new ArrayList<String>();
		names.add("TestName1");
		names.add("TestName2");
		names.add("TestName3");
		names.add("TestName4");
		names.add("TestName5");
		return names;
		*/
		
		
	}
	
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
	
	        InputSource is = new InputSource(url.openStream());
	
	        xmlreader.parse(is);
	        
	     }
	     catch (Exception e)
	     {
	         e.printStackTrace();
	     }
	     
	     return list;
	}
	
}
