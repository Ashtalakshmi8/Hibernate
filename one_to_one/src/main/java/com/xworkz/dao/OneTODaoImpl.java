package com.xworkz.dao;

import com.xworkz.one_to_one_entity.CountryEntity;

import com.xworkz.one_to_one_entity.PresidentEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OneTODaoImpl implements OneTOOneDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("OneToOne");
	EntityManager entityManager = null;
	EntityTransaction tx = null;

	@Override
	public void saveData(CountryEntity countyEntity, PresidentEntity entity) {
		// TODO Auto-generated method stub
		try {
			entityManager = entityManagerFactory.createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			
			entityManager.persist(countyEntity);
			entityManager.persist(entity);
			tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}