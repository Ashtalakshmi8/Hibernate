package com.xworkz.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity

@Table(name = "cloth")

public class Cloth {
	@Id
	@Column(name = "Cloth_Id")
	private int id;
	private String brand;
	private double price;
	@CreationTimestamp
	private Date manufacturedyYear;
}
