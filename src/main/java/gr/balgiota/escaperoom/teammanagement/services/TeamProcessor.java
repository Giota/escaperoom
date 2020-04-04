package gr.balgiota.escaperoom.teammanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gr.balgiota.escaperoom.teammanagement.dtos.AgeAverageDTO;
import gr.balgiota.escaperoom.teammanagement.dtos.TeamAgeAverageDTO;
import gr.balgiota.escaperoom.teammanagement.entities.Team;
import gr.balgiota.escaperoom.teammanagement.entities.User;

@Service
public class TeamProcessor {

	private UserService userService;
	private UserProcessor userProcessor;
	private TeamService teamService;

	public TeamProcessor(UserService userService, UserProcessor userProcessor, TeamService teamService) {
		this.userService = userService;
		this.userProcessor = userProcessor;
		this.teamService = teamService;

	}

	public List<TeamAgeAverageDTO> getActiveTeamsUsersAVG() {

		List<TeamAgeAverageDTO> teamsAgeAverageDTO = new ArrayList<>();

		Optional<List<Team>> teamsOptional = teamService.getActiveTeams();

		if (teamsOptional.isPresent()) {

			List<Team> teams = teamsOptional.get();

			teams.forEach(t -> {

				TeamAgeAverageDTO teamAgeAverageDTO = new TeamAgeAverageDTO();

				teamAgeAverageDTO.setTeamId(t.getTeamId());
				teamAgeAverageDTO.setTeamName(t.getTeamName());

				Optional<List<User>> usersOptional = userService.getUsersByTeamId(String.valueOf(t.getTeamId()));

				if (usersOptional.isPresent()) {
					List<User> users = usersOptional.get();

					AgeAverageDTO ageAverageDTO = userProcessor.getUsersAgeAverage(users);
					teamAgeAverageDTO.setAgeAverageDTO(ageAverageDTO);

				}

				teamsAgeAverageDTO.add(teamAgeAverageDTO);

			});

		}

		return teamsAgeAverageDTO;

	}

}
