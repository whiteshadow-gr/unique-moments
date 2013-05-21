package gr.um.uniquemoments;
 
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
    //private RSSListAdaptor rssadaptor = null;
    
  //---------------------------------------------------------------------------------------------------------------------------------------//
    
    /*
     * Constructor
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
 
 
    public static String retrieveRSSFeed(String urlToRssFeed,ArrayList<RSSItem> list)
    {
    	//sunartisi i opoia ulopoiei tin sundesi sto rssfeed.
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
    
	//-------------------------------------------------------------------------------------------------------------------------------------//
	    
	/*private class RetrieveRSSFeeds extends AsyncTask<Void, Void, Void>
	{
		
		//ektelesi tis sundesis sto rssfeed me tin voitheia tou AsyncTask i opoia ektelei tin diadikasia sto background
	    @Override
	    protected Void doInBackground(Void... params) 
	    {          
			retrieveRSSFeed("http://www.eortologio.gr/rss/si_en.xml",itemlist);
	       
	        rssadaptor = new RSSListAdaptor(ActivityRssReader.this, R.layout.activity_daily_events,itemlist);
	
	        return null;
	    }
	     
	    @Override
	    protected void onCancelled() 
	    {
	    	super.onCancelled();
	    }
	     
	    @Override
	    protected void onPreExecute() 
	    {      
	        super.onPreExecute();
	    }
	    @Override
	    protected void onPostExecute(Void result) 
	    {
	        setListAdapter(rssadaptor); 
	        super.onPostExecute(result);
	    }
	             
	    @Override
	    protected void onProgressUpdate(Void... values) 
	    {
	        super.onProgressUpdate(values);
	    }
	}*/
	 
	//-------------------------------------------------------------------------------------------------------------------------------------//
	/*
    
	public class RSSListAdaptor extends ArrayAdapter<RSSItem>
	{
		//emfanisei twn apoelesmatwn me tin voitheia tou adapter
		
	    public List<RSSItem> objects = null;
	     
	    public RSSListAdaptor(Context context, int textviewid, List<RSSItem> objects) 
	    {
	        super(context, textviewid, objects); 
	        this.objects = objects;
	    }
	     
	    @Override
	    public int getCount() 
	    {
	        return ((null != objects) ? objects.size() : 0);
	    }
	     
	    @Override
	    public long getItemId(int position) 
	    {
	        return position;
	    }
	             
	    @Override
	    public RSSItem getItem(int position) 
	    {
	        return ((null != objects) ? objects.get(position) : null);
	    }
	             
	    public View getView(int position, View convertView, ViewGroup parent) 
	    {
            View view = convertView;
             
            if(null == view)
            {
                LayoutInflater vi = (LayoutInflater)ActivityRssReader.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = vi.inflate(R.layout.activity_daily_events, null);
            }
             
          RSSItem data = objects.get(position);
           
            if(null != data)
            {
               TextView names = (TextView)view.findViewById(R.id.textViewDailyEvents);   
               names.setText(data.title);            
            }        
            
            return view;
	    }                  
	}
	*/
}