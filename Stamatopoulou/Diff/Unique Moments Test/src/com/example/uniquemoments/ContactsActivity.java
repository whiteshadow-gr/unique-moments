package com.example.uniquemoments;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ContactsActivity extends Activity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_layout);
		@SuppressWarnings("unused")
		Intent Intent = getIntent();
		DatabaseController dbController = new DatabaseController(this);        
	    SQLiteDatabase db = dbController.getWritableDatabase();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	/*
	 * Synarthsh emfanishs epafon ston xrhsth
	 */
	public void showdata(View view)
	{
		DatabaseController dbController = new DatabaseController(this);        
	    SQLiteDatabase db = dbController.getWritableDatabase();
	    	
		Cursor cursor = dbController.getAllContacts();
	    //Cursor c=db.rawQuery("SELECT * from Student", null);
	    int count= cursor.getCount();
	    cursor.moveToFirst();
	    TableLayout tableLayout = new TableLayout(getApplicationContext());
	    tableLayout.setVerticalScrollBarEnabled(true);
	    TableRow tableRow;
	    TextView textView,textView1,textView2,textView3,textView4,textView5;
	    tableRow = new TableRow(getApplicationContext());
	    textView=new TextView(getApplicationContext());
	    textView.setText("ID");
	    textView.setTextColor(Color.RED);
	  	textView.setTypeface(null, Typeface.BOLD);
	  	textView.setPadding(20, 20, 20, 20);
	  	tableRow.addView(textView);
	    textView4=new TextView(getApplicationContext());
	  	textView4.setText("Name");
	  	textView4.setTextColor(Color.RED);
	  	textView4.setTypeface(null, Typeface.BOLD);
	  	textView4.setPadding(20, 20, 20, 20);
	  	tableRow.addView(textView4);
	    textView5=new TextView(getApplicationContext());
	  	textView5.setText("Phone");
	  	textView5.setTextColor(Color.RED);
	  	textView5.setTypeface(null, Typeface.BOLD);
	  	textView5.setPadding(20, 20, 20, 20);
	  	tableRow.addView(textView5);
	  	tableLayout.addView(tableRow);
	    for (Integer j = 0; j < count; j++)
	    	{
	         tableRow = new TableRow(getApplicationContext());
	         textView1 = new TextView(getApplicationContext());
	         textView1.setText(cursor.getString(cursor.getColumnIndex("_ContactsID")));
	         textView2 = new TextView(getApplicationContext());
	         textView2.setText(cursor.getString(cursor.getColumnIndex("ContactsName")));
	         textView3 = new TextView(getApplicationContext());
	         textView3.setText(cursor.getString(cursor.getColumnIndex("ContactsNumber")));
	         
	         textView1.setPadding(20, 20, 20, 20);
	         textView2.setPadding(20, 20, 20, 20);
	         textView3.setPadding(20, 20, 20, 20);
	         
	         tableRow.addView(textView1);
	         tableRow.addView(textView2);
	         tableRow.addView(textView3);
	         
	         tableLayout.addView(tableRow);
	         cursor.moveToNext() ;
	    	}
	    setContentView(tableLayout);
	    db.close();
	}
	/*
	 * synarthsh eisagoghs dedomenon sth bash apo ton xrhsth
	 */
	public void InsertToDB(View v)
	   {
		DatabaseController dbController = new DatabaseController(this); 
		Contact person= new Contact();
		EditText editText_name= (EditText) findViewById(R.id.editText2);
		EditText editText_phone= (EditText) findViewById(R.id.editText3);
		person.Contact_setName1(editText_name.getText().toString());
		person.Contact_setPhone1(editText_phone.getText().toString());
		
		editText_name.setText("");
		editText_phone.setText("");
	
		dbController.insertContacts(person);
	   }
	/*public void DeleteContact(View v)
	{
		DatabaseController dbController = new DatabaseController(this); 
		EditText editText_id= (EditText) findViewById(R.id.editText1);
		Contact person= new Contact();
		dbController.DeleteContact(person.Contact_getid());
		
	}*/
	
	public void button_contacts (View view )
	{
		Intent intent= new Intent (this, Show_Contacts.class);
		startActivity(intent);
	}
	
}
