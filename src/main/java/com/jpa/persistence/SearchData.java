package com.jpa.persistence;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.jpa.entity.Customers;
import com.jpa.entity.Orders;

/**
 * This class provides options to search data in the given criteria.
 * * 1. Search Customers by Order Date
 * * 2. Search Orders by Customer Name
 * @author WYou
 * @since 16.5.0
 */
public class SearchData {

	private static void printInfo() {
		System.out.println("** Search Data Utilities **");
		System.out.println("** 1. Search Customers by Order Date **");
		System.out.println("** 2. Search Orders by Customer Name **");
		System.out.println("** 3. Quit **");
		System.out.println("***************************************");
	}

	public static void main(String[] args) {
		EntityManager entityManager = PersistenceHelper.getEntityManager();
		try {
			printInfo();
			int option = -1;
			Scanner keyboard = new Scanner(System.in);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//need to be yyyy-MM-dd (case sensitive)
			option = Integer.parseInt(keyboard.nextLine());
			String criteria = "";
			while (option != 3) {
				switch (option) {
				case 1:
					System.out.println("Input Order Date in YYYY-MM-DD format: ");
					System.out.println();
					criteria = keyboard.nextLine();
					List<Customers> getcustomers = entityManager.createQuery(
							"Select customers FROM Customers as customers" + " join  customers.order  ord where ord.orderDate = :orderDate",
							Customers.class).setParameter("orderDate", df.parse(criteria)).getResultList();
					for (Iterator<Customers> iterator = getcustomers.iterator(); iterator.hasNext();) {
						Customers cust = (Customers) iterator.next();
						System.out.println("Customer ID: " + cust.getCustomerID());
						System.out.println("Customer Name: " + cust.getCustomerName());
						System.out.println("Contact: " + cust.getContactInformation());
						System.out.println("***************************************");
					}
					break;
				case 2:
					System.out.println("Input Customer Name(Either first or last name):");
					System.out.println();
					criteria = keyboard.nextLine();
					List<Orders> getorders = entityManager.createQuery(
							"Select orders FROM Orders as orders" + " join  orders.customer cust where LOWER(cust.customerName) LIKE :name",
							Orders.class).setParameter("name", "%" + criteria.toLowerCase() + "%").getResultList();
					for (Iterator<Orders> iterator = getorders.iterator(); iterator.hasNext();) {
						Orders order = iterator.next();
						System.out.println("Order ID: " + order.getOrderID());
						System.out.println("Customer Name: " + order.getCustomer().getCustomerName());
						System.out.println("Order Date: " + order.getOrderDate());
						System.out.println("Order Amount: " + order.getAmount());
						System.out.println("***************************************");
					}
					break;
				}
				printInfo();
				option = Integer.parseInt(keyboard.nextLine());
			}
			System.out.println("End searching.");
			keyboard.close();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		PersistenceHelper.clearDatabase();
		System.exit(1);
	}

}
