

package com.example.demo.pojos;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="distributor_tbl")
public class Distributor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int d_id;
	
	@Column
	String name;
	
	@Column
	String conpassword;
	
	@Column
	String email;
	
	@Column
	String contact;
	
	 @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)	  
	Login  login_tbl;
	
	@Column
	String license;
	
	@Column
	String pancard;
	
	@Column
	String address;
	
	@Column
	String city;
	
	/*@OneToMany(mappedBy = "distributor_tbl",cascade = CascadeType.ALL)
	List<Customer> customers ;
	*/
	/*
@OneToMany(mappedBy = "distributor_tbl",cascade = CascadeType.ALL, fetch = FetchType.EAGER,
			orphanRemoval = true)
@JsonProperty(access = JsonProperty.Access.READ_WRITE)	 
	private List<Customer> customers = new ArrayList<>();
*/

	public Distributor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distributor(String name, String conpassword,String email,String contact, Login login_tbl, String license, String pancard, String address,
			String city/* , List<Customer> customers*/) {
		super();
		this.name = name;
		this.conpassword=conpassword;
		this.email = email;
		this.contact=contact;
		this.login_tbl = login_tbl;
		this.license = license;
		this.pancard = pancard;
		this.address = address;
		this.city = city;
		//this.customers = customers;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
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

	public Login getLogin_tbl() {
		return login_tbl;
	}

	public void setLogin_tbl(Login login_tbl) {
		this.login_tbl = login_tbl;
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
   
   /*

public List<Customer> getCustomers() {
	return customers;
}

public void setCustomers(List<Customer> customers) {
	this.customers = customers;
}*/

@Override
public String toString() {
	return "Distributor [d_id=" + d_id + ", name=" + name + ", conpassword=" + conpassword + ", email=" + email
			+ ", contact=" + contact + ", login_tbl=" + login_tbl + ", license=" + license + ", pancard=" + pancard
			+ ", address=" + address + ", city=" + city  + "]";
}




	/*public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
		for(Customer c : customers)
			c.setDistributor_tbl(this);
	}*/

	








	
}
