package gr.um.database;

import gr.um.interfaces.IDatabase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**ContactsDBFactory A factory class for constructing the 2 types of the DB.
 */
public class ContactsDBFactory 
{
	private static Context context = null;
	private static SQLiteDatabase database;
	
	/**
	 * ContactsDBFactory constructor with Context for parameter.
	 * @param context
	 */
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