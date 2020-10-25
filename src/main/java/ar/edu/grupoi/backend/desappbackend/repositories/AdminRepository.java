package ar.edu.grupoi.backend.desappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.grupoi.backend.desappbackend.model.user.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByMail(String mail);

}
