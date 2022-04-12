

package com.example.demo.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="book_tbl")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int bid;
	
	@Column
	String stationName;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(name="book_date")
	private Date bookDate;
	
	
	@Column
	double amount ;
	
	
	@JsonFormat(pattern = "HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	LocalTime startTime;
	
	@JsonFormat(pattern = "HH:mm")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	LocalTime endTime;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "cid")//constraint : NOT NULL : Optional BUT recommended
	//@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	
	@Column
	private String vid;
	
	
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "d_id")
	private Distributor distributor_tbl;*/
	/*
	@OneToMany(mappedBy = "OId", cascade = CascadeType.ALL)
	private List<BookingHistory> bhistory;
	
	*/
	/*
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "cid")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)	  
	Customer customer_tbl;
	*/
	@Column
	String payment_mode;
	
	//@Column
	//int transaction_id;
	
	//@Column
	//Date payment_date;
	
	/*@Enumerated(EnumType.STRING)
	@Column(name = "delivery_status")
	private DeliveryStatus deliveryStatus;
*/
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Booking(String name,Date book_date, double amount, LocalTime stime,LocalTime etime, String vid, String payment_mode
			) {
		super();
		this.stationName=name;
		this.bookDate = book_date;
		this.amount = amount;
		this.startTime=stime;
		this.endTime=etime;
		this.vid = vid;
		
		this.payment_mode = payment_mode;
		//this.deliveryStatus = deliveryStatus;
	}





	public int getBid() {
		return bid;
	}





	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getStationName() {
		return stationName;
	}

	public void setStationName(String name) {
		this.stationName = name;
	}



	public Date getBook_date() {
		return bookDate;
	}





	public void setBook_date(Date book_date) {
		this.bookDate = book_date;
	}





	public double getAmount() {
		return amount;
	}





	public void setAmount(double amount) {
		this.amount = amount;
	}





	public LocalTime getStartTime() {
		return startTime;
	}





	public void setStartTime(LocalTime time) {
		this.startTime=time;
	}

	public LocalTime getEndTime() {
		return endTime;
	}





	public void setEndTime(LocalTime time) {
		this.endTime=time;
	}








	public String getVid() {
		return vid;
	}





	public void setCid(String vid) {
		this.vid = vid;
	}










	public String getPayment_mode() {
		return payment_mode;
	}





	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}





	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", name=" + stationName + ", book_date=" + bookDate + ", amount=" + amount + ", Charging start time="
				+ startTime  + ", Charging end time="
						+ endTime + ", vid=" + vid + ", payment_mode=" + payment_mode + "]";
	}









	


/*

	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}





	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

*/












}	