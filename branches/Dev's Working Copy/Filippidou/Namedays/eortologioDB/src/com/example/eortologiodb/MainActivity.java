//i klasi sundeete me mia vasi i opoia periexei ta contacs
//kanei ena elegxw ama kapoio apo ta contacts giortzei simera to onoma tou
//ama nai tote eisagei tin imerominia sto pedio date


package com.example.eortologiodb;


import java.util.Calendar;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	String fname,lname,date;
	String[] Name={"ellada","nikos"};
	SQLiteDatabase db;
	 TableRow tableRow;
	   TextView textView,textView1,textView2,textView3,textView4,textView5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("MyDB1",MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Contact(fname VARCHAR,lname VARCHAR,date VARCHAR);");
        db.execSQL("DELETE FROM Contact;");
        
        data();
   
       comp();
       
    }
    
    
public void data()
{
	//eisagwgi contacs stin vasi
	
	 fname="ellada";
   	lname="filippidou";
   	date="";
     db.execSQL("INSERT INTO  Contact VALUES('"+fname+"','"+lname+"','"+date+"');");
     
     fname="zoi";
   	lname="bal";
   	date="";
     db.execSQL("INSERT INTO  Contact VALUES('"+fname+"','"+lname+"','"+date+"');");
     
     fname="nikos";
   	lname="nikolaou";
   	date="";
     db.execSQL("INSERT INTO  Contact VALUES('"+fname+"','"+lname+"','"+date+"');");
     
     fname="giwrgos";
    	lname="gewrgiou";
    	date="";
      db.execSQL("INSERT INTO  Contact VALUES('"+fname+"','"+lname+"','"+date+"');");
      
      fname="petros";
     	lname="petrou";
     	date="";
       db.execSQL("INSERT INTO  Contact VALUES('"+fname+"','"+lname+"','"+date+"');");
     
	 
}

public void comp()
{
	//sugkrisi tou fname tou contact me to onoma pou giortazei simera
	// ama vrethei kapoio pou giortazei eisagwgi tis imerominias stin vasi
	
	Calendar c = Calendar.getInstance();

	String sDate = c.get(Calendar.DAY_OF_MONTH)+ "-" 
	   + c.get(Calendar.MONTH) + "-" +c.get(Calendar.YEAR)  ;	
	
	for(Integer i=0; i<Name.length; i++)
	{
   
   db.execSQL("UPDATE Contact SET date ='"+sDate+"' WHERE fname like '"+Name[i]+"';");
	
   }

}


public void showdata(View view)
{
	//emfanisi olwn twn dedomenwn twn contacts apo tin vasi se ena table
	
    Cursor c=db.rawQuery("SELECT * from Contact", null);
     int count= c.getCount();
    c.moveToFirst();
    TableLayout tableLayout = new TableLayout(getApplicationContext());
    tableLayout.setVerticalScrollBarEnabled(true);
   TableRow tableRow;
   TextView textView,textView1,textView2,textView3,textView4,textView5;
   tableRow = new TableRow(getApplicationContext());
   textView=new TextView(getApplicationContext());
   textView.setText("Firstname");
  	textView.setTypeface(null, Typeface.BOLD);
  	 textView.setPadding(20, 20, 20, 20);
  	tableRow.addView(textView);
    textView4=new TextView(getApplicationContext());
  	textView4.setText("LastName");
  	textView4.setTypeface(null, Typeface.BOLD);
  	 textView4.setPadding(20, 20, 20, 20);
  	tableRow.addView(textView4);
    textView5=new TextView(getApplicationContext());
  	textView5.setText("NameDay");
  	textView5.setTypeface(null, Typeface.BOLD);
  	textView5.setPadding(20, 20, 20, 20);
  	tableRow.addView(textView5);
   tableLayout.addView(tableRow);
     for (Integer j = 0; j < count; j++)
     {
         tableRow = new TableRow(getApplicationContext());
         textView1 = new TextView(getApplicationContext());
         textView1.setText(c.getString(c.getColumnIndex("fname")));
         textView2 = new TextView(getApplicationContext());
         textView2.setText(c.getString(c.getColumnIndex("lname")));
         textView3 = new TextView(getApplicationContext());
         textView3.setText(c.getString(c.getColumnIndex("date")));
         textView1.setPadding(20, 20, 20, 20);
         textView2.setPadding(20, 20, 20, 20);
         textView3.setPadding(20, 20, 20, 20);
         tableRow.addView(textView1);
         tableRow.addView(textView2);
         tableRow.addView(textView3);
         tableLayout.addView(tableRow);
         c.moveToNext() ;
     }
     setContentView(tableLayout);
db.close();
}

}
