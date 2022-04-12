package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Customer;
import com.example.demo.pojos.Distributor;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DistributorRepository;

@Service
public class DistributorService {
	
	@Autowired
	DistributorRepository sr;
	
	@Autowired
	CustomerRepository crepo;
	
	
	public Distributor save(Distributor p) {
	return sr.save(p);
	}
	
	public List<Distributor> getAll()
	{
		return sr.findAll();
	}
	
	public Distributor getOne(int d_id)
	{
		Optional<Distributor> op = sr.findById(d_id);
	    Distributor s = null;
		try
		{
			s = op.get();
		}
		catch(NoSuchElementException e)
		{
			s=null;
		}
		return s;
	}
	

	public void delete(int d_id)
	{
		sr.delete(d_id);
	}
	
	
	/*
	public List<Customer> getAll()
	{
		return crepo.getAll();
	}
*/
}
