package com.xworkz.tv.DAO;

import java.util.List;

import com.xworkz.entity.TvChannel;

public interface TvChannelDAO {
	public void saveChnnel(TvChannel tvchannel);

	public TvChannel getChannelById(Integer tvchannel);

	public TvChannel update(double Price, Integer channelId);

	public TvChannel remove(String name, Integer ChannelId);

	public String getChannelNameById(Integer channelId);

	// public TvChannel updatepriceById(Integer channelId);
	public TvChannel getChannelByName(String channelName);

	public List<TvChannel> findAll();
}
