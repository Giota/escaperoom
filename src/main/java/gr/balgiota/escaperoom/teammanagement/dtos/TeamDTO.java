package gr.balgiota.escaperoom.teammanagement.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TeamDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long teamId;

	private String teamName;

	private Date dateOfPlay;

	private int numOfPlayers;

	private double timeToPlay;

	private String status;

	private int score;

	private Date timeOfActivation;

	private List<UserDTO> usersDTO;

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long l) {
		this.teamId = l;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Date getDateOfPlay() {
		return dateOfPlay;
	}

	public void setDateOfPlay(Date dateOfPlay) {
		this.dateOfPlay = dateOfPlay;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public double getTimeToPlay() {
		return timeToPlay;
	}

	public void setTimeToPlay(double timeToPlay) {
		this.timeToPlay = timeToPlay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getTimeOfActivation() {
		return timeOfActivation;
	}

	public void setTimeOfActivation(Date timeOfActivation) {
		this.timeOfActivation = timeOfActivation;
	}

	public List<UserDTO> getUsersDTO() {
		return usersDTO;
	}

	public void setUsersDTO(List<UserDTO> usersDTO) {
		this.usersDTO = usersDTO;
	}

}
