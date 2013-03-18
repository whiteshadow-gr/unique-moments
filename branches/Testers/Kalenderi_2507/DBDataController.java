package com.example.uniquemoments;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Before;

public class DBDataController
{

	@Before
	public void setUp() throws Exception 
	{
	}

	ArrayList contacts[];
	public String ContactSearch(ArrayList contacts)
	{
		System.out.print("Dwse thn epafh:");
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		//Arxikopoihsh metavlhtwn
		String mystring = " ";
		//String contact1=;
		try 
			{
			mystring=String.valueOf(in.readLine());
			}
		catch(Exception Input)
			{
			System.out.println("An exception found:"+ Input.toString());
			}
		System.out.println(mystring);
	for (int j = 0; j < contacts.size(); j++) 
		{
		
		if(mystring.equals(contacts))
			{
			System.out.println(contacts);
			return mystring;
			}
		}
	return mystring;
	}
}


