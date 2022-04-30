package com.xworkz.runner;

import com.xworkz.hibernatedemoapp.entity.RestaurantEntity;
import com.xworkz.restruntdao.RestaurentDAO;

public class Runner {
	public static void main(String[] args) {
		RestaurantEntity restaurantEntity = new RestaurantEntity();
		restaurantEntity.setID(4);
		restaurantEntity.setContactNo(134646);
		restaurantEntity.setName("udupi");
		restaurantEntity.setRating(4.5);
		restaurantEntity.setType("veg");

		RestaurentDAO restaurantDAO = new RestaurentDAO();
		//restaurantDAO.saveRestaurant(restaurantEntity);
		System.out.println("saved");
		
		
		
		
		
		
		
		
	}

}
