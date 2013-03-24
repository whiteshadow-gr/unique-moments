package com.example.notification_app;


import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

        Button clickme;
        NotificationManager nm;
        int uniqueID = 1;
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

		Notify();
                
        
                clickme.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                        
                        String body = "Hello !! You made it.";
                        String title = "Worked !";
                        
                        Notification n = new Notification(R.drawable.icon, body, System.currentTimeMillis());
                        n.setLatestEventInfo(MainActivity.this, title, body, pi);
                        n.defaults = Notification.DEFAULT_ALL;
                        nm.notify(uniqueID, n);
                        //uniqueID++;
                        //finish();
        
                }});
        
        
        
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
                return true;
        }

	private void Notify() {
		clickme = (Button) findViewById(R.id.bclick);
                nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.cancel(uniqueID);
	}

}

