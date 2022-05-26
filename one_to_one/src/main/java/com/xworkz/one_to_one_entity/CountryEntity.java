package com.xworkz.one_to_one_entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "country")
public class CountryEntity {
	@Id

	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")//generate the primary key automatically/
	@Column(name = "country_id")
	private int countryId;
	private String name;
	private int noOfStates;

}
