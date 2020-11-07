package ar.edu.grupoi.backend.desappbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.grupoi.backend.desappbackend.model.project.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer>{

	@Query(value = "SELECT SUM(d.amount) "
	            + "FROM donation d "
	            + "WHERE d.nickname = ?1",
	            nativeQuery = true)
	Integer sumPoints(String nickname);

	@Query(value = "SELECT COUNT(d.date) FROM donation d "
			+"WHERE d.nickname = ?1 GROUP BY "
			+"MONTH(d.date), "
			+"YEAR (d.date)  "
			+"HAVING COUNT(d.date) > 1",
            nativeQuery = true)
	List<Integer> bonusProjects(String nickname);

	@Query(value = "SELECT d.* FROM donation d "
			+"WHERE d.nickname = ?1",
            nativeQuery = true)
	List<Donation> findByNicknameDonor(String nickname);

}
