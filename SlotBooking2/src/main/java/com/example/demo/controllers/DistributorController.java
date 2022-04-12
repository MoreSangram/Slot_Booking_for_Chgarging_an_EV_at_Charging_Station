package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Customer;
import com.example.demo.pojos.Distributor;
import com.example.demo.pojos.DistributorRegistration;
import com.example.demo.pojos.Login;
import com.example.demo.service.CustomerService;
import com.example.demo.service.DistributorService;
import com.example.demo.service.LoginService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DistributorController {

	@Autowired
	DistributorService distService;
	
	@Autowired
	CustomerService custService;
	
	

	@Autowired
	LoginService logService;
	
	
	@PostMapping("/registerdist")
	public Distributor registerCustomer(@RequestBody DistributorRegistration dr)
	{
		Login l=new Login (dr.getUser(),dr.getPassword(),"Distributor");
	  
	    Login inserted=logService.save(l);
		Distributor c=new Distributor(dr.getName(),dr.getConpassword(),dr.getEmail(),dr.getContact(),inserted,dr.getLicense(),dr.getPancard(),dr.getAddress(),dr.getCity());
		
		return distService.save(c);
	}
	
	@PostMapping("/savedistri")
	public Distributor save(@RequestBody Distributor s)
	{
		return distService.save(s);
	}
	
	@GetMapping("/alldistributor")
	public List<Distributor> getAll()
	{
		return distService.getAll();
	}
	
	@GetMapping("/onedistributor")
	public Distributor getOne(@RequestParam("d_id") int d_id)
	{
		return distService.getOne(d_id);
	}
	
	@GetMapping("/delete")
	public void delete(@RequestParam("d_id")int d_id)
	{
		distService.delete(d_id);
	}
	
	/*
	@GetMapping("/allcustomer")
	public List<Customer> getAll()
	{
		return custService.getAll();
	}
		*/
	
	/*@GetMapping("/delete")
	public void delete(@RequestParam("cid")int cid)
	{
		sservice.delete(cid);
	}*/
}
