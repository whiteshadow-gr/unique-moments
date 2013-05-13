package gr.um.uniquemoments.test;

import gr.um.uniquemoments.ActivityContacts;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ContactsTest extends ActivityInstrumentationTestCase2<ActivityContacts> 
{

	private Activity myActivity;
	private EditText editSearchName;
	private Button buttonClear;
	private ListView listView;
	private ArrayAdapter<String> listViewAdapter;
	
	public static final int ADAPTER_COUNT = 4;
	
	public ContactsTest() 
	{
		super("gr.um.uniquemoments", ActivityContacts.class);
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		myActivity = getActivity();
		
		setActivityInitialTouchMode(false);
		
		editSearchName = (EditText) myActivity.findViewById(gr.um.uniquemoments.R.id.editTextSearchName);
		buttonClear = (Button) myActivity.findViewById(gr.um.uniquemoments.R.id.buttonSearch);
		listView = (ListView) myActivity.findViewById(gr.um.uniquemoments.R.id.listViewContacts);
		listViewAdapter = (ArrayAdapter<String>) listView.getAdapter();
	}
	
	public void testPreConditionsContacts()
	{
		assertTrue(editSearchName.isClickable());
		assertTrue(buttonClear.hasOnClickListeners());
		assertTrue(listViewAdapter != null);
		assertTrue(!listViewAdapter.isEmpty());
		assertTrue(listViewAdapter.getCount()==ADAPTER_COUNT);
	}

}
