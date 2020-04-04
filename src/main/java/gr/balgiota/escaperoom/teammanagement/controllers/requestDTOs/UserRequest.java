package gr.balgiota.escaperoom.teammanagement.controllers.requestDTOs;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("user_id")
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
