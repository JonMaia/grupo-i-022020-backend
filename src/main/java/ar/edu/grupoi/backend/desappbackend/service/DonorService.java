package ar.edu.grupoi.backend.desappbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.dto.DtoDonation;
import ar.edu.grupoi.backend.desappbackend.dto.DtoDonor;
import ar.edu.grupoi.backend.desappbackend.model.project.Donation;
import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.repositories.DonationRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.DonorRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.LocationRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.ProjectRepository;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ExistingUser;

@Service
public class DonorService {

	@Autowired
	private DonorRepository donorRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private DonationRepository donationRepository;

	@Autowired
	private LocationRepository locationRepository;

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

	public DtoDonation donate(DtoDonation dtoDonation) {
		Donor donor = donorRepository.findById(dtoDonation.getIdDonor()).get();
		Project project = projectRepository.findById(dtoDonation.getIdProject()).get();
		Donation donation = donor.donate(project, dtoDonation.getAmount(), dtoDonation.getComment());
		donationRepository.save(donation);

		dtoDonation.setId(donation.getId());
		dtoDonation.setNameProject(project.getName());
		dtoDonation.setPoints(donation.getPoints());
		return dtoDonation;
	}

	public List<Project> findAllProjects() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	public List<Location> findAllLocations() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}

	public DtoDonor donorId(Integer id) {
		Donor donor = donorRepository.findById(id).get();
		Integer sum = donationRepository.sumPoints(donor.getNickname());
		Integer bonus = donationRepository.bonusProjects(donor.getNickname()).size();

		if (sum == null) {
			sum = 0;
		}

		DtoDonor newDonor = new DtoDonor();
		newDonor.setId(id);
		newDonor.setName(donor.getName());
		newDonor.setNickname(donor.getNickname());
		newDonor.setMail(donor.getMail());
		newDonor.setPassword(donor.getPassword());
		newDonor.setPoints(sum + bonus * 500);

		return newDonor;
	}
}
