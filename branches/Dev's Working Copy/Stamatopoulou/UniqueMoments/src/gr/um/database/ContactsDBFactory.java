package gr.um.database;

import gr.um.activities.ActivityContacts;
import gr.um.activities.ActivityNotification;
import gr.um.interfaces.IDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class ContactsDBFactory 
{
	private static Context context = null;
	private static SQLiteDatabase database;
	
	
	
	public ContactsDBFactory(Context context)
	{
		this.context = context;
	}
	
	public static IDatabase getInstance(ContactDBTypes type)
	{
		
		
		switch (type)
		{
		case CONTACTS_SQLITE_DATABASE:
			return new ControllerContactsDB(context);
		case CONTACTS_MOCK_DATABASE:
			return new MockControllerContactsDB();
		default:
			return new ControllerContactsDB(context);
		}
	}
}
