package com.xworkz.restruntdao;

import com.xworkz.hibernatedemoapp.entity.JpaEntity;
import com.xworkz.hibernatedemoapp.entity.RestaurantEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RestaurentJPADao {
	public static void insertEntity( JpaEntity jpaEntity) {
		 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA" );
        
		 EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );
	      
	      entitymanager.persist(jpaEntity);
	      entitymanager.getTransaction( ).commit( );

	      entitymanager.close( );
	      emfactory.close( );

}
}

