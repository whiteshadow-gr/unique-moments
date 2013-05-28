package gr.um.eortologio;

import gr.um.interfaces.ICelebrationEventReader;

public class EventReaderFactory 
{
	public static ICelebrationEventReader getInstance(EventReaderTypes type) 
	{
		switch (type) 
		{
		case EORTOLOGIO_EVENT_READER_EN:
			return new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
		case EORTOLOGIO_EVENT_READER_GR:
			return new EortologioEventReader("http://www.eortologio.gr/rss/si_el.xml");
		case TEST_EVENT_READER:
			return new TestEventReader();
		case TEST_MODE:
			return new EortologioEventReader("http://192.168.1.2:8000/si_en.xml");//http://127.0.0.1:8000/rss/si_en.xml");
		default:
			return new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
		}
	}
}
