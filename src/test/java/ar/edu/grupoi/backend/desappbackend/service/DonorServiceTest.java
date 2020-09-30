package ar.edu.grupoi.backend.desappbackend.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.grupoi.backend.desappbackend.DesappBackendApplicationTests;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ExistingUser;

public class DonorServiceTest extends DesappBackendApplicationTests {

	@Autowired
	private DonorService donorService;

	@Test
	public void aDonorPersistsShouldValiedWhenGettersValuesMatch() throws ErrorLogin {
		Donor donor = donorService.login("cris@mail.com", "cris123");

		assertThat(donor.getName()).isEqualTo("Cristian");
		assertThat(donor.getMail()).isEqualTo("cris@mail.com");
		assertThat(donor.getPassword()).isEqualTo("cris123");
		assertThat(donor.getNickname()).isEqualTo("Cris");
	}

	@Test
	public void loginADonorWithInvalidMailShouldGetErrorLogin() {
		try {
			donorService.login("crist@mail.com", "pas123");
		} catch (ErrorLogin e) {
			assertThat(e.getMessage()).isEqualTo("Incorrect mail or password");
		}
	}

	@Test
	public void loginADonorWithInvalidPasswordShouldGetErrorLogin() {
		try {
			donorService.login("cris@mail.com", "pas1s23");
		} catch (ErrorLogin e) {
			assertThat(e.getMessage()).isEqualTo("Incorrect mail or password");
		}
	}

	@Test
	public void aDonorCreateWithValidMailShouldValiedWhenGettersValuesMatch() throws ExistingUser {
		Donor donor = new Donor();
		donor.setName("Jonatan");
		donor.setMail("jony@gmail.com");
		donor.setPassword("2132132");
		donor.setNickname("Jony");

		donorService.create(donor);
		assertThat(donor.getName()).isEqualTo("Jonatan");
		assertThat(donor.getMail()).isEqualTo("jony@gmail.com");
		assertThat(donor.getPassword()).isEqualTo("2132132");
		assertThat(donor.getNickname()).isEqualTo("Jony");

	}

	@Test
	public void aDonorCreateWithInvalidMailShouldGetErrorMessageExistingUser() {
		Donor donor = new Donor();
		donor.setName("Jonatan");
		donor.setMail("jony@gmail.com");
		donor.setPassword("2132132");
		donor.setNickname("Jony");
		
		try {
			donorService.create(donor);
		} catch (ExistingUser e) {
			assertThat(e.getMessage()).isEqualTo("Is there a user with this mail");
		}
	}

}
