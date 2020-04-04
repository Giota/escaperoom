package gr.balgiota.escaperoom.teammanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gr.balgiota.escaperoom.teammanagement.entities.Team;
import gr.balgiota.escaperoom.teammanagement.repositories.TeamRepository;

@Service
public class TeamService {

	private TeamRepository teamRepository;

	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	public Optional<Team> getActiveTeamByTeamId(Long teamId) {
		return teamRepository.findTeamByTeamIdAndStatus(teamId, "active");
	}

	public Optional<List<Team>> getActiveTeams() {
		return teamRepository.findTeamByStatus("active");
	}

}
