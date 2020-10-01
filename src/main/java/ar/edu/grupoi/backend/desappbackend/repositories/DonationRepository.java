package ar.edu.grupoi.backend.desappbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.grupoi.backend.desappbackend.model.project.Donation;

public interface DonationRepository extends JpaRepository<Donation, Integer>{

	@Query(value = "SELECT SUM(d.amount) "
	            + "FROM donation d "
	            + "WHERE d.nickname = ?1",
	            nativeQuery = true)
	Integer sumPoints(String nickname);

	/*	@Query(value = "SELECT * FROM " 
			+"(SELECT COUNT(d.date) FROM donation d "
			+"WHERE d.nickname = ?1 GROUP BY "
			+"MONTH(d.date), "
			+"YEAR (d.date)) f "
			+"WHERE f.COUNT > 1;",*/

	@Query(value = "SELECT COUNT(d.date) FROM donation d "
			+"WHERE d.nickname = ?1 GROUP BY "
			+"MONTH(d.date), "
			+"YEAR (d.date)  "
			+"having COUNT(d.date) > 1;",
            nativeQuery = true)
	List<Integer> bonusProjects(String nickname);

}
