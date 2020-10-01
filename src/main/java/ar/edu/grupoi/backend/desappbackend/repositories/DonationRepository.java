package ar.edu.grupoi.backend.desappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.grupoi.backend.desappbackend.model.project.Donation;

public interface DonationRepository extends JpaRepository<Donation, Integer>{

}
