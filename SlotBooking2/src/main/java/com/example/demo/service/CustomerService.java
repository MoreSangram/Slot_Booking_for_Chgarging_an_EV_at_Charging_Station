package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Booking;
import com.example.demo.pojos.Customer;
import com.example.demo.pojos.Distributor;
import com.example.demo.pojos.Login;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DistributorRepository;
import com.example.demo.repository.LoginRepository;

@Service
@Transactional
public class CustomerService {
	
	//@Autowired
	//LoginRepository sr;
	
	

	
	@Autowired
	CustomerRepository crepo;
	
	@Autowired
	BookingRepository brepo;
	
	@Autowired
	DistributorRepository drepo;
	
	@Autowired
	EmailService emailService;

	
	/*Customer customer;
	Booking book;
	Distributor distributor;*/
	/*
	public Booking bookCyliner(Customer con) {
		Customer customer = new Customer();
		Booking book = new Booking();
		LocalDate orderDate = LocalDate.now();
		Optional<Customer> optional = crepo.findByConsumer(customer.getConsumer());
		if(optional.isPresent()) {
			con = optional.get();
			if( customer.getCid() == con.getCid()) {
			
				ArrayList<LocalDate> date = new ArrayList<>();
				if( !customer.getBook().isEmpty() )
				{
					List<Booking> book1 = customer.getBook();
					for (Booking order : book1) {
						date.add(order.getBook_date());
					}
	
					Collections.sort(date,Collections.reverseOrder());
					
					Object[] array = date.toArray();
					
					LocalDate ld = (LocalDate) array[0];
					
					int compareTo = ld.plusDays(15).compareTo(book_date);
					
					if(compareTo > 15  || compareTo < 0)
					{
						//Distributor dist = customer.getDistributor_tbl();
						//dist.setAvailableStock(dist.getAvailableStock()-1);
						//distRepo.save(dist);
						
					   // System.out.println("comapre   " +compareTo );
					    //consumer.setNoOfCylinders(consumer.getNoOfCylinders()+1);
						
						book.setBook_date(orderDate);
						book.setDelivery_date(book_date.plusDays(3));
						
						
						
						//DeliveryStatus delStatus = DeliveryStatus.NOT_DELIVERED;
						//order.setDeliveryStatus(delStatus);
						
						//PaymentStatus payStatus = PaymentStatus.UNPAID;
						//order.setPaymentStatus(payStatus);
						
						book.setCustomer_tbl(customer);
						crepo.save(customer);
					return brepo.save(customer);
				   }
				}
				else
				{
					/*Distributor dist = consumer.getDistConsumerOwner();
					dist.setAvailableStock(dist.getAvailableStock()-1);
					distRepo.save(dist);
					
				    consumer.setNoOfCylinders(consumer.getNoOfCylinders()+1);
					
					*/
				/*   book.setBook_date(orderDate);
					book.setDelivery_date(orderDate.plusDays(3));
					
					
					DeliveryStatus delStatus = DeliveryStatus.NOT_DELIVERED;
					order.setDeliveryStatus(delStatus);
					
					PaymentStatus payStatus = PaymentStatus.UNPAID;
					order.setPaymentStatus(payStatus);
					
					order.setConsumerOrder(consumer);
					consuRepo.save(consumer);
				return orderRepo.save(order);
				}
			}*/
	
	
	
	public Customer save(Customer p) {
		emailService.sendEmailForNewRegistration(p.getEmail());
		return crepo.save(p);
		}
	
	public Customer getOne(int cid)
	{
		Optional<Customer> op = crepo.findById(cid);
	    Customer s = null;
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
	
	public Customer getOneUsingCid(int cid)
	{
		return crepo.getOne(cid);
	}
	
	
		public List<Customer> getAll()
		{
			return crepo.findAll();
		}

	
	/*

	
	
	

	public Booking bookCyliner(Customer c) {
		con = new Customer();
		book = new Booking();
		Date book_date = Date.now();
		Optional<Customer> optional = sr.findByConsumer(c.getConsumer());
		if(optional.isPresent()) {
			con = optional.get();
			if(con.getCid() == c.getCid()) {
			
				ArrayList<Date> date = new ArrayList<>();
				if( !con.getBook().isEmpty() )
				{
					List<Booking> book1 = con.getBook();
					for (Booking book : book1) {
						date.add(book.getBook_date());
					}
	
					Collections.sort(date,Collections.reverseOrder());
					
					Object[] array = date.toArray();
					
					Date ld = (Date) array[0];*/
					
				/*	int compareTo = ld.plusDays(15).compareTo(book_date);
					
					if(compareTo > 15  || compareTo < 0)
					{
						Distributor dist = con.getDistributor_tbl();
						dist.setAvailableStock(dist.getAvailableStock()-1);
						distRepo.save(dist);
						
					    System.out.println("comapre   " +compareTo );
					    consumer.setNoOfCylinders(consumer.getNoOfCylinders()+1);
						
						book.setBook_date(book_date);
						book.setDeliveryDate(book_date.plusDays(3));
						
						DeliveryStatus delStatus = DeliveryStatus.NOT_DELIVERED;
						order.setDeliveryStatus(delStatus);
						
						PaymentStatus payStatus = PaymentStatus.UNPAID;
						order.setPaymentStatus(payStatus);
						
						book.setCustomer_tbl(con);
						sr.save(con);
					return bRepo.save(book);
				   }
				}
				else
				{
					Distributor dist = con.getDistConsumerOwner();
					dist.setAvailableStock(dist.getAvailableStock()-1);
					distRepo.save(dist);
					
				    consumer.setNoOfCylinders(consumer.getNoOfCylinders()+1);
					
					
					order.setOrderDate(orderDate);
					order.setDeliveryDate(orderDate.plusDays(3));
					
					
					DeliveryStatus delStatus = DeliveryStatus.NOT_DELIVERED;
					order.setDeliveryStatus(delStatus);
					
					PaymentStatus payStatus = PaymentStatus.UNPAID;
					order.setPaymentStatus(payStatus);
					
					order.setConsumerOrder(consumer);
					consuRepo.save(consumer);
				return orderRepo.save(order);
				}
			}
			throw new RecordNotFoundException( "Your account is not activated");	
		}
	throw new RecordNotFoundException( "Error while booking cylinder : Invalid consumer no");	
	}
	*/
	/*public List<Booking> getMyBooking(int id) {
		Optional<Customer> optional =sr.findById(id);
		if(optional.isPresent()) {
			con=optional.get();
			List<Booking> book = con.getBook();
					return book;
			}
		//throw new RecordNotFoundException("Consumer Not found . Invalid Consumer Id");
		else {
		return null;
		}
	}*/

	/*@Override
	public List<Order> getMyPendingBooking(int consumerId) {
		consumer = new Consumer();
		Optional<Consumer> optional = consuRepo.findById(consumerId);
		if(optional.isPresent()) {
			consumer=optional.get();
			List<Order> orders = consumer.getOrders();
			List<Order> allPendingOrder = new ArrayList<>();
			for (Order order : orders) {
				if(order.getDeliveryStatus()==DeliveryStatus.NOT_DELIVERED)
					allPendingOrder.add(order);
			}
			return allPendingOrder;
	    }	
		throw new RecordNotFoundException("Consumer Not found . Invalid Consumer Id");
	}*/

}


