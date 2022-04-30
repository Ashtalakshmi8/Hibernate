package com.xworkz.tv.DAO;

import com.xworkz.entity.TvChannel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
		}catch(Exception e) {
	//	transaction.rollback();
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
				//tvChannel.setChannelName(name);
				entityManager.remove(tvChannel);
				transaction.commit();
				System.out.println("remove.....");
			}
		}catch(Exception e) {
	//	transaction.rollback();
		e.printStackTrace();
		
		} finally {
			System.out.println("Deleted............");
		}
		
		
		// TODO Auto-generated method stub
		return null;
	}
}





	

//not required dont use
//	@Override
//	public void readChannel(TvChannel tvchannel) {,
// TODO Auto-generated method stub
//		EntityManagerFactory factory = null;
//		EntityManager entityManager = null;
//		EntityTransaction tx = null;
//		try {
//			factory = Persistence.createEntityManagerFactory("tv");
//			entityManager = factory.createEntityManager();
//			tx = entityManager.getTransaction();
//			tx.begin();
//
//			TvChannel channel = entityManager.find(TvChannel.class, 1);
//			System.out.println("channel_Id::" + channel.getChannel_id());
//			System.out.println("name::" + channel.getChannelName());
//			System.out.println("Language::" + channel.getLanguage());
//			System.out.println("price::" + channel.getPrice());
//			System.out.println(channel.toString());
//			tx.commit();
//
//		} catch (Exception e) {
//			// tx.rollback();
//			e.printStackTrace();
//
//		} finally {
//			if (factory != null)
//				factory.close();
