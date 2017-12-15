package demo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MogoDbConnection {
    public static void main(String[] args){
	String envUri = "";
        MongoClientURI uri = new MongoClientURI(envUri);

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("teamrocket");
        //database.createCollection("test");
        MongoCollection<Document> collection = database.getCollection("test");


        Document doc = new Document("title", "title value")
                .append("id", "sdf")
                .append("firstname", "robert");
        collection.insertOne(doc);
    }
}
