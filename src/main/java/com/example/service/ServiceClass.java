package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.Model.Model;
import com.example.repository.repository;

@Service
@ComponentScan("com.example.repository")
public class ServiceClass
{
	@Autowired
	repository repo;
	public Model getData(String firstName)
	{
		return repo.findByfirstName(firstName);
	}
	public void insertData(Model model)
	{
		repo.save(model);
	}
	public List<Model> getAll()
	{
		List<Model> l=new ArrayList<Model>();
		List<Model> l1=repo.findAll();
		for(Model m:l1)
		{
			l.add(m);
		}
		return l;
	}
	public List<?> getFirstData(int num)
	{
		return repository.findbyAssending(num);
	}
	public List<?> getFirst10data()
	{
		return repository.return10Doc();
	}
	public List<?> getLatestUpdated()
	{
		return repository.returnLatestUpdated();
	}
}