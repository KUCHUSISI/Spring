package com.example.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import util.JsonUtil;


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
	
	public static String findbyAssending(int a)
	{
		List l=new ArrayList();
		FindIterable<Document> cursor = table.find().sort(new Document("firstName",a)).limit(1).projection(Projections.exclude("_class"));
		Iterator i=cursor.iterator();
		while(i.hasNext())
		{
			l.add( i.next());
		}
		String response = JsonUtil.getJackson2SerializedObject(l, JsonInclude.Include.NON_NULL);
		return response;
	}
	public static List<Document> return10Doc(int a)
	{
		List l=new ArrayList<Document>();
		FindIterable<Document> cursor = table.find().sort(new Document("firstName",a)).limit(10).projection(Projections.exclude("_class"));
		Iterator<Document> i=cursor.iterator();
		while(i.hasNext())
		{
			l.add( i.next());
		}
			return l;
	}
	public static String returnLatestUpdated()
	{
		List l=new ArrayList();
		FindIterable<Document> cursor = table.find().sort(new Document("date",-1)).limit(1).projection(Projections.exclude("_class"));
		Iterator<Document> i=cursor.iterator();
		while(i.hasNext())
		{
			l.add(i.next());
		}
		String response = JsonUtil.getJackson2SerializedObject(l, JsonInclude.Include.NON_NULL);		
		
		return response;		
	}
}