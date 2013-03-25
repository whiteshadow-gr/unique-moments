/**
 * 
 */
package com.example.umoments;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import android.R.boolean;

/**
 * @author Tonia
 *
 */
public class SearchContactTest 
{	
	class contact 
	{
		contact()
		{
			
		}	
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public boolean test() 
	{
		DatabaseController dbc = new DatabaseController(this);        
	    //SQLiteDatabase db = dbController.getWritableDatabase();
		Cursor myCursor = new Cursor;
		Contact temp;
		
		temp.setName1("Antonia");
		String actualName;
		db.insertContacts(temp);
		myCursor = db.getAllContacts();
		int count = myCursor.getCount();
		int found = 0;
		
		/*
		for (Integer j = 0; j < count; j++)
		{
			actualName = cursor.getString(cursor.getColumnIndex("ContactsName"));
			if(actualName == temp.getName1())
			{
				found = 1;
				cursor.moveToNext();
			}
		}
		*/
	
		myCursor = SearchContactTest.searchContactsByName(temp.getName1());
		actual = cursor.getString(cursor.getColumnIndex("ContactsName");
		
		return assertEquals(actual, temp.getName1());
	}
			
}
