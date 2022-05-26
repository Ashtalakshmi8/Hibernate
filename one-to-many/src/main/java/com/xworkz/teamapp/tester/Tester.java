package com.xworkz.teamapp.tester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.teamapp.dao.TeamDao;
import com.xworkz.teamapp.entity.PlayerEntity;
import com.xworkz.teamapp.entity.TeamEntity;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamEntity team = new TeamEntity();
		team.setTeamName("Bangalore");

		PlayerEntity player = new PlayerEntity();
		player.setPlayerName("sachin");
		player.setTeam(team);

		PlayerEntity player1 = new PlayerEntity();
		player1.setPlayerName("maahi");
		player1.setTeam(team);

		List<PlayerEntity> players = new ArrayList();
		players.add(player);
		players.add(player1);

		team.setPlayer(players);

		TeamDao dao = new TeamDao();
		dao.saveTeam(team);

	}

}
