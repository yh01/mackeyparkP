package util;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MDBConnector {
	public DB getConnection(){
		DB db = null;
		try{
			MongoClient mongo = new MongoClient("localhost", 27017);
			db = mongo.getDB("chocotime");
		}catch(UnknownHostException e){
			e.printStackTrace();
		}

		return db;
	}


}
