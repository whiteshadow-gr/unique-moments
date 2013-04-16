package gr.um.eortologio;

import junit.framework.TestCase;

public class EortologioEventReaderTest extends TestCase {
	private EortologioEventReader eortologio;
	protected void setUp() throws Exception {
		super.setUp();
		eortologio = new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
	}

	public void testGetNames() {
		String expected = "������ ��� 16 ��� 13 : ������, �������, ����, ������, ��������, ��������, �������, ������, �������, ������, �����, �����, ������, �����, ���� (";
		String actual = eortologio.getNames().get(0);
		assertEquals(expected,actual);
	}

}
