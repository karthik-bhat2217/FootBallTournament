package com.mindtree.service;

import java.util.Scanner;

import com.mindtree.exception.FootballTournamentException;
import com.mindtree.exception.TeamNotFoundException;

public interface FootballMatchManager {
	public void displayTeamMatches(String teamName) throws TeamNotFoundException;
	public void addMatch(Scanner s) throws FootballTournamentException;

}
