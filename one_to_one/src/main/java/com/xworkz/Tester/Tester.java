package com.xworkz.Tester;

import java.math.BigDecimal;

import com.xworkz.dao.OneTODaoImpl;
import com.xworkz.dao.OneTOOneDao;
import com.xworkz.one_to_one_entity.CountryEntity;
import com.xworkz.one_to_one_entity.PresidentEntity;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountryEntity countryEntity = new CountryEntity();
		// countryEntity.setCountryId(10);
		countryEntity.setName("ukre");
		countryEntity.setNoOfStates(48);
		PresidentEntity presidentEntity = new PresidentEntity();
		presidentEntity.setPresidentName("akshu");
		presidentEntity.setSalary(new BigDecimal(23456789.12334));
		presidentEntity.setAge(56);
		presidentEntity.setCountyEntity(countryEntity);
		OneTOOneDao dao = new OneTODaoImpl();
		dao.saveData(countryEntity, presidentEntity);

	}

}
