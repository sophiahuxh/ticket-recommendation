package db.mongodb;

import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;

public class MongoDBTableCreation {
	
	public static void main (String[] args) {
	String db_name = MongoDBUtil.DB_NAME;
//	String URI = "mongodb://localhost:27017";
	MongoClient mongoClient = new MongoClient();
	MongoDatabase db = mongoClient.getDatabase(db_name);
	
	// drop old collections
	db.getCollection("users").drop();
	db.getCollection("items").drop();
	
	// create new collections
	
	db.getCollection("users").insertOne(new Document()
            									.append("user_id","1111")
    								            .append("password", "3229c1097c00d497a0fd282d586be050")
											.append("first_name", "John")
								            .append("last_name", "Smith")
								       );
	IndexOptions indexOptions = new IndexOptions().unique(true);
	
	db.getCollection("users").createIndex(new Document("user_id",1), indexOptions);
	db.getCollection("items").createIndex(new Document("item_id",1), indexOptions);
	
	
	mongoClient.close();
    System.out.println("Import is done successfully.");	
	}

}
