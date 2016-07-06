package com.jpa.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * A utility class to get EntityManager instances
 * @author WYou
 * @since 16.5.0
 */
public class PersistenceHelper {

	private static final EntityManager entityManager;

	static {
		entityManager = Persistence.createEntityManagerFactory("JPAXmlMappingPU").createEntityManager();
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void clearDatabase() {
		entityManager.clear();
		entityManager.close();
	}
}
