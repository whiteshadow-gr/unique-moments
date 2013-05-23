package gr.um.activities;

import gr.um.uniquemoments.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityEmail extends Activity
{
	
	Button sendEmail;
	EditText msg;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		sendEmail = (Button) findViewById(R.id.sendBtn);
		sendEmail.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				msg = (EditText) findViewById(R.id.msgTxt);
				String message = msg.getText().toString();
				sendEmail (message);
			}
		});
	}

	protected void sendEmail(String message) 
	{
		// TODO Auto-generated method stub
		String[] to = new String[]{""};
		String subject = ("A message from Unique-Moments");
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, message);
		emailIntent.setType("message/rfc822");
		startActivity(Intent.createChooser(emailIntent, "Email"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		return true;
	}

}
