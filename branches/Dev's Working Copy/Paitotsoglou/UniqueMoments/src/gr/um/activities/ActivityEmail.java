package gr.um.activities;

import gr.um.email.EmailBuilder;
import gr.um.email.EmailSenderFactory;
import gr.um.email.EmailSenderTypes;
import gr.um.interfaces.IEmail;
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
	
	private ActivityEmail act = this;
	public Button sendEmail;
	public EditText msg;
	
	
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
				EmailBuilder builder = new EmailBuilder();
				msg = (EditText) findViewById(R.id.msgTxt);
				String message = msg.getText().toString();
				Intent emailIntent = builder.createEmailIntent(message);
				
				IEmail sender = EmailSenderFactory.getInstance(EmailSenderTypes.EMAIL_SENDER, act);
				sender.sendEmail(emailIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		return true;
	}

}