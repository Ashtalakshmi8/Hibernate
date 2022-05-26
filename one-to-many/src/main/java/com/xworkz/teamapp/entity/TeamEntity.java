package com.xworkz.teamapp.entity;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "team")
public class TeamEntity {

	@Id
	@Column(name = "team_id")
	@GenericGenerator(name = "pk_value", strategy = "increment")
	@GeneratedValue(generator = "pk_value")
	private int teamId;
	@Column(name = "team_name")
	private String teamName;
	@OneToMany(mappedBy = "team",cascade =CascadeType.ALL)
	private List<PlayerEntity> player;

}
