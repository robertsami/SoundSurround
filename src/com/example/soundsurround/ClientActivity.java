package com.example.soundsurround;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.soundsurround.utilities.SntpClient;
import com.example.soundsurround.utilities.TimePacket;

public class ClientActivity extends Activity {

	private Socket client;
	private PrintWriter printwriter;
	private Button button;
	private TextView clock;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.client_activity);

		button = (Button) findViewById(R.id.button1);   //reference to the send button
		clock = (TextView) findViewById(R.id.lastFetchedTime);

		//Button press event listener
		button.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				SntpClient client = new SntpClient();
				if (client.requestTime("nist.netservicesgroup.com", 10000)) {
					clock.setText("" + (client.getNtpTime() + SystemClock.elapsedRealtime() - client.getNtpTimeReference()));
				} else {
					clock.setText("failure or timeout");
				}

			}
		});

	}
}