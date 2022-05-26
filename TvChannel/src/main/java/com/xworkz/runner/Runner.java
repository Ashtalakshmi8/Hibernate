package com.xworkz.runner;

import java.util.List;

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
//
//		System.out.println(tv.getChannelById(8));
//		System.out.println("running");
//
//		tv.update(19.258, 1);
//		System.out.println("updated");
//		tv.remove("udaya", 2);
//		System.out.println("removed");
// By using query fetching only data  
//		String result = tv.getChannelNameById(3);
//		System.out.println("channelName is:" + result);

		// fetching all data from row //
		TvChannel channel = tv.getChannelByName("hero");
		if (channel != null) {
			System.out.println(channel.getChannel_id());
			System.out.println(channel.getChannelName());
			System.out.println(channel.getLanguage());
			System.out.println(channel.getPrice());
			System.out.println(channel.isFree());
		} else {
			System.out.println("No channel data found");

		}
		List<TvChannel> channel1 = tv.findAll();
		for (TvChannel TvChannel2 : channel1) {
			System.out.println(TvChannel2.getChannel_id());
			System.out.println(TvChannel2.getChannelName());
			System.out.println(TvChannel2.getLanguage());
			System.out.println(TvChannel2.getPrice());
			System.out.println(TvChannel2.isFree());

		}

	}
}
