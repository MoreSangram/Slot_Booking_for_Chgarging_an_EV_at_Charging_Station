package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Booking;
import com.example.demo.pojos.Complaint;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.ComplaintRepository;
@Service
public class ComplaintService {
	
	@Autowired
	ComplaintRepository br;
	
	public Complaint save(Complaint b) {
	return br.save(b);
	}
	
	
	public List<Complaint> getAll()
	{
		return br.findAll();
	}


}
