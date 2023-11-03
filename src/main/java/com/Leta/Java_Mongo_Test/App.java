package com.Leta.Java_Mongo_Test;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class App 
{
	static MongoCollection<Document> collection;
    public static void main( String[] args )
    {
    	MongoClient client = new MongoClient( "localhost"  , 27017 );
    	MongoDatabase database=client.getDatabase("School");
    	collection=database.getCollection("Student");
    	
		/*
		  for (String string : client.listDatabaseNames()) {
		 	System.out.println(string); }
		 */
    	
    	//create();
    	//read();
    	//update();
    	//delete();
    	
    }
    
    
    static void create() {
    	
    	
    	Document document=new Document("name","Birhanu Nega");
    	document.append("age", 22);
    	document.append("department", "IT");
    
    	collection.insertOne(document);
    	System.out.println("Successfully !");
    }
    
    
    static void read() {
    	
    	
//    	for (Document document : collection.find().limit(3)) {
//			System.out.println(document);
//		}
    	
    	Document filter= new Document("age",54);   // search by age
    	
    	for (Document document : collection.find(filter)) {
			System.out.println(document.getString("name")+" : "+document.getInteger("age")+" : "+document.getString("department"));
		}
    	
    	System.out.println(String.format("%100s", "_").replace(" ","_")); // draw a line
    	
    
    
    	
    }

    static void update() {
    	Document filter=new Document("name","String");
    	Document update=new Document("$set",new Document("age",54).append("department", "Java"));
    	collection.updateOne(filter, update);
    	
    	read();
    	
    	
    	
    	
    	
    	
    }

    
    static void delete() {
    	Document filter= new Document("name","Birhanu Nega");
    	collection.deleteOne(filter);
    	System.out.println("Deleted ");
    }
    
    
    
    
    
    
    
    
}
