package com.xworkz.tv.DAO;

import java.util.List;

import com.xworkz.entity.TvChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TvChannelDAOImpl implements TvChannelDAO {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("tv");

	@Override
	public void saveChnnel(TvChannel tvchannel) {
		// TODO Auto-generated method stub

		EntityManager entityManager = null;
		EntityTransaction tx = null;
		try {

			entityManager = factory.createEntityManager();
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(tvchannel);
			tx.commit();

		} catch (Exception e) {
			// tx.rollback();
			e.printStackTrace();

		} finally {
			if (entityManager != null)
				entityManager.close();

		}
	}

	public TvChannel getChannelById(Integer Channel_id) {
		EntityManager entityManager = null;

		TvChannel entity = null;
		try {
			entityManager = factory.createEntityManager();
			entity = entityManager.find(TvChannel.class, Channel_id);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return entity;
	}

	public TvChannel update(double Price, Integer channelId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		TvChannel tvChannel = null;
		try {
			entityManager = factory.createEntityManager();
			tvChannel = entityManager.find(TvChannel.class, channelId);
			if (tvChannel != null) {
				transaction = entityManager.getTransaction();
				transaction.begin();
				tvChannel.setPrice(Price);
				entityManager.merge(tvChannel);
				transaction.commit();
				System.out.println("Update.....");
			}
		} catch (Exception e) {
			// transaction.rollback();
			e.printStackTrace();

		} finally {
			System.out.println("executing............");
		}
		return tvChannel;
	}

	@Override
	public TvChannel remove(String name, Integer ChannelId) {

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		TvChannel tvChannel = null;
		try {
			entityManager = factory.createEntityManager();
			tvChannel = entityManager.find(TvChannel.class, ChannelId);
			if (tvChannel != null) {
				transaction = entityManager.getTransaction();
				transaction.begin();
				// tvChannel.setChannelName(name);
				entityManager.remove(tvChannel);
				transaction.commit();
				System.out.println("remove.....");
			}
		} catch (Exception e) {
			// transaction.rollback();
			e.printStackTrace();

		} finally {
			System.out.println("Deleted............");
		}

		// TODO Auto-generated method stub
		return null;
	}

//By using Query
	@Override
	public String getChannelNameById(Integer channelId) {
		// TODO Auto-generated method stub
		EntityManager entityManager = null;
		String channelName = null;
		try {
			entityManager = factory.createEntityManager();
			Query query = entityManager.createQuery("SELECT ChannelName FROM TvChannel WHERE Channel_id=:id");// dynamic
																												// query
																												// passing
																												// parameter//
			query.setParameter("id", channelId);
			channelName = (String) query.getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No data added");

		}

		finally {
			if (entityManager != null)
				entityManager.close();

		}

		return channelName;
	}

	@Override
	public TvChannel getChannelByName(String channelName) {

		EntityManager entityManager = null;
//if ur using this here then remove query in entity class
		// String getByName = "FROM TvChannel where ChannelName =:name";  
		TvChannel channel = null;
		try {
			entityManager = factory.createEntityManager();
		//	Query query = entityManager.createQuery(getByName);
			// parameter//
			// query.setParameter("name", channelName);
			Query query=entityManager.createNamedQuery("getByName");
			channel = (TvChannel) query.getSingleResult();

		} catch (NoResultException e) {
			return channel;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return channel;
	}

	@Override
	public List<TvChannel> findAll() {
		EntityManager entityManager = null;
		List<TvChannel> tvChannelList = null;
		try {
			entityManager = factory.createEntityManager();
			Query query = entityManager.createNamedQuery("fetchAll");
			tvChannelList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return tvChannelList;
	}

}
