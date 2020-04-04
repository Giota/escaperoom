package gr.balgiota.escaperoom.teammanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.balgiota.escaperoom.teammanagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<List<User>> findUsersByUserId(String userId);

	Optional<List<User>> findUsersByTeamId(String teamId);

}
