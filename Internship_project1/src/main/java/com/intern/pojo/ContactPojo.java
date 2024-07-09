package com.intern.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class ContactPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sn;
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String email;
	@Column(length = 1000)
	private String message;
	@Column(length = 50)
	private String datetime;
	
	public ContactPojo() {
		
	}

	public ContactPojo(String name, String email, String message, String datetime) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
		this.datetime = datetime;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	
	
}
