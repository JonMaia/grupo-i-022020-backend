package ar.edu.grupoi.backend.desappbackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

public interface DonorRepository extends JpaRepository<Donor, Integer>{

	Donor findByMail(String mail);

	@Query(value = "SELECT DISTINCT don.* FROM donor don "
			+"INNER JOIN (SELECT d.nickname FROM donation d "
			+"INNER JOIN project p ON d.project_id = ?1) dp " 
			+"ON don.nickname = dp.nickname;",
			nativeQuery = true)
	List<Donor> findDonors(Integer projectId);

}
