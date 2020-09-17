package ar.edu.grupoi.backend.desappbackend.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;


public class DonorTest {

	private Donor aDonor;
	
	 @BeforeEach
	 void setUp() {
		aDonor = new Donor("Cristian", "mail@gmail.com", "pas1234", "Cris");
	 }
	
	@Test
	void aDonorIsShouldValidWhenGettersValuesMatch() {
		assertEquals(aDonor.getName(), "Cristian");
		assertEquals(aDonor.getMail(), "mail@gmail.com");
		assertEquals(aDonor.getPassword(), "pas1234");
		assertEquals(aDonor.getNickname(), "Cris");
	}
	
	@Test
	void WhenADonorSetNameShouldGetNameUpdatedValuesMatch() {
		aDonor.setName("Nicolas");
		assertEquals(aDonor.getName(), "Nicolas");
	}
	
	@Test
	void WhenADonorSetMailShouldGetMailUpdatedValuesMatch() {
		aDonor.setMail("unMail@gmail.com");
		assertEquals(aDonor.getMail(), "unMail@gmail.com");
	}
	
	@Test
	void WhenADonorSetPasswordShouldGetPasswordUpdatedValuesMatch() {
		aDonor.setPassword("word12");
		assertEquals(aDonor.getPassword(), "word12");
	}
	
	@Test
	void WhenADonorSetNicknameShouldGetNicknameUpdatedValuesMatch() {
		aDonor.setNickname("nico");
		assertEquals(aDonor.getNickname(), "nico");
	}
	
	@Test
	void WhenADonorWithEmpltyDonationsQuestionAccumulatedPointsShould0Points() {
		assertEquals(aDonor.accumulatedPoints(), 0);
	}
	
	@Test
	void WhenADonorWith2DonationsOf1000TheSameMothQuestionAccumulatedPointsShould2500Points() {
		Project project = mock(Project.class);
		Location location = mock(Location.class);
		when(location.getPopulation()).thenReturn(3000);
		when(project.getLocation()).thenReturn(location);
		
		Project otherProject = mock(Project.class);
		Location otherLocation = mock(Location.class);
		when(otherLocation.getPopulation()).thenReturn(3000);
		when(otherProject.getLocation()).thenReturn(otherLocation);
		
		aDonor.donate(project, 1000, "cris", "first donation");
		aDonor.donate(otherProject, 1000, "cris", "second donation");
		
		assertEquals(aDonor.accumulatedPoints(), 2500);
	}
}
