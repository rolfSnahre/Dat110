 package no.hvl.dat110.rpc;

import java.util.Arrays;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		
		encoded = new byte[str.length()+1];
		encoded[0] = rpcid;
		
		
		for (int i = 0; i < str.length(); i++) {
			encoded[i+1] = (byte) str.charAt(i);
		}

	
		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded
		
		decoded = "";
		for (int i = 1; i < data.length; i++) {
			decoded += (char) data[i];
		}

		

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type
		
		encoded = new byte[1];
		encoded[0] = rpcid;


		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
		return;
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array


		byte[] xByte = new byte[] {
				(byte)((x >> 24) & 0xff),
		        (byte)((x >> 16) & 0xff),
		        (byte)((x >> 8) & 0xff),
		        (byte)((x>> 0) & 0xff),
		};
		
		
				/**
		BigInteger bigInt = BigInteger.valueOf(x);
		byte[] xByte  = bigInt.toByteArray();
		*/
		/**
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(x);
		byte[] xByte  = bb.array();
		*/
		
		encoded = new byte[xByte.length+1];
		encoded[0] = rpcid;
		
		for(int i = 0; i < xByte.length; i++) {
			encoded[i+1] = xByte[i];
		}
		
		encoded = new byte[2];
		encoded[0] = rpcid;
		encoded[1] = (byte) x;

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		ByteBuffer bb = ByteBuffer.allocate(4);
		byte[] values = new byte [data.length - 1];
		for(int i = 0; i < values.length; i ++) {
			values[i] = data[i+1];
		}
		
		bb.wrap(values);
		
		decoded = bb.getInt();
		
		decoded = (int) values[0]; 

		return decoded;

	}
}
