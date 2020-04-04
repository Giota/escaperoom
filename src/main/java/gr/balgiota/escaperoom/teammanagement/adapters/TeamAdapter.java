package gr.balgiota.escaperoom.teammanagement.adapters;

import org.springframework.stereotype.Component;

import gr.balgiota.escaperoom.teammanagement.dtos.TeamDTO;
import gr.balgiota.escaperoom.teammanagement.entities.Team;

@Component
public class TeamAdapter {
	
	
	public TeamDTO fromEntityToDTO(Team team)
	{
		TeamDTO teamDTO = new TeamDTO();
		
		teamDTO.setTeamId(team.getTeamId());
		teamDTO.setTeamName(team.getTeamName());
		teamDTO.setDateOfPlay(team.getDateOfPlay());
		teamDTO.setNumOfPlayers(team.getNumOfPlayers());
		teamDTO.setTimeToPlay(team.getTimeToPlay());
		teamDTO.setStatus(team.getStatus());
		teamDTO.setScore(team.getScore());
		teamDTO.setTimeOfActivation(team.getTimeOfActivation());
		
		return teamDTO;
	}
	
	
	public Team  fromEntityToDTO(TeamDTO teamDTO)
	{
		Team team = new Team();
		
		team.setTeamId(teamDTO.getTeamId());
		team.setTeamName(teamDTO.getTeamName());
		team.setDateOfPlay(teamDTO.getDateOfPlay());
		team.setNumOfPlayers(teamDTO.getNumOfPlayers());
		team.setTimeToPlay(teamDTO.getTimeToPlay());
		team.setStatus(teamDTO.getStatus());
		team.setScore(teamDTO.getScore());
		team.setTimeOfActivation(teamDTO.getTimeOfActivation());
		
		return team;
	}

}
