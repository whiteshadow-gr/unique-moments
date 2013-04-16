package com.example.myuniquemoments;

import gr.um.eortologio.EortologioEventReader;

import java.util.ArrayList;

import android.content.Context;

public class FindEventsController {

	public static String getImportantNames(Context context)
	{
		ArrayList<String>names = new ArrayList<String>();
		EortologioEventReader reader = new EortologioEventReader("http://www.eortologio.gr/rss/si_en.xml");
        names=reader.getNames();
        //TODO
        //ControllerDatesDb db=new ControllerDatesDb(context); 
        //db.addDates(names);
        if (names.isEmpty()) {
        	return "";
        }
        return names.get(0);
	}
}
