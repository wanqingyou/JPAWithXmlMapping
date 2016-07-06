package com.jpa.persistence;

import java.util.Scanner;

import javax.persistence.EntityManager;

import com.jpa.entity.Orders;

/**
 * This class provides abilities for user to update database entries.
 * @author WYou
 * @since 16.5.0
 */
public class UpdateData {

	public static void main(String[] args) {
		EntityManager entityManager = PersistenceHelper.getEntityManager();
		System.out.println("** Update Order Amount **");
		System.out.println("----------------------------------------");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input order ID: ");
		int orderID = Integer.parseInt(keyboard.nextLine());
		System.out.println("Input new amount value: ");
		double amount = Double.parseDouble(keyboard.nextLine());

		Orders order = entityManager.find(Orders.class, orderID);
		if (order != null) {
			order.setAmount(amount);
			entityManager.getTransaction().begin();
			entityManager.merge(order);
			entityManager.flush();
			entityManager.getTransaction().commit();

			System.out.println("Updated order.");
			System.out.println("Order ID: " + orderID);
			System.out.println("Order Date: " + order.getOrderDate());
			System.out.println("Amount: " + order.getAmount());
			System.out.println("----------------------------------------");
		}
		else {
			System.out.println("No order is found with the given order ID.");
		}

		keyboard.close();
		PersistenceHelper.clearDatabase();
		System.exit(1);
	}

}
