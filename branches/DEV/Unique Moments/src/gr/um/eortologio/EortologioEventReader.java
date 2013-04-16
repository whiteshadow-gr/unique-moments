package gr.um.eortologio;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import controllers.RSSParser;
import entities.RSSItem;

public class EortologioEventReader {

	private String urlToRssFeed;
	public EortologioEventReader(String urlToRssFeed)
	{
		this.urlToRssFeed = urlToRssFeed;
	}
	public ArrayList<String> getNames()
	{
		ArrayList<RSSItem> list = new ArrayList<RSSItem>();
		this.retrieveRSSFeed(list);
        list.get(0).generateArrayListNames();
        ArrayList<String> names = new ArrayList<String>();
        String [] namesArray = list.get(0).title.split("\\(");
        for (int i = 0; i < namesArray.length; i++) {
         names.add(namesArray[i]);
        }
        return names;
	}
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
