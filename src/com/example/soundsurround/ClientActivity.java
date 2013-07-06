package com.example.soundsurround;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.soundsurround.utilities.Handshake;
import com.example.soundsurround.utilities.TimePacket;

public class ClientActivity extends Activity {

	private Socket client;
	private PrintWriter printwriter;
	private Button button;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.client_activity);

		button = (Button) findViewById(R.id.button1);   //reference to the send button

		//Button press event listener
		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				try {

					client = new Socket("10.0.2.2", 4444);  //connect to server
					printwriter = new PrintWriter(client.getOutputStream(),true);
					inputStreamReader = new InputStreamReader(client.getInputStream());
					bufferedReader = new BufferedReader(inputStreamReader);
					
					printwriter.write(TimePacket.getTimeMessage(Handshake.CLIENT_OPEN_SYNC));  //write the message to output stream
					printwriter.flush();
					
					
					
					printwriter.close();
					client.close();   //closing the connection

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

	}
}