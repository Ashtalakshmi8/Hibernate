package com.xworkz.teamapp.dao;

import com.xworkz.teamapp.entity.TeamEntity;
import com.xworkz.teamapp.util.HiberanteUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TeamDao {

	private EntityManagerFactory factory = HiberanteUtil.getEntityManagerFactory();
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	public void saveTeam(TeamEntity entity) {
		try {
			entityManager = factory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(entity);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}

	}

}
