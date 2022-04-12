package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.Booking;
import com.example.demo.pojos.Complaint;
import com.example.demo.service.BookingService;
import com.example.demo.service.ComplaintService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ComplaintsController {
	
	@Autowired
	ComplaintService comservice;
	
	
	@PostMapping("/savecomplaint")
	public Complaint save(@RequestBody Complaint s)
	{
		return comservice.save(s);
	}
	
	@GetMapping("/allcomplaints")
	public List<Complaint> getAll()
	{
		return comservice.getAll();
	}

}
