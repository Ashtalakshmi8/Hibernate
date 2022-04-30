package com.xworkz.runner;

import com.xworkz.hibernatedemoapp.entity.JpaEntity;
import com.xworkz.hibernatedemoapp.entity.RestaurantEntity;
import com.xworkz.restruntdao.RestaurentDAO;
import com.xworkz.restruntdao.RestaurentJPADao;

public class JpaTester {
	public static void main(String[] args) {
		
	
    JpaEntity jpaEntity = new JpaEntity();
    jpaEntity.setID(16);
    jpaEntity.setContactNo(134646);
    jpaEntity.setName("udupi");
    jpaEntity.setRating(4.5);
    jpaEntity.setType("veg");

	RestaurentJPADao restaurantjpaao = new RestaurentJPADao();
	restaurantjpaao.insertEntity (jpaEntity);
	System.out.println("saved Data");
	

}
}
