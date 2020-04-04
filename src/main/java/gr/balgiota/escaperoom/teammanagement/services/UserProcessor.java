package gr.balgiota.escaperoom.teammanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import gr.balgiota.escaperoom.teammanagement.adapters.TeamAdapter;
import gr.balgiota.escaperoom.teammanagement.adapters.UserAdapter;
import gr.balgiota.escaperoom.teammanagement.dtos.AgeAverageDTO;
import gr.balgiota.escaperoom.teammanagement.dtos.TeamDTO;
import gr.balgiota.escaperoom.teammanagement.dtos.UserDTO;
import gr.balgiota.escaperoom.teammanagement.entities.Team;
import gr.balgiota.escaperoom.teammanagement.entities.User;
import gr.balgiota.escaperoom.teammanagement.exceptions.UserNotFoundException;
import gr.balgiota.escaperoom.teammanagement.utils.Utils;

@Service
public class UserProcessor {

	private UserService userService;
	private UserAdapter userAdapter;
	private TeamService teamService;
	private TeamAdapter teamAdapter;

	public UserProcessor(UserService userService, UserAdapter userAdapter, TeamService teamService,
			TeamAdapter teamAdapter) {
		this.userService = userService;
		this.userAdapter = userAdapter;
		this.teamService = teamService;
		this.teamAdapter = teamAdapter;
	}

	public List<UserDTO> getUserById(String userId) throws UserNotFoundException {
		Optional<List<User>> userOptional = userService.getUsersByUserId(userId);

		if (userOptional.isPresent()) {
			return userOptional.get().stream().map(u -> userAdapter.fromEntityToDTO(u)).collect(Collectors.toList());

		} else {
			throw new UserNotFoundException("User with id = " + userId + " not found!");
		}

	}

	public List<TeamDTO> getCoPlayersByUserId(String userId) throws UserNotFoundException {
		List<TeamDTO> teamsDTO = new ArrayList<>();
		List<UserDTO> usersDTO = getUserById(userId);

		for (UserDTO userDTO : usersDTO) {
			if (Utils.isLong(userDTO.getTeamId())) {
				Optional<Team> teamOptional = teamService.getActiveTeamByTeamId(Long.valueOf(userDTO.getTeamId()));

				if (teamOptional.isPresent()) {
					Team team = teamOptional.get();

					Optional<List<User>> userOptional = userService.getUsersByTeamId(String.valueOf(team.getTeamId()));

					if (userOptional.isPresent()) {

						List<UserDTO> teamUsersDTO = userOptional.get().stream()
								.filter(u -> !u.getUserId().equalsIgnoreCase(userId)) // exclude current user
								.map(u -> userAdapter.fromEntityToDTO(u)).collect(Collectors.toList());

						TeamDTO teamDTO = teamAdapter.fromEntityToDTO(team);
						teamDTO.setUsersDTO(teamUsersDTO);

						teamsDTO.add(teamDTO);

					}

				}

			}
		}

		return teamsDTO;

	}

	public AgeAverageDTO getAllUsersAgeAverage() {
		return getUsersAgeAverage(userService.getAllUsers());
	}

	public AgeAverageDTO getUsersAgeAverage(List<User> users) {
		AgeAverageDTO averageDTO = new AgeAverageDTO();

		if (!Utils.isNullOrEmpty(users)) {
			users.forEach(u -> {

				if (u.getAge() == null) {
					averageDTO.incrementNumOfUsersWithNullAge();
				} else if (!Utils.isDouble(u.getAge())) {
					averageDTO.incrementNumOfUsersWithNonNumericAge();
				} else {
					averageDTO.addAgeToSum(Double.parseDouble(u.getAge()));
					averageDTO.incrementNumOfUsersWithValidAge();

				}

			});

			averageDTO.calculateAgeAverage();
		}

		return averageDTO;
	}

}
