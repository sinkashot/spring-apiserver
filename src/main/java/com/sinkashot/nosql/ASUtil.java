package com.sinkashot.nosql;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.WritePolicy;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.Value;

public class ASUtil {

	public static void main(String[] args) {
		System.out.println("Client modules imported.");
		
		AerospikeClient client = new AerospikeClient("localhost", 3000);
		System.out.println("Initialized the client and connected to the cluster.");
		
		Key key = new Key("test", "demo", "foo");
		System.out.println("Working with record key:");
		System.out.println(key);
		
		Bin bin1 = new Bin("name", "Justin");
		Bin bin2 = new Bin("age", 37);
		Bin bin3 = new Bin("greeting", "Hello Aero!");

		// Write a record
		client.put(null, key, bin1, bin2, bin3);
		System.out.println("Successfully written the record.");
		
		// Read the record
		Record record = client.get(null, key);
		System.out.println("Read back the record.");
		
		System.out.println("Record values are:");
		System.out.println(record);
		
		client.close();
		System.out.println("Connection closed.");
	}

}
