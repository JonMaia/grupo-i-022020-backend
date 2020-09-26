package ar.edu.grupoi.backend.desappbackend.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.repositories.DonorRepository;

@Service
public class DonorService {

	@Autowired
	private DonorRepository donorRepository;
	
	public void create(Donor donor) {
		donorRepository.save(donor);
	}

	public Donor login(String mail) {
		return donorRepository.findByMail(mail);
	}

	public List<Donor> findAll() {
		// TODO Auto-generated method stub
		return donorRepository.findAll();
	}
	
	
}
