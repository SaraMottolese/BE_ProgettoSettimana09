package com.film.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final EntityManagerFactory entitymManagerFactory;

	static {
		entitymManagerFactory = Persistence.createEntityManagerFactory("BE_ProgettoSettimana09");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entitymManagerFactory;

	}
}
