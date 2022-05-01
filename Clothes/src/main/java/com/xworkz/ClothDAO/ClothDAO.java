package com.xworkz.ClothDAO;

import java.util.Date;

import com.xworkz.entity.Cloth;

public interface ClothDAO {
	public void insertCloth(Cloth cloth);

	public Cloth getClothById(Integer clothId);

	public void updateClothBrandAndpriceByid(String brand, double price, int id);

	public void updateManufacturedYearById(Date manufacturedyYear, int id);

	public void deleteById(Integer Id);

}
