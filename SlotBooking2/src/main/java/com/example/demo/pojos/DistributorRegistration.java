package com.example.demo.pojos;

import java.util.List;

public class DistributorRegistration {
	
	String name;
	String user;
	String password;
	String conpassword;
	String email;
	String contact;
	String license;
	String pancard;
	String address;
	String city;
	
	public DistributorRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DistributorRegistration( String name,String user, String password, String conpassword,String email,String contact, String license,
			String pancard, String address, String city) {
		super();
		this.name = name;
		this.user = user;
		this.password = password;
		this.conpassword=conpassword;
		this.email = email;
		this.contact=contact;
		this.license = license;
		this.pancard = pancard;
		this.address = address;
		this.city = city;
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

	

	public String getConpassword() {
		return conpassword;
	}

	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "DistributorRegistration [name=" + name + ", user=" + user + ", password=" + password + ", conpassword="
				+ conpassword + ", email=" + email + ", contact=" + contact + ", license=" + license + ", pancard="
				+ pancard + ", address=" + address + ", city=" + city + "]";
	}



	

	/*public List<Customer> getCustomer1() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	


}
