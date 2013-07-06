package com.example.soundsurround.utilities;

import com.example.soundsurround.constants.*;

public class TimePacket {
	private int protocol;
	private long timeMillis; // time since 1/1/1970
	
	public TimePacket(String message) {
		String[] elems = message.split("|");
		
		protocol = Integer.parseInt(elems[0]);
		timeMillis = Long.parseLong(elems[1]);
	}
	
	public static String getTimeMessage(int protocol) {
		switch (protocol) {
			case Handshake.CLIENT_OPEN_SYNC:
				return protocol + "|" + System.currentTimeMillis();
			default:
				return "" + System.currentTimeMillis();
		}
	}
	
	public long getTimeMillis() { return timeMillis; }
	
}
