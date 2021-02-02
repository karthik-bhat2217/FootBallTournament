package com.mindtree.doa;

import java.util.List;

import com.mindtree.entity.Team;
import com.mindtree.exception.DoaException;

public interface TeamDoa {
	public List<Team> getTeamDetails() throws DoaException;

}
