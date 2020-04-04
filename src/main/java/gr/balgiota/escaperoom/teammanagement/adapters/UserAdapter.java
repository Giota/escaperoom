package gr.balgiota.escaperoom.teammanagement.adapters;

import org.springframework.stereotype.Component;

import gr.balgiota.escaperoom.teammanagement.dtos.UserDTO;
import gr.balgiota.escaperoom.teammanagement.entities.User;

@Component
public class UserAdapter {
	
	public UserDTO fromEntityToDTO(User user)
	{
		UserDTO userDTO = new UserDTO();
			
		userDTO.setId(user.getId());
		userDTO.setUserId(user.getUserId());
		userDTO.setTeamId(user.getTeamId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setNickName(user.getNickName());
		userDTO.setEmail(user.getEmail());
		userDTO.setAge(user.getAge());
		userDTO.setPicture(user.getPicture());
		
		return userDTO;
		
	}
	
	
	public User fromDTOToEntity(UserDTO userDTO)
	{
		User user = new User();
		
		user.setId(userDTO.getId());
		user.setUserId(userDTO.getUserId());
		user.setTeamId(userDTO.getTeamId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setNickName(userDTO.getNickName());
		user.setEmail(userDTO.getEmail());
		user.setAge(userDTO.getAge());
		user.setPicture(userDTO.getPicture());
		
		return user;
	}

}
