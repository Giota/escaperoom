package gr.balgiota.escaperoom.teammanagement.dtos;

import java.io.Serializable;

public class TeamAgeAverageDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long teamId;

	private String teamName;

	private AgeAverageDTO ageAverageDTO;

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

	public AgeAverageDTO getAgeAverageDTO() {
		return ageAverageDTO;
	}

	public void setAgeAverageDTO(AgeAverageDTO ageAverageDTO) {
		this.ageAverageDTO = ageAverageDTO;
	}

}
