package com.example.demo.pojos;

public class CustomerRegistration {
	String name;
	String user;
	String password;
	String conpassword;
	String email;
	String contact;
	String address;
	String city;
	String pancard;
	int consumer;
	//int d_id;
	
	
public CustomerRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CustomerRegistration(String name,String user, String password, String conpassword,String email, String contact,
			String address, String city, String pancard, int consumer) {
		super();
		this.name = name;
		this.user = user;
		this.password = password;
		this.conpassword=conpassword;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.city = city;
		this.pancard = pancard;
		this.consumer = consumer;
		//this.d_id=d_id;
		//this.distributor_tbl = distributor_tbl;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getPancard() {
		return pancard;
	}


	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	
	

/*
	public Distributor getDistributor_tbl() {
		return distributor_tbl;
	}



	public void setDistributor_tbl(Distributor distributor_tbl) {
		this.distributor_tbl = distributor_tbl;
	}
*/


	/*public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id)
	{
		this.d_id=d_id;
	}
*/


	public int getConsumer() {
		return consumer;
	}



	public void setConsumer(int consumer) {
		this.consumer = consumer;
	}



	@Override
	public String toString() {
		return "CustomerRegistration [name=" + name + ", user=" + user + ", password=" + password + ", conpassword="
				+ conpassword + ", email=" + email + ", contact=" + contact + ", address=" + address + ", city=" + city
				+ ", pancard=" + pancard + ", consumer=" + consumer + "]";
	}


}
