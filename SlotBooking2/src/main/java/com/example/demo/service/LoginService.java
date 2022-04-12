package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.example.demo.pojos.Customer;
import com.example.demo.pojos.Distributor;
import com.example.demo.pojos.Login;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DistributorRepository;
import com.example.demo.repository.LoginRepository;

//import net.bytebuddy.dynamic.DynamicType.Builder.RecordComponentDefinition.Optional;

//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service
public class LoginService {
	
	@Autowired
	LoginRepository sr;
	
	@Autowired
	DistributorRepository drepo;
	
	
	@Autowired
	CustomerRepository crepo;
	
	@Autowired
	AdminRepository arepo;
	
	

	public Object checkLogin(String user,String password)
	{
		System.out.println(user+":"+password);
		List<Login> l=sr.checkLogin(user,password);
		if(l.size()==1)
		{
			System.out.println(l.get(0).getRole()+":"+l.get(0).getLogin_id());
			
			Distributor d=null;
			Admin a=null;
			Customer c=null;
			if(l.get(0).getRole().equals("Customer"))
			{
				Optional<Customer> oc=crepo.findcustomer(l.get(0));
				try
				{
					System.out.println(oc);
				  return (Object)oc;
				}
				catch(Exception e)
				{
					return null;
				}
				
			}
			
			
			else if(l.get(0).getRole().equals("Distributor"))
			{
				Optional<Distributor> od=drepo.finddistributor(l.get(0));
				try
				{
					System.out.println(od);
				  return (Object)od;
				}
				catch(Exception e)
				{
					return null;
				}
			}
			
			
			else if(l.get(0).getRole().equals("Admin"))
			{
				Optional<com.example.demo.pojos.Admin> oa=arepo.findadmin(l.get(0));
				try
				{
					System.out.println(oa);
				  return (Object)oa;
				}
				catch(Exception e)
				{
					return null;
				}
			}
			return a;
		}
			else
			{
				return null;
			}
				
		}
	
	
	public void forgetPassword(String password, String user)
	{
		  sr.forgetPassword(password, user);
	}
		
	/*@Override
	public Consumer authenticateConsumer(String email, String password) {
		Optional<Consumer> findByEmailAndPassword = consuRepo.findByEmailAndPassword(email, password);
		if(findByEmailAndPassword.isPresent()) {
			 consumer = findByEmailAndPassword.get();
			      return consumer;
		}	
		throw new RecordNotFoundException("Consumer Not Found : Invalid Email or Password " + email+" "+password);
	}*/
		
			
			
		/*
		else 
		{
			System.out.println(l.get(0).getRole()+":"+l.get(0).getLogin_id());
			Distributor d=null;
			if(l.get(0).getRole().equals("Distributor"))
			{
				Optional<Distributor> od=drepo.finddistributor(l.get(0));
				try
				{
					System.out.println(od);
				  return (Object)od;
				}
				catch(Exception e)
				{
					return null;
				}
			}
			return d;
		}
		
	/*	System.out.println(user+":"+password);
		List<Object[]> l=sr.checkLogin(user,password);
		if(l.size()==1)
		{
			System.out.println(l.get(0)[0]+":"+l.get(0)[1]);
			Distributor d=null;
			if(l.get(0)[0].equals("Distributor"))
			{
				Optional<Distributor>od=drepo.findById((int)l.get(0)[1]);
				try
				{
					d=od.get();
				}
				catch(Exception e)
				{
					d=null;
				}
			}
			return d;
			
		}
		else
		{
			return null;
		}
	}
			
		*/
			
			
			
			
			
		
			
	
/*
		else if(l.size()==1)
			{
				System.out.println(l.get(0).getRole()+":"+l.get(0).getLogin_id());
				Distributor d=null;
				if(l.get(0).getRole().equals("Distributor"))
				{
					Optional<Distributor> od=drepo.finddistributor(l.get(0));
					try
					{
						System.out.println(od);
					  return (Object)od;
					}
					catch(Exception e)
					{
						return null;
					}
				}
				return d;
			}*/
	
		
		
	
	
	

	
	public List<Login> getAll()
	{
		return sr.findAll();
	}
	
	
	public Login save(Login s)
	{
		return sr.save(s);
	}
	
}
