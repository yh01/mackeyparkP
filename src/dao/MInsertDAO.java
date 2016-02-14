package dao;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import dto.MInsertDTO;

public class MInsertDAO {
	public boolean insert(MInsertDTO dto,String id, String name,float price,String quantity){
		 DB db = null;
		 MongoClient mongo = null;
		 try {
		 mongo = new MongoClient("localhost", 27017);
		 } catch (UnknownHostException e) {
		 e.printStackTrace();
		 }
		 db = mongo.getDB("event");
		 DBCollection colls = db.getCollection("test");
		 BasicDBObject input = new BasicDBObject();

		 input.put("id",id);
		 input.put("name",name);
		 input.put("price",  price);
		 input.put("quantity", quantity);
		 colls.insert(input);
		 return true;
	}
}