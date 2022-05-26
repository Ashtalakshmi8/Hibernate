package com.xworkz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TvChannel")
//if ur using this query den remove  query in Impli class//
@NamedQueries(value = { @NamedQuery(name = "fetchAll", query = "from TvChannel"),
		@NamedQuery(name = "getByName", query = "FROM TvChannel where ChannelName =:name")

})
public class TvChannel {
	@Id
	@Column(name = "Channel_ID")
	private int Channel_id;

	@Column(name = "channelname")

	private String ChannelName;
	private String Language;
	@Column(name = "cost")
	private double Price;

	private boolean isFree;

}
