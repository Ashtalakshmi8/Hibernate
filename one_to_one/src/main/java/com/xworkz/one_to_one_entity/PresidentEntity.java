package com.xworkz.one_to_one_entity;

import java.math.BigDecimal;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "president")
public class PresidentEntity {
	@Id

	@Column(name = "president_id")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int presidentId;
	@Column(name = "president_name")
	private String presidentName;
	private BigDecimal salary;
	private double age;
	@OneToOne // java side
	@JoinColumn(name = "c_id")
	private CountryEntity countyEntity;

}
