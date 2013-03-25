package com.example.uniquemoments;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MyContactsViewer {
	
	public MyContactsViewer(Show_Contacts sc)
	{
		
	}
	
	public void ShowContacts(ListView listview, ArrayAdapter <String> adapter, ContentResolver cr) {
					
		
		listview.setAdapter(adapter);
		
		Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		String[] projection = new String[] {ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
		String selection= "has_phone_number = ?";
		String[] selectionArgs = {"1"};
		String sortOrder= null;
		
		Cursor cur = cr.query(uri, projection, selection, selectionArgs, sortOrder);
		
		int indexName = cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
		int indexNumber = cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
		
		
			if(cur.getCount()>0 )
			{	
		
				cur.moveToFirst();
				do {
					
				    String name   = cur.getString(indexName);
				    String number = cur.getString(indexNumber);
				    
				    adapter.add(name+", "+number);
				} while (cur.moveToNext()); 
			}
			
			
		
	}
}
