package com.xworkz.restruntdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.hibernatedemoapp.entity.RestaurantEntity;

public class RestaurentDAO {
	public void saveRestaurant(RestaurantEntity entity) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(entity);
		tx.commit();

	}

}
