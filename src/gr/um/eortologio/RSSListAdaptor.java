package gr.um.eortologio;

import gr.um.entities.RSSItem;
import gr.um.uniquemoments.ActivityRssReader;
import gr.um.uniquemoments.R;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RSSListAdaptor extends ArrayAdapter<RSSItem>
{
	//emfanisei twn apoelesmatwn me tin voitheia tou adapter
	
    public List<RSSItem> objects = null;
    public ActivityRssReader rssActivity = new ActivityRssReader();
    
    
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
            //LayoutInflater vi = (LayoutInflater)ActivityRssReader.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        	LayoutInflater vi = (LayoutInflater)rssActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
