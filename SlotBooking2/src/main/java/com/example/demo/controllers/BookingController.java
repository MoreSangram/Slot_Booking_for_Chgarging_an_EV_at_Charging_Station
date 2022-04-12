package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Booking;
import com.example.demo.pojos.Login;
import com.example.demo.service.BookingService;
import com.example.demo.service.LoginService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookingController {
	
	@Autowired
	BookingService sservice;
	
	
	@PostMapping("/savebook")
	public Booking save(@RequestBody Booking s)
	{
		return sservice.save(s);
	}
	
	
	
	@GetMapping("/allbook")
	public List<Booking> getAll()
	{
		return sservice.getAll();
	}
	
	@GetMapping("/deletebook")
	public void delete(@RequestParam("cid")int cid)
	{
		sservice.delete(cid);
	}

}
