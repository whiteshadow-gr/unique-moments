package gr.um.activities;

import gr.um.contacts.ImportantContactsFinder;
import gr.um.database.ContactDBTypes;
import gr.um.database.ContactsDBFactory;
import gr.um.database.ControllerContactsDB;
import gr.um.database.ControllerEventReader;
import gr.um.entities.Contact;
import gr.um.interfaces.IDatabase;
import gr.um.uniquemoments.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class ActivityDailyEvents extends Activity implements OnLongClickListener
{
	public ListView listview;
	public ArrayAdapter <String> adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_daily_events);
	    
	    ArrayList <String> newNamesRSS = new ArrayList <String>();
		
	    ControllerEventReader fec = new ControllerEventReader();
	    newNamesRSS = fec.getimportantNames();
	    
	    listview = (ListView)findViewById(R.id.listViewImportantContacts); 
		adapter = new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1, 0);
		listview.setAdapter(adapter);
		
		ArrayList <Contact> contactsDB = new ArrayList <Contact>();
		ArrayList <Contact> contactsToShow = new ArrayList <Contact>();
		
		//ControllerContactsDB db = new ControllerContactsDB(this);
		
		 IDatabase data =new ContactsDBFactory(getApplicationContext()).getInstance(ContactDBTypes.CONTACTS_SQLITE_DATABASE);
		 
		contactsDB=data.getContacts();
		
		ImportantContactsFinder finder = new ImportantContactsFinder();
		contactsToShow = finder.findContacts(contactsDB, newNamesRSS);
		
		if(contactsToShow.size() != 0)
		{
			
			for(int i = 0; i < contactsToShow.size(); i++)
			{
				adapter.add(contactsToShow.get(i).getName());
			}
		}
		registerForContextMenu(listview);
		
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
		mMenu.add(Menu.NONE, 1, Menu.NONE, "Send SMS");
		mMenu.add(Menu.NONE, 2, Menu.NONE, "Send E-mail");
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
				Intent intentSMS = new Intent(this, ActivitySMS.class);
				startActivity(intentSMS);
				break;
			case 2:
				Intent intentEmail = new Intent(this, ActivityEmail.class);
				startActivity(intentEmail);
				break;
		}
		return super.onContextItemSelected(item);
	}

	//Not Used!!
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
}
