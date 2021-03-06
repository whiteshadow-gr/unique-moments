package gr.um.eortologio;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import gr.um.entities.RSSItem;

//-----------------------------------------------------------------------------------------------------------------------------------------//
 
public class RSSParser extends DefaultHandler 
{
	private final static String TAG_ITEM = "item";
	private final static String[] xmltags = { "title", "link" }; 
	private RSSItem currentitem = null;
	private ArrayList<RSSItem> itemarray = null;
	private int currentindex = -1;
	private boolean isParsing = false;
	private StringBuilder builder = new StringBuilder();
    
	//-------------------------------------------------------------------------------------------------------------------------------------//
       
	/**
	 * RSSParser constructor with one paramater
	 * @param itemarray ArrayList<RSSItem> 
	 */
	public RSSParser(ArrayList<RSSItem> itemarray) 
	{
        super(); 
        this.itemarray = itemarray;
    }
 
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException 
	{
        super.characters(ch, start, length);
      
        if(isParsing && -1 != currentindex && null != builder)
        {
            builder.append(ch, start, length);
        }
	}
	 
	/**
	 * startElement(uri, localName, qName) this function opens each element that reads the xml file
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
	{
        super.startElement(uri, localName, qName, attributes);		
        
        if(localName.equalsIgnoreCase(TAG_ITEM))
        {
            currentitem = new RSSItem();
            currentindex = -1;
            isParsing = true;    
            itemarray.add(currentitem);
        }
        else
        {
            currentindex = itemIndexFromString(localName);
            builder = null;
            if(-1 != currentindex)
            {
            	builder = new StringBuilder();
            }
        }
	}
	
	/**
	 * endElement(uri, localName, qName) this function gets the data from each element
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException 
	{
		
		super.endElement(uri, localName, qName);      
        if(localName.equalsIgnoreCase(TAG_ITEM))
        {
            isParsing = false;
        }
        else if(currentindex != -1)
        {
            if(isParsing)
            {
                switch(currentindex)
                {
                    case 0: 
                    	currentitem.title = builder.toString();                 
                    	break;
                    case 1: 
                    	currentitem.link = builder.toString();                 
                    	break;
                }
            }
        }
    }
	 
	private int itemIndexFromString(String tagname)
    {
		int itemindex = -1;
 
        for(int index = 0; index<xmltags.length; ++index)
        {
        	if(tagname.equalsIgnoreCase(xmltags[index]))
        	{
        		itemindex = index;                         
        		break;
        	}
        }               
        return itemindex;
    }	
}