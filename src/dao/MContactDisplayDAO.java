package dao;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import dto.MContactDisplayDTO;

public class MContactDisplayDAO {
	public ArrayList<MContactDisplayDTO> selectM(){
		 DB db = null;

		   ArrayList<MContactDisplayDTO> list = new ArrayList<MContactDisplayDTO>();


		   MongoClient mongo = null;
		    try {
			 mongo = new MongoClient("localhost", 27017);
		   } catch (UnknownHostException e) {
			  e.printStackTrace();
		   }
		     db = mongo.getDB("event");

		DBCollection colls = db.getCollection("contact");

		DBCursor cursor = colls.find();

		try {
		   while(cursor.hasNext()) {

			   MContactDisplayDTO dto = new MContactDisplayDTO();
			   DBObject dbs = cursor.next();
			   dto.setContact_id((String)dbs.get("contact_id"));
			   dto.setContact_name((String)dbs.get("contact_name"));
			   dto.setContact((String) dbs.get("contact"));
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
