//package com.example.repository;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.bson.Document;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//import com.example.Model.Model;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//
//@Repository
//public interface repository extends MongoRepository<Model, String> 
//{
//	com.mongodb.client.MongoClient mongo= MongoClients.create("mongodb://127.0.0.1:27017");
//	MongoDatabase db=mongo.getDatabase("StudentData");
//	MongoCollection<Document> table = db.getCollection("model");
//	Model findByfirstName(String firstName);
////	public  List getLatest10();
//	// Fetch latest document by created time.
//		// Fetch first document after ordering by First name alphabetically  (Done)
//		// Fetch first ten document after ordering by First name alphabetically(Done)
//	
//	public static List<Document> findbyAssending(int a)
//	{
//		List<Document> l=new ArrayList<Document>();
//		FindIterable<Document> cursor = table.find().sort(new Document("firstName",a)).limit(1);
//		Iterator<Document> i=cursor.iterator();
//		while(i.hasNext())
//		{
//			l.add( i.next());
//		}
//		return l;
//	}
//	public static List<String> return10Doc()
//	{
//		List<String> l=new ArrayList<String>();
//		FindIterable<Document> cursor = table.find().sort(new Document("firstName",1)).limit(10);
//		Iterator<Document> i=cursor.iterator();
//		while(i.hasNext())
//		{
//			l.add( i.next().toString());
//		}
//		return l;
//	}
//	public static List<String> returnLatestUpdated()
//	{
//		List<String> l=new ArrayList<String>();
//		FindIterable<Document> cursor = table.find().sort(new Document("date",1)).limit(1);
//		Iterator<Document> i=cursor.iterator();
//		while(i.hasNext())
//		{
//			l.add(i.next().toString());
//		}
//		return l;
//	}
//}
package com.example.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Model;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


@Repository
public interface repository extends MongoRepository<Model, String> 
{
	com.mongodb.client.MongoClient mongo= MongoClients.create("mongodb://127.0.0.1:27017");
	MongoDatabase db=mongo.getDatabase("StudentData");
	MongoCollection<Document> table = db.getCollection("model");
	Model findByfirstName(String firstName);
//	public  List getLatest10();
	// Fetch latest document by created time.
		// Fetch first document after ordering by First name alphabetically  (Done)
		// Fetch first ten document after ordering by First name alphabetically(Done)
	
	public static List findbyAssending(int a)
	{
		List l=new ArrayList();
		FindIterable<Document> cursor = table.find().sort(new Document("firstName",a)).limit(1);
		Iterator i=cursor.iterator();
		while(i.hasNext())
		{
			l.add( i.next());
		}
		return l;
	}
	public static List<Document> return10Doc()
	{
		List l=new ArrayList<Document>();
		FindIterable<Document> cursor = table.find().sort(new Document("firstName",1)).limit(10);
		Iterator<Document> i=cursor.iterator();
		while(i.hasNext())
		{
			l.add( i.next().toString());
		}
		return l;
	}
	public static List<Model> returnLatestUpdated()
	{
		List l=new ArrayList();
		FindIterable<Document> cursor = table.find().sort(new Document("date",1)).limit(1);
		Iterator<Document> i=cursor.iterator();
		while(i.hasNext())
		{
			l.add(i.next().toString());
		}
		return l;
	}
}