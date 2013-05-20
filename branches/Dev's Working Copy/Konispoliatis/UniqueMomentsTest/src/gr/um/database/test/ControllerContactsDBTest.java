package gr.um.database.test;

import gr.um.database.ControllerContactsDB;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.InstrumentationTestCase;

public class ControllerContactsDBTest extends InstrumentationTestCase {
	
	private ControllerContactsDB contr;
    private Context basecontext;

	
	/*public ControllerContactsDBTest(String name) {
		super();
	}*/

	protected void setUp() throws Exception {
		super.setUp();
		
		basecontext=getInstrumentation().getContext();
		contr=new ControllerContactsDB(basecontext,"TestDBName");
		
		contr.initializeDatabase(contr.getWritableDatabase());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}


	public void testAddContact() {
		fail("Not yet implemented");
	}

	public void testImportPhonebookData() {
		fail("Not yet implemented");
	}

}
