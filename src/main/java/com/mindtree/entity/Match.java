package com.mindtree.entity;

import java.sql.Timestamp;

public class Match implements Comparable<Match> {
	private int matchID;
	private Timestamp date;
	private String firstTeamName;
	private String secondTeamName;
	private int firstTeamGoals;
	private int secondTeamGoals;

	public Match() {
		// TODO Auto-generated constructor stub
	}

	public Match(int matchID, Timestamp date, String firstTeamName, String secondTeamName, int firstTeamGoals,
			int secondTeamGoals) {
		super();
		this.matchID = matchID;
		this.date = date;
		this.firstTeamName = firstTeamName;
		this.secondTeamName = secondTeamName;
		this.firstTeamGoals = firstTeamGoals;
		this.secondTeamGoals = secondTeamGoals;
	}

	/**
	 * @return the matchID
	 */
	public int getMatchID() {
		return matchID;
	}

	/**
	 * @param matchID the matchID to set
	 */
	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}

	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}

	/**
	 * @return the firstTeamName
	 */
	public String getFirstTeamName() {
		return firstTeamName;
	}

	/**
	 * @param firstTeamName the firstTeamName to set
	 */
	public void setFirstTeamName(String firstTeamName) {
		this.firstTeamName = firstTeamName;
	}

	/**
	 * @return the secondTeamName
	 */
	public String getSecondTeamName() {
		return secondTeamName;
	}

	/**
	 * @param secondTeamName the secondTeamName to set
	 */
	public void setSecondTeamName(String secondTeamName) {
		this.secondTeamName = secondTeamName;
	}

	/**
	 * @return the firstTeamGoals
	 */
	public int getFirstTeamGoals() {
		return firstTeamGoals;
	}

	/**
	 * @param firstTeamGoals the firstTeamGoals to set
	 */
	public void setFirstTeamGoals(int firstTeamGoals) {
		this.firstTeamGoals = firstTeamGoals;
	}

	/**
	 * @return the secondTeamGoals
	 */
	public int getSecondTeamGoals() {
		return secondTeamGoals;
	}

	/**
	 * @param secondTeamGoals the secondTeamGoals to set
	 */
	public void setSecondTeamGoals(int secondTeamGoals) {
		this.secondTeamGoals = secondTeamGoals;
	}

	public int compareTo(Match o) {
		// TODO Auto-generated method stub
		int fisrt =o.getFirstTeamGoals() - o.getSecondTeamGoals();
		int second=this.getFirstTeamGoals() - this.getSecondTeamGoals();
		
		return second-fisrt;
	}

}
