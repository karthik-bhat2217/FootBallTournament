package com.mindtree.doa.doaimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.doa.MatchDoa;
import com.mindtree.entity.Match;
import com.mindtree.exception.ConnectionUtilityException;
import com.mindtree.exception.DoaException;
import com.mindtree.exception.FootballTournamentException;
import com.mindtree.utility.ConnectionUtility;

public class MatchDoaImplementation implements MatchDoa {

	ConnectionUtility utility = new ConnectionUtility();
	Connection conn = null;
	PreparedStatement preparedStatement;
	List<Match> matches = new ArrayList<Match>();

	public boolean addMatch(Match match) throws FootballTournamentException {
		boolean found = false;
		try {
			Connection conn = utility.getConnection();

			String query = "insert into matches values(?,?,?,?,?,?)";

			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, match.getMatchID());
			preparedStatement.setTimestamp(2, match.getDate());
			preparedStatement.setString(3, match.getFirstTeamName());
			preparedStatement.setString(4, match.getSecondTeamName());
			preparedStatement.setInt(5, match.getFirstTeamGoals());
			preparedStatement.setInt(6, match.getSecondTeamGoals());

			found = preparedStatement.execute();

		} catch (ConnectionUtilityException e) {
			throw new FootballTournamentException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}
		try {
			utility.closeConnection(preparedStatement);

			utility.closeConnection(conn);
		} catch (ConnectionUtilityException e) {
			// TODO Auto-generated catch block
			throw new DoaException(e);
		}

		return found;

	}

	public List<Match> getTeamMAtchesDetail(String teamName) throws DoaException {

		try {
			Connection conn = utility.getConnection();
			String query = "select * from matches where ( firstName='" + teamName + "' or secondName= '" + teamName
					+ "');";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet rst = preparedStatement.executeQuery();
			while (rst.next()) {
				Match match = new Match(rst.getInt(1), rst.getTimestamp(2), rst.getString(3), rst.getString(4),
						rst.getInt(5), rst.getInt(6));
				matches.add(match);
			}

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			System.out.println(e);
			throw new DoaException("error in inserting values");
		}
		try {
			utility.closeConnection(preparedStatement);

			utility.closeConnection(conn);
		} catch (ConnectionUtilityException e) {
			// TODO Auto-generated catch block
			throw new DoaException(e);
		}
		return matches;

	}

}
