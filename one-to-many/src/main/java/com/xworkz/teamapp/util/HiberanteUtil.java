package com.xworkz.teamapp.util;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HiberanteUtil {
	private static final EntityManagerFactory factory;
	
	static {
		factory=Persistence.createEntityManagerFactory("one-to-many");
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}

}
