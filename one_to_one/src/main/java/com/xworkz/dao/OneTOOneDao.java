package com.xworkz.dao;

import com.xworkz.one_to_one_entity.CountryEntity;


import com.xworkz.one_to_one_entity.PresidentEntity;

public interface OneTOOneDao {
	public void saveData(CountryEntity countyEntity, PresidentEntity entity);
}