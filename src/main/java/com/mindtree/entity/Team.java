package com.mindtree.entity;

public class Team {
	private String teamName;
	private String teamCity;

	public Team() {

	}

	public Team(String teamName, String teamCity) {
		super();
		this.teamName = teamName;
		this.teamCity = teamCity;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the teamCity
	 */
	public String getTeamCity() {
		return teamCity;
	}

	/**
	 * @param teamCity the teamCity to set
	 */
	public void setTeamCity(String teamCity) {
		this.teamCity = teamCity;
	}

}
