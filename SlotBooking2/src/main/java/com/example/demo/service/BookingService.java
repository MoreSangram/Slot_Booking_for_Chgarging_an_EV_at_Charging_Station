package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Booking;
import com.example.demo.pojos.Customer;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CustomerRepository;
@Transactional
@Service
public class BookingService {
	
	@Autowired
	BookingRepository br;
	
	public Booking save(Booking b) {
	return br.save(b);
	}
	
	
	public List<Booking> getAll()
	{
		return br.findAll();
	}
	

	public Booking findById1(int bid)
	{
		Optional<Booking> book=br.findById(bid);
		return book.orElse(null);
	}
	
	public void delete(int cid)
	{
		br.delete(cid);
	}

	


}
