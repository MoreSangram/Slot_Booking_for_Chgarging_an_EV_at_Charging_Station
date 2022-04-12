

package com.example.demo.pojos;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="complaint_tbl")
public class Complaint{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int com_id;
	

	//@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	//@JoinColumn(name = "cid")
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column
	int cid;
	
	/*@Column
	int d_id;
	*/
	
	@Column
    Date complaint_date ;

//	@Column
//	String status;
	
	@Column
	String complaint_desc;

	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complaint(int com_id, Date complaint_date, /*String status,*/ String complaint_desc) {
		super();
		this.com_id = com_id;
		this.cid = cid;
		//this.d_id=d_id;
		this.complaint_date = complaint_date;
		//this.status = status;
		this.complaint_desc = complaint_desc;
	}

	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}
	



	public Date getComplaint_date() {
		return complaint_date;
	}

	public void setComplaint_date(Date complaint_date) {
		this.complaint_date = complaint_date;
	}

//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}

	public String getComplaint_desc() {
		return complaint_desc;
	}

	public void setComplaint_desc(String complaint_desc) {
		this.complaint_desc = complaint_desc;
	}

	@Override
	public String toString() {
		return "Complaint [com_id=" + com_id + ", cid=" + cid +  ", complaint_date=" + complaint_date
				+ /*", status=" + status + */", complaint_desc=" + complaint_desc + "]";
	}

	




}
