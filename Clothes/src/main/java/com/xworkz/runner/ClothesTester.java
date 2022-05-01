package com.xworkz.runner;

import com.xworkz.ClothDAO.ClothDAO;
import com.xworkz.ClothDAO.ClothDAOImpl;
import com.xworkz.entity.Cloth;

public class ClothesTester {
	public static void main(String[] args) {

		Cloth cloth = new Cloth();
		cloth.setId(13);
		cloth.setBrand("Allen solly");
		cloth.setPrice(153.68);
		cloth.getManufacturedyYear();

		ClothDAO cDAO = new ClothDAOImpl();

		cDAO.insertCloth(cloth);
		System.out.println("saved");
		System.out.println(cDAO.getClothById(4));
		System.out.println("read");
		cDAO.updateClothBrandAndpriceByid("park Avenue", 20.586, 1);
		System.out.println("updated........!");
//	    cDAO.updateManufacturedYearById(2025,5);
//	    System.out.println("updating year");
		cDAO.deleteById(3);
		System.out.println("deleted....");
	}
}
