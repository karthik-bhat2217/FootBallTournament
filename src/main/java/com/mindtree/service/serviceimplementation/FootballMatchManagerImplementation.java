package com.mindtree.service.serviceimplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.mindtree.doa.MatchDoa;
import com.mindtree.doa.TeamDoa;
import com.mindtree.doa.doaimplementation.MatchDoaImplementation;
import com.mindtree.doa.doaimplementation.TeamDoaImplementation;
import com.mindtree.entity.Match;
import com.mindtree.entity.Team;
import com.mindtree.exception.FootballTournamentException;
import com.mindtree.exception.ServiceLayerException;
import com.mindtree.exception.TeamNotFoundException;
import com.mindtree.utility.InputReader;

public class FootballMatchManagerImplementation {

	TeamDoa tdoa = new TeamDoaImplementation();
	MatchDoa mdoa = new MatchDoaImplementation();
	List<Team> teams = new ArrayList<Team>();

	private void displayTeams() throws ServiceLayerException {

		try {
			teams = tdoa.getTeamDetails();
			display(teams);
		} catch (Exception e) {
			
			throw new ServiceLayerException(e);
		}
	}

	private void display(List<Team> teams2) {
		
		for (Team team : teams) {
			System.out.print(team.getTeamName() + " :");
			System.out.print(team.getTeamCity());
			System.out.println();
		}
		System.out.println("------------------");
	}

	public void addMatch(Scanner s) throws FootballTournamentException {
		// TODO Auto-generated method stub
		displayTeams();
		InputReader reader = new InputReader(s);
		Match match = reader.readMatchDetails();

		try {
			mdoa.addMatch(match);
		} catch (ServiceLayerException e) {
			// TODO Auto-generated catch block
			throw new FootballTournamentException(e);
		}

	}

	public void displayTeamMatches(String teamName) throws TeamNotFoundException {
		List<Match> matches = new ArrayList<Match>();
		List<Match> matches3 = new ArrayList<Match>();
		Map<Integer, Match> matches2 = new HashMap<Integer, Match>();
		try {
			matches = mdoa.getTeamMAtchesDetail(teamName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Match match : matches) {
			matches2.put(match.getMatchID(), match);
		}
		for (int id : matches2.keySet()) {
			matches3.add(matches2.get(id));
		}
		Collections.sort(matches3);
		if (matches3.size() == 0) {

			throw new TeamNotFoundException("Team not found");

		}

		DisplayMatches(matches3, teamName);
	}

	private void DisplayMatches(List<Match> matches, String teamName) {

		System.out.println("Match id       match date                Oposition      Goals");
		// TODO Auto-generated method stub
		for (Match match : matches) {
			System.out.print(match.getMatchID() + "           ");
			System.out.print(match.getDate() + "        ");

			if (match.getFirstTeamName().equalsIgnoreCase(teamName)) {
				System.out.print(match.getSecondTeamName() + "           ");
				System.out.print(match.getFirstTeamGoals() + ":");
				System.out.print(match.getSecondTeamGoals());
			} else {
				System.out.print(match.getFirstTeamName() + "           ");
				System.out.print(match.getSecondTeamGoals() + ":");
				System.out.print(match.getFirstTeamGoals());

			}
			System.out.println();
			System.out.println("--------------------------------");

		}

	}

}
