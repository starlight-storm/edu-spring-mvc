package com.example.customer.business.domain;

public class Customer implements java.io.Serializable {

	private int id;
	private String name;
	private String address;
	private String emailAddress;

	public Customer() {
	}

	public Customer(String name, String address, String emailAddress) {
		this.name = name;
		this.address = address;
		this.emailAddress = emailAddress;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, address=%s, emailAddress=%s]", id, name, address, emailAddress);
	}

	private static final long serialVersionUID = 3428490997353904743L;
}
