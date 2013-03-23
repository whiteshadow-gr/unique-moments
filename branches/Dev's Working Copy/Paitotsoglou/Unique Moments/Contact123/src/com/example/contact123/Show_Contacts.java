package com.example.contact123;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Show_Contacts extends Activity implements OnLongClickListener{
	
	ListView listview;
	ArrayAdapter <String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		setContentView(R.layout.show_contacts_layout);
		listview = (ListView)findViewById(R.id.listView); 
		adapter = new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1, 0);
		MyContactsViewer cv = new MyContactsViewer(this);
		ContentResolver cr = getContentResolver();
		
		cv.ShowContacts(listview, adapter, cr);
		registerForContextMenu(listview);
				
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		
		Menu mMenu = menu;
		mMenu.add(Menu.NONE, 0, Menu.NONE, "Call Contact");
		mMenu.add(Menu.NONE, 1, Menu.NONE, "Send SMS");
		mMenu.add(Menu.NONE, 2, Menu.NONE, "Send E-mail");
		mMenu.add(Menu.NONE, 3, Menu.NONE, "Delete Contact");
		mMenu.add(Menu.NONE, 4, Menu.NONE, "Edit Contact");
		
	}
	
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch (item.getItemId()) {
		case 0:
			Toast.makeText(getApplicationContext(), "Call", Toast.LENGTH_SHORT).show();
			break;
		case 1:
			Toast.makeText(getApplicationContext(), "SMS", Toast.LENGTH_SHORT).show();
			break;
		case 2:
			Toast.makeText(getApplicationContext(), "E-mail", Toast.LENGTH_SHORT).show();
			
			break;
		case 3:
			Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
			break;
		case 4:
			Toast.makeText(getApplicationContext(), "Edit", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onContextItemSelected(item);
	}
	
	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
