package dao;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import dto.MDisplayDTO;

public class MDisplayDAO {
	public ArrayList<MDisplayDTO> selectM(){
		 DB db = null;

		   ArrayList<MDisplayDTO> list = new ArrayList<MDisplayDTO>();


		   MongoClient mongo = null;
		    try {
			 mongo = new MongoClient("localhost", 27017);
		   } catch (UnknownHostException e) {
			  e.printStackTrace();
		   }
		     db = mongo.getDB("event");

		DBCollection colls = db.getCollection("test");

		DBCursor cursor = colls.find();

		try {
		   while(cursor.hasNext()) {

			   MDisplayDTO dto = new MDisplayDTO();
			   DBObject dbs = cursor.next();
			   dto.setId((String)dbs.get("id"));
			   dto.setName((String)dbs.get("name"));
			   dto.setPrice((Double) dbs.get("price"));
			   dto.setQuantity((String)dbs.get("quantity"));
            list.add(dto);
		   }
		} finally {
		   cursor.close();
		}
//		return true;
		System.out.println("成功");
		return list;
	}
}
