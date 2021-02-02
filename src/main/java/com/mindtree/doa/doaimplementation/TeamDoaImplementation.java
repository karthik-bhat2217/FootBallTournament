package com.mindtree.doa.doaimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.doa.TeamDoa;
import com.mindtree.entity.Team;
import com.mindtree.exception.ConnectionUtilityException;
import com.mindtree.exception.DoaException;
import com.mindtree.utility.ConnectionUtility;

public class TeamDoaImplementation implements TeamDoa {

	ConnectionUtility utility = new ConnectionUtility();
	List<Team> teams = new ArrayList<Team>();

	public List<Team> getTeamDetails() throws DoaException {
		try {

			Connection conn = utility.getConnection();
			String query = "select * from teams";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rst = preparedStatement.executeQuery();
			while (rst.next()) {
				Team team = new Team(rst.getString(1), rst.getString(2));
				teams.add(team);

			}

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			System.out.println(e);
			throw new DoaException("error in inserting values");
		}
		return teams;

	}
}
