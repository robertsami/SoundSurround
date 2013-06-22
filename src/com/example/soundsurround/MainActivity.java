package com.example.soundsurround;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button clientButton = (Button) findViewById(R.id.button1);
        
        clientButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), ClientActivity.class);
				startActivity(i);
			}
			
		});
        
        Button serverButton = (Button) findViewById(R.id.button2);
        
        serverButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ServerCreator c = new ServerCreator();
		        TextView message = (TextView) findViewById(R.id.textViewMessageReceived);
				while (true) {
					message.setText(c.listen());
				}
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
