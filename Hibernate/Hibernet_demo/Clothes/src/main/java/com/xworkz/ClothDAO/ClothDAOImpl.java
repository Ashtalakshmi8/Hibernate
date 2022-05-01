package com.xworkz.ClothDAO;

import java.util.Date;

import com.xworkz.entity.Cloth;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ClothDAOImpl implements ClothDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("cloth");

	@Override
	public void insertCloth(Cloth cloth) {
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {
			entityManager = factory.createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();

			entityManager.persist(cloth);
			tx.commit();
			System.out.println("try block");
		} catch (Exception e) {
			// tx.rollback();
			e.printStackTrace();
			System.out.println("inserted");

		} finally {
			if (entityManager != null)
				entityManager.close();
			System.out.println("finally block of save");
		}

	}

	@Override
	public Cloth getClothById(Integer clothId) {
		// TODO Auto-generated method stub

		EntityManager entityManager = null;
		Cloth cloth = null;
		try {
			entityManager = factory.createEntityManager();
			cloth = entityManager.find(Cloth.class, clothId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cloth;
	}

	@Override
	public void updateClothBrandAndpriceByid(String brand, double price, int id) {
		// TODO Auto-generated method stub

		EntityManager entityManager = null;
		EntityTransaction tx = null;
		Cloth cloth = null;
		try {
			entityManager = factory.createEntityManager();
			cloth = entityManager.find(Cloth.class, id);
			if (cloth != null) {
				tx = entityManager.getTransaction();
				tx.begin();
				cloth.setBrand(brand);
				cloth.setPrice(price);
				cloth.setId(id);
				entityManager.merge(cloth);
				tx.commit();
				System.err.println("updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}

		}
	}

	public void updateManufacturedYearById1(Date manufacturedYear, int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		Cloth cloth = null;
		try {
			entityManager = factory.createEntityManager();
			cloth = entityManager.find(Cloth.class, id);
			if (cloth != null) {
				tx = entityManager.getTransaction();
				tx.begin();
				cloth.setManufacturedyYear(manufacturedYear);
				entityManager.merge(cloth);
				tx.commit();
				System.out.println("Date updted.....!");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}

		}
	}

	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = null;
		EntityTransaction tx = null;
		Cloth cloth = null;
		try {
			entityManager = factory.createEntityManager();
			cloth = entityManager.find(Cloth.class, Id);
			if (cloth != null) {
				tx = entityManager.getTransaction();
				tx.begin();
				entityManager.remove(cloth);
				tx.commit();
				System.out.println("remove");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			if (entityManager != null) {
//				entityManager.close();
			System.out.println("removing.....!");
		}

		return;

	}

	@Override
	public void updateManufacturedYearById(Date manufacturedyYear, int id) {
		// TODO Auto-generated method stub

	}
}
