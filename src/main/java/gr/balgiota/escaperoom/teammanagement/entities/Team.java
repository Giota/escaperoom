package gr.balgiota.escaperoom.teammanagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "teams")
public class Team implements Serializable {

	private static final long serialVersionUID = -7167773865196709816L;

	@Id
	@Column(name = "team_id")
	private long teamId;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "dateofplay")
	@Temporal(TemporalType.DATE)
	private Date dateOfPlay;

	@Column(name = "numofplayers")
	private int numOfPlayers;

	@Column(name = "timetoplay")
	private double timeToPlay;

	@Column(name = "status")
	private String status;

	@Column(name = "score")
	private int score;

	@Column(name = "timeofactivation")
	@Temporal(TemporalType.TIME)
	private Date timeOfActivation;

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
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

}
