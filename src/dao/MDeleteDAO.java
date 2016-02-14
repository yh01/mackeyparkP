package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import util.MDBConnector;

public class MDeleteDAO {
	public int delete(String id){
		int count = 0;

		MDBConnector con = new MDBConnector();
		DB db = con.getConnection();



		DBCollection coll = db.getCollection("test");
		BasicDBObject query = new BasicDBObject("id", id);
		DBCursor cursor = coll.find(query);
		try {
			if (cursor.hasNext()) {
				DBObject doc = cursor.next();
				coll.remove(doc);
				count = 1;
			}
		} finally {
			cursor.close();
		}
		return count;
	}
}
