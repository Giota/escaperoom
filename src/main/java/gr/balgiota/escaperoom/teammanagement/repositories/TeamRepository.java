package gr.balgiota.escaperoom.teammanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.balgiota.escaperoom.teammanagement.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	Optional<Team> findTeamByTeamIdAndStatus(Long teamId, String status);

	Optional<List<Team>> findTeamByStatus(String string);

}
