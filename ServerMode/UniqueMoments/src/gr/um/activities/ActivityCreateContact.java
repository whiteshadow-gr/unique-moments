package gr.um.activities;

import gr.um.database.ControllerContactsDB;
import gr.um.entities.Contact;
import gr.um.uniquemoments.R;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//-----------------------------------------------------------------------------------------------------------------------------------------//

public class ActivityCreateContact extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_contact);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		/**
		 * Inflate the menu; this adds items to the action bar if it is present.
		 */
		getMenuInflater().inflate(R.menu.activity_create_contact, menu);
		return true;
	}
	
	/**
	 * createContactButtonClick is the method that is called by a button to add the contact
	 * that the user wants to create
	 * @param view the view is needed in order to call the method via a button
	 */
	public void createContactButtonClick (View v)
	{
		/**
		 * EditText name is the name that we want to add
		 */
		/**
		 * EditText number is the number of the person we want to add
		 */
		EditText name = (EditText)findViewById(R.id.editname);
		EditText number = (EditText)findViewById(R.id.editnumber);
		String contactName = name.getText().toString();
		String contactNumber = number.getText().toString();
		
		Contact myContact = new Contact(contactName, contactNumber);
		
		ControllerContactsDB db = new ControllerContactsDB(this);
		
		createContact(contactName, contactNumber);
		db.addContact(myContact);
		
		Intent intentBack = new Intent(this, ActivityContacts.class);
		startActivity(intentBack);		
	 }
		
	/**
	 * createContact adds the contact to the phonebook, persons app, of the user
	 * @param name the name of the person
	 * @param number the phone number of the person
	 * @exception RemoteException
	 * @exception OperationApplicationException
	 */
	private void createContact(String name, String phone) 
	{
    	ContentResolver cr = getContentResolver();
    	
    	Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        
    	if (cur.getCount() > 0) {
        	while (cur.moveToNext()) {
        		String existName = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        		if (existName.contains(name)) {
                	Toast.makeText(ActivityCreateContact.this,"The contact name: " + name + " already exists", Toast.LENGTH_SHORT).show();
                	return;        			
        		}
        	}
    	}
    	
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, "accountname@gmail.com")
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, "com.google")
                .build());
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                .withValue(ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, name)
                .build());
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                .withValue(ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, phone)
                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_HOME)
                .build());
       
        try {
			cr.applyBatch(ContactsContract.AUTHORITY, ops);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OperationApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Toast.makeText(ActivityCreateContact.this, "Created a new contact with name: " + name + " and Phone No: " + phone, Toast.LENGTH_SHORT).show();
    }
}