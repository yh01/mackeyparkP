package dao;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MUpdateDAO {
	public int update(String id, String name, double price, String quantity){
		int count = 0;

		System.out.println("DAO内");
		DB db = null;
		MongoClient mongo = null;
		try {
			mongo = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		db = mongo.getDB("event");
		DBCollection colls = db.getCollection("test");
		BasicDBObject query = new BasicDBObject("id", id);
		DBCursor cursor = colls.find(query);

		if (cursor.hasNext()) {
			DBObject doc = cursor.next();
			doc.put("name", name);
			doc.put("price", price);
			doc.put("quantity", quantity);
			colls.save(doc);
			System.out.println("Update成功");
		}

		return count;
	}
}
