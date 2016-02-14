package dao;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import dto.MContactInsertDTO;

public class MContactInsertDAO {
	public boolean insert(MContactInsertDTO dto,String contact_id, String contact_name, String contact){
		 DB db = null;
		 MongoClient mongo = null;
		 try {
		 mongo = new MongoClient("localhost", 27017);
		 } catch (UnknownHostException e) {
		 e.printStackTrace();
		 }
		 db = mongo.getDB("event");
		 DBCollection colls = db.getCollection("contact");
		 BasicDBObject input = new BasicDBObject();

		 input.put("contact_id",contact_id);
		 input.put("contact_name",contact_name);
		 input.put("contact",  contact);
		 colls.insert(input);
		 return true;
	}
}
