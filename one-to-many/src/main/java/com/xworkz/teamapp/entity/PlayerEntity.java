package com.xworkz.teamapp.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "player")
public class PlayerEntity {

	@Id
	@Column(name = "player_id")
	@GenericGenerator(name = "pk_value", strategy = "increment")
	@GeneratedValue(generator = "pk_value")
	private int playerId;
	@Column(name = "player_name")
	private String playerName;
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH})
	private TeamEntity team;

}
