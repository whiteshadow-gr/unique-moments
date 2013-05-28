package gr.um.eortologio;

import gr.um.entities.RSSItem;
import gr.um.interfaces.ICelebrationEventReader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class MockEventReader implements ICelebrationEventReader
{
        Context context= null;
       
        public MockEventReader(Context context)
        {
                this.context=context;
               
        }
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

        @Override
        public ArrayList<RSSItem> retrieveRSSFeed(ArrayList<RSSItem> list) {
                String xml = null;
                 try{
                 xml=getXML(context.getAssets().open("MockRssFeed.xml"));
                 }catch(Exception e){
                     Log.d("Error",e.toString());
                  }
                 
                 RSSItem item = new RSSItem();
                 item.setTitle(xml);
                 
                 list.add(item);
                 
                 return list;
        }
       
        //getXML   method
         public static String getXML(InputStream is)throws IOException {

            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result = bis.read();
            while(result != -1) {
              byte b = (byte)result;
              buf.write(b);
              result = bis.read();
            }        
            return buf.toString();
        }
}
