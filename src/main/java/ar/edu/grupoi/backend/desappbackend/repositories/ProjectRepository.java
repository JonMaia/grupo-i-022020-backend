package ar.edu.grupoi.backend.desappbackend.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.grupoi.backend.desappbackend.model.project.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	List<Project> findAllByActive(boolean b);

	@Query(value = "SELECT p.* FROM project p "
			+ "WHERE DAY(p.end_date) >= DAY(?1) "
			+ "AND MONTH(p.end_date) = MONTH(?1)" 
			+ "AND YEAR(p.end_date) = YEAR(?1) "
			+ "ORDER BY DAY(p.end_date) ASC", 
			nativeQuery = true)
	List<Project> findAllByEndDate(LocalDate localDate);

	@Query(value = "SELECT p.* FROM project p "
			+ "INNER JOIN donation d "
			+ "ON d.project_id = p.id " 
			+ "GROUP BY p.id, d.amount "
			+ "ORDER BY d.amount desc "
			+ "FETCH FIRST 10 ROWS ONLY",
			nativeQuery = true)
	List<Project> top10();

	@Query(value = "SELECT COUNT(*) FROM project p "
			+ "INNER JOIN donation d "
			+ "ON d.project_id = p.id AND p.id = ?1",
			nativeQuery = true)
	Integer cantDonations(Integer id);
}
