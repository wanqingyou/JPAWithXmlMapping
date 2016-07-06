package com.jpa.entity;

import java.util.Date;

/**
 * A POJO class represents the order entity.
 * @author WYou
 * @since 2016.05.08
 */
public class Orders {
	private int order_ID;
	private Date orderDate;
	private double amount;
	private Customers customer;

	public int getOrderID() {
		return order_ID;
	}

	public void setOrderID(int orderID) {
		this.order_ID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
