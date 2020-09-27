package ar.edu.grupoi.backend.desappbackend.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.grupoi.backend.desappbackend.DesappBackendApplicationTests;
import ar.edu.grupoi.backend.desappbackend.builder.DonorBuilder;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;


public class DonorServiceTest extends DesappBackendApplicationTests {

	@Autowired
	private DonorService donorService;
	
	@Test
	public void whenADonorPersistsShouldFindAll1Donor() {
		Donor aDonor = DonorBuilder.whitName("Nico").build(em);
		
		List<Donor> donors = donorService.findAll();
		
		assertThat(donors.size()).isEqualTo(1);
		assertThat(donors.get(0).getName()).isEqualTo("Nico");
		assertThat(donors.get(0).getId()).isEqualTo(1);
	}
	
	@Test
	public void aDonorPersistsShouldValiedWhenGettersValuesMatch() {
		Donor aDonor = DonorBuilder.whitName("Nico").build(em);
		
		Donor donor = donorService.login("cris@mail.com");
		
		assertThat(donor.getName()).isEqualTo("Nico");
		assertThat(donor.getMail()).isEqualTo("cris@mail.com");
		assertThat(donor.getPassword()).isEqualTo("pas123");
		assertThat(donor.getNickname()).isEqualTo("cris");
	}
	
	@Test
	public void aDonorPersistsWithValueDiferentShouldValiedWhenGettersValuesMatch() {
		Donor aDonor = DonorBuilder.whitName("Nico").whitMail("nico@mail.com").whitPassword("nico123").withNickname("Nick").build(em);
		
		Donor donor = donorService.login("nico@mail.com");
		
		assertThat(donor.getName()).isEqualTo("Nico");
		assertThat(donor.getMail()).isEqualTo("nico@mail.com");
		assertThat(donor.getPassword()).isEqualTo("nico123");
		assertThat(donor.getNickname()).isEqualTo("Nick");
	}
	
}
