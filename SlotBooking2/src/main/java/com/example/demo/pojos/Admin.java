

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
@Table(name="admin_tbl")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	
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
	
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)	  
	Login  login_tbl;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String email, String conpassword, String contact, String address, Login login_tbl) {
		super();
		this.name = name;
		this.email = email;
		this.conpassword = conpassword;
		this.contact = contact;
		this.address = address;
		this.login_tbl = login_tbl;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Login getLogin_tbl() {
		return login_tbl;
	}

	public void setLogin_tbl(Login login_tbl) {
		this.login_tbl = login_tbl;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", conpassword=" + conpassword + ", email=" + email + ", contact="
				+ contact + ", address=" + address + ", login_tbl=" + login_tbl + "]";
	}

	
	
	/*@OneToMany(mappedBy = "distributor_tbl",cascade = CascadeType.ALL)
	List<Customer> customers ;*/









	
}
