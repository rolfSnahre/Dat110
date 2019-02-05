package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length < MessageConfig.SEGMENTSIZE) {
			this.payload = payload; // TODO: check for length within boundary
		}else {
			throw new RuntimeException("Leangth not within bpoundery");
		}
		
		
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded;
		
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = (byte) payload.length;
		
		for(int i = 0; i < payload.length; i++) {
			encoded[i+1] = payload[i];
		}
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		payload = new byte[received[0]];
		
		for(int i = 0; i < payload.length; i++) {
			payload[i] = received[i+1];
		}
		
	   
		
	}
}
