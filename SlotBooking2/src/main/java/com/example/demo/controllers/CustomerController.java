package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Customer;
import com.example.demo.pojos.CustomerRegistration;
import com.example.demo.pojos.Distributor;
import com.example.demo.pojos.Login;
import com.example.demo.service.CustomerService;
import com.example.demo.service.DistributorService;
import com.example.demo.service.LoginService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

	@Autowired
	CustomerService custService;
	
	@Autowired
	LoginService logService;
	/*
	@Autowired
	DistributorService distService;*/
	
	@PostMapping("/registercust")
	public Customer registerCustomer(@RequestBody CustomerRegistration cr)
	{
		Login l=new Login (cr.getUser(),cr.getPassword(),"Customer");
	  
	    Login inserted=logService.save(l);
	    
     
		
		Customer c=new Customer(cr.getName(),cr.getConpassword(),cr.getEmail(),cr.getContact(),cr.getAddress(),cr.getCity(),inserted,cr.getPancard()/*,cr.getConsumer()*/);
		
		return custService.save(c);
	}
	

	@PostMapping("/savecust")
	public Customer save(@RequestBody Customer s)
	{
		return custService.save(s);
	}
	
	@GetMapping("/allcustomer")
	public List<Customer> getAll()
	{
		return custService.getAll();
	}
	
	@GetMapping("/getone")
	public Customer getOne(@RequestParam("cid") int cid)
	{
		return custService.getOne(cid);
	}
	
	@GetMapping("/getone/{id}")
	public Customer getOneUsingCid(@PathVariable ("id") int cid)
	{
		return custService.getOne(cid);
	}
	
	
	
}
