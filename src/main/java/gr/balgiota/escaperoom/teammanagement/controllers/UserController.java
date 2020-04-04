package gr.balgiota.escaperoom.teammanagement.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import gr.balgiota.escaperoom.teammanagement.controllers.requestDTOs.UserRequest;
import gr.balgiota.escaperoom.teammanagement.dtos.AgeAverageDTO;
import gr.balgiota.escaperoom.teammanagement.dtos.TeamDTO;
import gr.balgiota.escaperoom.teammanagement.dtos.UserDTO;
import gr.balgiota.escaperoom.teammanagement.exceptions.UserNotFoundException;
import gr.balgiota.escaperoom.teammanagement.services.UserProcessor;

@RestController
public class UserController {

	private UserProcessor userProcessor;

	public UserController(UserProcessor userProcessor) {
		this.userProcessor = userProcessor;
	}

	@PostMapping(path = "/getUsers", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<List<UserDTO>> getUsers(@RequestBody UserRequest userRequest) {
		try {
			List<UserDTO> usersDTO = userProcessor.getUserById(userRequest.getUserId());

			return new ResponseEntity<>(usersDTO, HttpStatus.OK);

		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@PostMapping(path = "/getCoPlayers", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<List<TeamDTO>> getCoPlayers(@RequestBody UserRequest userRequest) {
		try {
			List<TeamDTO> teamsDTO = userProcessor.getCoPlayersByUserId(userRequest.getUserId());

			return new ResponseEntity<>(teamsDTO, HttpStatus.OK);

		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@GetMapping(path = "/getUsersAgeAverage", produces = "application/json")
	public @ResponseBody ResponseEntity<AgeAverageDTO> getUsersAgeAverage() {

		AgeAverageDTO ageAverageDTO = userProcessor.getAllUsersAgeAverage();

		return new ResponseEntity<>(ageAverageDTO, HttpStatus.OK);
	}

}
