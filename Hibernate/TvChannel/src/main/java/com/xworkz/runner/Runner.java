package com.xworkz.runner;

import com.xworkz.entity.TvChannel;
import com.xworkz.tv.DAO.TvChannelDAO;
import com.xworkz.tv.DAO.TvChannelDAOImpl;

public class Runner {
	public static void main(String[] args) {
		TvChannel chnnelEntity = new TvChannel();
		chnnelEntity.setChannel_id(106);
		chnnelEntity.setChannelName("publicv");
		chnnelEntity.setLanguage("english");
		chnnelEntity.setFree(true);
		chnnelEntity.setPrice(14.59);

		TvChannelDAO tv = new TvChannelDAOImpl();
//		tv.saveChnnel(chnnelEntity);
//
//		System.out.println("saved");

		System.out.println(tv.getChannelById(8));
		System.out.println("running");

		tv.update(19.258, 1);
		System.out.println("updated");
		tv.remove("udaya", 2);
		System.out.println("removed");

	}
}
