package com.example.controller;

import java.util.List;

import org.bson.Document;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Model;
import com.example.service.ServiceClass;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;


@RestController
public class ControllerClass 
{
	@Autowired
	ServiceClass service;

	Logger logger=(Logger) LoggerFactory.getLogger(ControllerClass.class);
	@RequestMapping("/")
    public String index() {
		
		 logger.trace("A TRACE Message");
	        logger.debug("A DEBUG Message");
	        logger.info("An INFO Message");
	        logger.warn("A WARN Message");
	        logger.error("An ERROR Message");
        return "Howdy! Check out the Logs to see the output...";
    }	
	@GetMapping("/getdetails/{firstName}")
	public Model getDetails(@PathVariable("firstName") String firstName)
	{
		return service.getData(firstName);
	}
	@PostMapping("/saveModel")
	public Model saveModel(@RequestBody Model model)
	{
		service.insertData(model);
		return model;
	}
	@SuppressWarnings("finally")
	@GetMapping("/getdetails")
	public List<Model> getAll()
	{
		try {
		List<Model> l=service.getAll();
		for(Model m1:l)
		{
			ObjectMapper mapper=new ObjectMapper();
			 String jsonStr =mapper.writeValueAsString(m1);
			 logger.info(jsonStr);
		}
		}
		finally {
			return service.getAll();
		}
	}
	@GetMapping("/getOneModel/{num}")
	public String sortByName(@PathVariable("num") int num)
	{
		return service.getFirstData(num);
	}
	@GetMapping("/get10Models/{num}")
	public List<Document> get10models(@PathVariable("num") int num)
	{
		return service.getFirst10data(num);
	}
	@GetMapping("/getLatestByDate")
	public String getLatestDocByDate()
	{
		return service.getLatestUpdated();
	}
}