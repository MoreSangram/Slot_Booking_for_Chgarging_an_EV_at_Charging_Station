
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="login_tbl")
public class Login{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	int login_id;
	
	@Column
	String user;
	
	@Column
	String password;
	
	@Column
	String role;
	
	//@JsonIgnoreProperties("subject")
   // @OneToMany(mappedBy = "customer_tbl", cascade = CascadeType.ALL)
	//List<Customer> ct = new ArrayList<Customer>();
    
   // @OneToMany(mappedBy = "distributor_tbl", cascade = CascadeType.ALL)
   	//List<Distributor> dt = new ArrayList<Distributor>();
	

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Login(String user, String password, String role) {
		super();
		this.user = user;
		this.password = password;
		this.role = role;
	}




	public int getLogin_id() {
		return login_id;
	}




	public void setLogin_id(int login_id) {
		this.login_id = login_id;
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




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", user_name=" + user + ", password=" + password + ", role=" + role
				+ "]";
	}




}

	
	