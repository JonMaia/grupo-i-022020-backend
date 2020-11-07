package ar.edu.grupoi.backend.desappbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

	@Query(value = "SELECT DISTINCT l.* FROM location l "
			+ "INNER JOIN (SELECT p.location_id as lid "
			+ "FROM project p LEFT JOIN	donation d "
			+ "ON p.id = d.project_id ORDER BY "
			+ "p.collection = 0 desc, "
			+ "MONTH(d.date), "
			+ "YEAR(d.date), "
			+ "DAY(d.date) asc) pd "
			+ "ON pd.lid = l.id ",
			nativeQuery = true)
	List<Location> top10();

}
