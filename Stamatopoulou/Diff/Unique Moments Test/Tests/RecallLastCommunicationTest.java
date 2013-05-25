package com.example.unique_moments;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class RecallLastCommunication {


	
	public  static void RecallLastSentMSG(String Name1,String Name2){

	boolean Name=true;
	if (Name) {
		System.out.println("Recall Sent message");
	} else {
	System.out.println("Not Recall sent message");
	}
	assert Name!= true;
    return;

}

public void  ReturnLastSentMSG(String args[])

{
	String[] names = new String[]{"Name8", "Name10"};
	System.out.println("Return sent message");
	return;
}	
public static void RecallLastReceivedMSG(String Name3,String Name4)
{
	boolean Name=true;
	if (Name) {
				System.out.println("Recall received message");
			  } 
	else {
				System.out.println("Not Recall received message");
			}
	assert Name!= true;
	return;
}	
public void ReturnLastReceivedMSG(String args[])
{

	String[] names = new String[] {"Name12", "Name14"};
	System.out.println("Return received message");
	return;
}
}


