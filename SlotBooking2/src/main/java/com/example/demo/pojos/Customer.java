
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="customer_tbl")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int cid;
	
	@Column
	String name;
	
	@Column
	String conpassword;
	
	@Column
	String email;
	
	@Column
	String contact;
	
	@Column
	String address;
	
	@Column
	String city;
	
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)	  
	Login  login_tbl;
	
	
	@Column
	String pancard;
	
	
//	@Column
//	int consumer;
	/*@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "d_id", nullable = true)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)	
	Distributor distributor_tbl;*/
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "d_id", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)	  
	Distributor distributor_tbl;*/
	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "d_id")//constraint : NOT NULL : Optional BUT recommended
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Distributor distributor_tbl;
	*/
	
	/*@OneToMany(mappedBy = "customer_tbl",cascade = CascadeType.ALL)
	List<Booking> book ;
	*/
	
	/*@OneToMany(mappedBy = "customer_tbl",cascade = CascadeType.ALL, fetch = FetchType.EAGER,
			orphanRemoval = true)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)	 
	private List<Booking> book = new ArrayList<>();
*/
	
	/* 
	 @OneToMany(mappedBy = "customer_tbl", cascade = CascadeType.ALL)
	  	//List<Complaint> complaints = new ArrayList<Complaint>();
		List<Complaint>complaints;
	*/	
	
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(String name, String conpassword, String email, String contact, String address, String city,
			Login login_tbl, String pancard/*, int consumer*//* Distributor distributor_tbl, List<Booking> book*/) {
		super();
		this.name = name;
		this.conpassword = conpassword;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.city = city;
		this.login_tbl = login_tbl;
		this.pancard = pancard;
//		this.consumer = consumer;
		//this.distributor_tbl = distributor_tbl;
		//this.book = book;
	}




	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
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



	public Login getLogin_tbl() {
		return login_tbl;
	}



	public void setLogin_tbl(Login login_tbl) {
		this.login_tbl = login_tbl;
	}



	public String getPancard() {
		return pancard;
	}



	public void setPancard(String pancard) {
		this.pancard = pancard;
	}



//	public int getConsumer() {
//		return consumer;
//	}
//
//
//
//	public void setConsumer(int consumer) {
//		this.consumer = consumer;
//	}



	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", conpassword=" + conpassword + ", email=" + email
				+ ", contact=" + contact + ", address=" + address + ", city=" + city + ", login_tbl=" + login_tbl
				+ ", pancard=" + pancard +/* ", consumer=" + consumer + */"]";
	}



	

/*
	public Distributor getDistributor_tbl() {
		return distributor_tbl;
	}



	public void setDistributor_tbl(Distributor distributor_tbl) {
		this.distributor_tbl = distributor_tbl;
	}
*/


	/*public List<Booking> getBook() {
		return book;
	}



	public void setBook(List<Booking> book) {
		this.book = book;
	}
*/





	



	


	



	/*
	public List<Booking> getDt() {
		return dt;
	}


	public void setDt(List<Booking> dt) {
		this.dt = dt;
		for(Booking c : dt)
			c.setCustomer_tbl(this);
	}
*/
	

	
}


	