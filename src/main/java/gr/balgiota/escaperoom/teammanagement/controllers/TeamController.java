package gr.balgiota.escaperoom.teammanagement.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gr.balgiota.escaperoom.teammanagement.dtos.TeamAgeAverageDTO;
import gr.balgiota.escaperoom.teammanagement.services.TeamProcessor;

@RestController
public class TeamController {

	private TeamProcessor teamProcessor;

	public TeamController(TeamProcessor teamProcessor) {
		this.teamProcessor = teamProcessor;
	}

	@GetMapping(path = "/getActiveTeamsUsersAVG", produces = "application/json")
	public @ResponseBody ResponseEntity<List<TeamAgeAverageDTO>> getActiveTeamsUsersAVG() {

		List<TeamAgeAverageDTO> teamsAgeAverageDTO = teamProcessor.getActiveTeamsUsersAVG();

		return new ResponseEntity<>(teamsAgeAverageDTO, HttpStatus.OK);
	}

}
