package gr.balgiota.escaperoom.teammanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gr.balgiota.escaperoom.teammanagement.entities.User;
import gr.balgiota.escaperoom.teammanagement.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<List<User>> getUsersByUserId(String userId) {
		return userRepository.findUsersByUserId(userId);
	}

	public Optional<List<User>> getUsersByTeamId(String teamId) {
		return userRepository.findUsersByTeamId(teamId);
	}

	public Optional<List<User>> getCoPlayersByUserId(String userId) {
		return getUsersByUserId(userId);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
