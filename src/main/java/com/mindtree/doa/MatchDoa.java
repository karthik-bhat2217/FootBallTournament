package com.mindtree.doa;

import java.util.List;

import com.mindtree.entity.Match;
import com.mindtree.exception.DoaException;
import com.mindtree.exception.FootballTournamentException;

public interface MatchDoa {
	public boolean addMatch(Match match) throws FootballTournamentException;
	public List<Match> getTeamMAtchesDetail(String teamName) throws DoaException;
	

}
