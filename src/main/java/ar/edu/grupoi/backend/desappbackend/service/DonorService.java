package ar.edu.grupoi.backend.desappbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.repositories.DonorRepository;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ExistingUser;

@Service
public class DonorService {

	@Autowired
	private DonorRepository donorRepository;

	public Donor create(Donor donor) throws ExistingUser {
		Donor donorFind = donorRepository.findByMail(donor.getMail());
		if (!(donorFind == null)) {
			throw new ExistingUser();
		}
		return donorRepository.save(donor);
	}

	public Donor login(String mail, String password) throws ErrorLogin {
		try {
			Donor donorLogin = donorRepository.findByMail(mail);
			if (!(donorLogin.getPassword().equals(password))) {
				throw new ErrorLogin();
			}
			return donorLogin;
		} catch (Exception e) {
			throw new ErrorLogin();
		}
	}

}
