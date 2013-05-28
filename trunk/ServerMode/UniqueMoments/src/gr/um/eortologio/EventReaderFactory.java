package gr.um.eortologio;

import gr.um.interfaces.ICelebrationEventReader;
import android.content.Context;

/**
 * EventReaderFactory A factory class constructing the different types of rss feeds
 */
public class EventReaderFactory 
{	
	  private static Context context = null;
      
      @SuppressWarnings("static-access")
      public EventReaderFactory(Context context)
      {
              this.context = context;
      }
	
	public static ICelebrationEventReader getInstance(EventReaderTypes type) 
	{
		switch (type) 
		{
		case EORTOLOGIO_EVENT_READER_EN:
			return new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
		case EORTOLOGIO_EVENT_READER_GR:
			return new EortologioEventReader("http://www.eortologio.gr/rss/si_el.xml");
		case TEST_EVENT_READER:
			return new MockEventReader(context);
		case TEST_MODE:
			return new EortologioEventReader("http://192.168.1.117:8000/rss/si_en.xml");
		default:
			return new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
		}
	}
}