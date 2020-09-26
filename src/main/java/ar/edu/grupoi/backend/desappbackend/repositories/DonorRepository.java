package ar.edu.grupoi.backend.desappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

public interface DonorRepository extends JpaRepository<Donor, Integer>{

	Donor findByMail(String mail);

}
