package com.jpa.entity;

import java.util.Set;

/**
 * A POJO class represents the customer entity.
 * @author WYou
 * @since 16.5.0
 */
public class Customers {
	private int customer_ID;
	private String customerName;
	private String contactInformation;
	private String address;
	private Set<Orders> order;

	public int getCustomerID() {
		return customer_ID;
	}

	public void setCustomerID(int customerID) {
		this.customer_ID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public Set<Orders> getOrder() {
		return order;
	}

	public void setOrder(Set<Orders> order) {
		this.order = order;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
