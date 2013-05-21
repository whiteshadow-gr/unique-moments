package gr.um.uniquemoments;

import java.util.ArrayList;

import gr.um.database.ControllerContactsDB;
import gr.um.email.ActivityEmail;
import gr.um.entities.Contact;
import gr.um.sms.ActivitySMS;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityContacts extends Activity implements OnLongClickListener 
{	
	
	private EditText editTextSearchName = null;
	public ListView listview;
	public ArrayAdapter <String> adapter;
	
	
	//-------------------------------------------------------------------------------------------------------------------------------------//
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//Intent intent = getIntent();
		
		setContentView(R.layout.activity_contacts);
		listview = (ListView)findViewById(R.id.listViewContacts); 
		adapter = new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1, 0);
		listview.setAdapter(adapter);
		ControllerContactsDB db = new ControllerContactsDB (this);
		
		ArrayList <Contact> contactsDB = new ArrayList <Contact>();
		contactsDB=db.getContacts();
		

		if(contactsDB.size() != 0)
		{
			
			for(int i = 0; i < contactsDB.size(); i++)
			{
				adapter.add(contactsDB.get(i).getName());
			}
		}
		
		registerForContextMenu(listview);
		editTextSearchName = (EditText) findViewById(R.id.editTextSearchName);
		editTextSearchName.addTextChangedListener(filterTextWatcher);
		
	}
	

	@Override
	protected void onDestroy() 
	{
	    super.onDestroy();
	    editTextSearchName.removeTextChangedListener(filterTextWatcher);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_contacts, menu);
		return true;
	}
	
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) 
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		
		Menu mMenu = menu;
		mMenu.add(Menu.NONE, 0, Menu.NONE, "Contact Profile");
		mMenu.add(Menu.NONE, 1, Menu.NONE, "Edit Contact");
		mMenu.add(Menu.NONE, 2, Menu.NONE, "Delete Contact");
		mMenu.add(Menu.NONE, 3, Menu.NONE, "Create New Contact");
		mMenu.add(Menu.NONE, 4, Menu.NONE, "Send SMS");
		mMenu.add(Menu.NONE, 5, Menu.NONE, "Send E-mail");
	}
	
	
	@Override
	public boolean onContextItemSelected(MenuItem item) 
	{		
		switch (item.getItemId()) 
		{
			case 0:
				Toast.makeText(getApplicationContext(), "Contacts Profile", Toast.LENGTH_SHORT).show();
				break;
			case 1:
				Toast.makeText(getApplicationContext(), "Edit Contact", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(getApplicationContext(), "Delete Contact", Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(getApplicationContext(), "Create New Contact", Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Intent intentSMS = new Intent(this, ActivitySMS.class);
				startActivity(intentSMS);
				break;
			case 5:
				Intent intentEmail = new Intent(this, ActivityEmail.class);
				startActivity(intentEmail);
				break;
		}
		return super.onContextItemSelected(item);
	}
	

	public void clear(View view)
		{
			EditText myEditText = (EditText)findViewById(R.id.editTextSearchName);
			myEditText.setText("");	
		}
	
	
	@Override
	public boolean onLongClick(View v) 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	private TextWatcher filterTextWatcher = new TextWatcher() 
	{

		public void afterTextChanged(Editable s) 
	    {
	    	
	    }

	    public void beforeTextChanged(CharSequence s, int start, int count, int after) 
	    {
	    	
	    }

	    public void onTextChanged(CharSequence s, int start, int before, int count) 
	    {
	        adapter.getFilter().filter(s);
	    }

	};
	
	
}
