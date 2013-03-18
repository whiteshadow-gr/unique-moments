package com.example.uniquemoments;

//import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.Test;
import java.io.*;


public class testcase_u1 {

	@Before
	public void setUp() throws Exception {
	}

	/*@Test
	public void test() {
		
		fail("Not yet implemented");
	
	}
	*/
	//@test
	public boolean CreateNewContact(String contact)
	{	
		System.out.print("Dwse tn epafi(contact)");
		//System.in.print("%s");
	
		//dimiourgia enos bufferedReader 
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

		//arxikopoiisi metablitis
		String mystring=null;
		String s1=null;
		try
		{
		//anagnosi string
		mystring=String.valueOf(in.readLine());
		}
		catch(Exception Input)
		{
		System.out.println("An exception found: "+ Input.toString());
		}
		System.out.println(mystring);
	
	    if(mystring.equals(s1))
	    {
	        System.out.print(true);
	        return true;
	    }
	    else
	    {
	        System.out.print(false);
	        return false;
	    }

	}
	
	

}
