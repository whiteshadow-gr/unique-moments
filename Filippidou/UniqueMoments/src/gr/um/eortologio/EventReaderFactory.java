package gr.um.eortologio;

import android.content.Context;
import gr.um.interfaces.ICelebrationEventReader;

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
		default:
			return new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
		}
	}
}
