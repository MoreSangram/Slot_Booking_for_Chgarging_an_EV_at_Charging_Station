package com.example.demo.pojos;

public class AdminRegistration {
	String name;
	String user;
	String password;
	String conpassword;
	String email;
	String contact;
	String address;
	
	//int d_id;
	
	
public AdminRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminRegistration(String name, String user, String password, String email, String conpassword, String contact,
		String address) {
	super();
	this.name = name;
	this.user = user;
	this.password = password;
	this.email = email;
	this.conpassword = conpassword;
	this.contact = contact;
	this.address = address;
}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConpassword() {
		return conpassword;
	}

	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerRegistration [name=" + name + ", user=" + user + ", password=" + password + ", email=" + email
				+ ", conpassword=" + conpassword + ", contact=" + contact + ", address=" + address + "]";
	}









	
}
