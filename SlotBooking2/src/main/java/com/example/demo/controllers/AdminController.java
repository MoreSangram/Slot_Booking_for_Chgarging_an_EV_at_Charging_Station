package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Admin;
import com.example.demo.pojos.AdminRegistration;
import com.example.demo.pojos.Customer;
import com.example.demo.pojos.CustomerRegistration;
import com.example.demo.pojos.Login;
import com.example.demo.service.AdminService;
import com.example.demo.service.CustomerService;
import com.example.demo.service.LoginService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class AdminController {
	@Autowired
	AdminService adService;
	
	@Autowired
	LoginService logService;
	/*
	@Autowired
	DistributorService distService;*/
	
	@PostMapping("/registeradmin")
	public Admin registerAdmin(@RequestBody AdminRegistration ar)
	{
		Login l=new Login (ar.getUser(),ar.getPassword(),"Admin");
	  
	    Login inserted2=logService.save(l);
	    
     
		
		Admin a=new Admin(ar.getName(),ar.getEmail(),ar.getConpassword(),ar.getContact(),ar.getAddress(),inserted2);
		
		return adService.save(a);
	}
	

	/*@PostMapping("/savecust")
	public Admin  save(@RequestBody Admin s)
	{
		return adService.save(s);
	}*/
	
	@GetMapping("/alladmin")
	public List<Admin> getAll()
	{
		return adService.getAll();
	}
	
	

}
