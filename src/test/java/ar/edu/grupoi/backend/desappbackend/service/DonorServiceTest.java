package ar.edu.grupoi.backend.desappbackend.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.grupoi.backend.desappbackend.DesappBackendApplicationTests;
import ar.edu.grupoi.backend.desappbackend.builder.DonorBuilder;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ExistingUser;

public class DonorServiceTest extends DesappBackendApplicationTests {

	@Autowired
	private DonorService donorService;

	@Test
	public void aDonorPersistsShouldValiedWhenGettersValuesMatch() throws ErrorLogin {
		Donor aDonor = DonorBuilder.whitName("Nico").build(em);

		Donor donor = donorService.login("cris@mail.com", "pas123");

		assertThat(donor.getName()).isEqualTo("Nico");
		assertThat(donor.getMail()).isEqualTo("cris@mail.com");
		assertThat(donor.getPassword()).isEqualTo("pas123");
		assertThat(donor.getNickname()).isEqualTo("cris");
	}

	@Test
	public void aDonorPersistsWithValueDiferentShouldValiedWhenGettersValuesMatch() throws ErrorLogin {
		Donor aDonor = DonorBuilder.whitName("Nico").whitMail("nico@mail.com").whitPassword("nico123")
				.withNickname("Nick").build(em);

		Donor donor = donorService.login("nico@mail.com", "nico123");

		assertThat(donor.getName()).isEqualTo("Nico");
		assertThat(donor.getMail()).isEqualTo("nico@mail.com");
		assertThat(donor.getPassword()).isEqualTo("nico123");
		assertThat(donor.getNickname()).isEqualTo("Nick");
	}
	
	@Test
	public void loginADonorWithInvalidMailShouldGetErrorLogin() {
		Donor aDonor = DonorBuilder.whitName("Nico").whitMail("nico@mail.com").whitPassword("nico123")
				.withNickname("Nick").build(em);

		try {
			donorService.login("crist@mail.com", "pas123");
		} catch (ErrorLogin e) {
			assertThat(e.getMessage()).isEqualTo("Incorrect mail or password");
		}
	}
	
	@Test
	public void loginADonorWithInvalidPasswordShouldGetErrorLogin() {
		Donor aDonor = DonorBuilder.whitName("Nico").whitMail("nico@mail.com").whitPassword("nico123")
				.withNickname("Nick").build(em);

		try {
			donorService.login("cris@mail.com", "pas1s23");
		} catch (ErrorLogin e) {
			assertThat(e.getMessage()).isEqualTo("Incorrect mail or password");
		}
	}

	@Test
	public void aDonorCreateWithValidMailShouldValiedWhenGettersValuesMatch() throws ExistingUser {
		Donor aDonor = DonorBuilder.whitName("Nico").whitMail("nico@mail.com").whitPassword("nico123")
				.withNickname("Nick").build(em);

		Donor donor = new Donor();
		donor.setName("Jonatan");
		donor.setMail("jony@mail.com");
		donor.setPassword("2132132");
		donor.setNickname("Jony");

		Donor neDonor = donorService.create(donor);
		assertThat(donor.getName()).isEqualTo("Jonatan");
		assertThat(donor.getMail()).isEqualTo("jony@mail.com");
		assertThat(donor.getPassword()).isEqualTo("2132132");
		assertThat(donor.getNickname()).isEqualTo("Jony");

	}

	@Test
	public void aDonorCreateWithInvalidMailShouldGetErrorMessageExistingUser() {
		Donor aDonor = DonorBuilder.whitName("Nico").whitMail("nico@mail.com").whitPassword("nico123")
				.withNickname("Nick").build(em);

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
