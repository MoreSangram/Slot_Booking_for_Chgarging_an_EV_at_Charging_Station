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
import com.example.demo.pojos.Login;
import com.example.demo.service.LoginService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {

	@Autowired
	LoginService lservice;
	


	/*@PostMapping("/savelogin")
	public Login save(@RequestBody Login s)
	{
		return lservice.save(s);
	}*/
	
	/*@GetMapping("/allLogin")
	public List<Login> getAll()
	{
		return lservice.getAll();
	}*/
	
	@PostMapping("/checkLogin")
	public Object checkLogin(@RequestBody Login l)
	{
		return lservice.checkLogin(l.getUser(),l.getPassword());
	}
	
	@GetMapping("/changePassword")
	public void forgetPassword(@RequestParam("password")String password,@RequestParam("user") String user)
	{
		lservice.forgetPassword(password, user);
	}
	
	
}
	

