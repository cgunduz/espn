package com.cemgunduz.espn.mongo;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public abstract class AbstractMongoDao {

	private static final String DB_NAME = "ESPN";
	MongoClient mongo;
	DB db;
	
	protected AbstractMongoDao()
	{
		try {
			mongo = new MongoClient( "localhost" , 27017 );
		} catch (UnknownHostException e) {
			
			System.out.println("Client connection error");
			e.printStackTrace();
		}
		db = mongo.getDB(DB_NAME);
	}
}
