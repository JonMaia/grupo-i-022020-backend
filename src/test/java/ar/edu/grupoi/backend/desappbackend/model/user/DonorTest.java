package ar.edu.grupoi.backend.desappbackend.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.project.System;


public class DonorTest {

	private Donor aDonor;
	private System system;
	
	 @BeforeEach
	 void setUp() {
		aDonor = new Donor("Cristian", "mail@gmail.com", "pas1234", "Cris");
		system = new System(null);
	 }
	
	@Test
	void aDonorIsShouldValidWhenGettersValuesMatch() {
		assertEquals(aDonor.getName(), "Cristian");
		assertEquals(aDonor.getMail(), "mail@gmail.com");
		assertEquals(aDonor.getPassword(), "pas1234");
		assertEquals(aDonor.getNickname(), "Cris");
	}
	
	@Test
	void whenADonorSetNameShouldGetNameUpdatedValuesMatch() {
		aDonor.setName("Nicolas");
		assertEquals(aDonor.getName(), "Nicolas");
	}
	
	@Test
	void whenADonorSetMailShouldGetMailUpdatedValuesMatch() {
		aDonor.setMail("unMail@gmail.com");
		assertEquals(aDonor.getMail(), "unMail@gmail.com");
	}
	
	@Test
	void whenADonorSetPasswordShouldGetPasswordUpdatedValuesMatch() {
		aDonor.setPassword("word12");
		assertEquals(aDonor.getPassword(), "word12");
	}
	
	@Test
	void whenADonorSetNicknameShouldGetNicknameUpdatedValuesMatch() {
		aDonor.setNickname("nico");
		assertEquals(aDonor.getNickname(), "nico");
	}
	
	@Test
	void whenADonorWithEmpltyDonationsQuestionAccumulatedPointsShould0Points() {
		assertEquals(system.accumulatedPoints(aDonor), 0);
	}
	
	@Test
	void whenADonorWith2DonationsOf1000TheSameMothQuestionAccumulatedPointsShould2500Points() {
		Project project = mock(Project.class);
		Location location = mock(Location.class);
		when(location.getPopulation()).thenReturn(3000);
		when(project.getLocation()).thenReturn(location);
		
		Project otherProject = mock(Project.class);
		Location otherLocation = mock(Location.class);
		when(otherLocation.getPopulation()).thenReturn(3000);
		when(otherProject.getLocation()).thenReturn(otherLocation);
		
		system.donate(aDonor, project, 1000, "first donation");
		system.donate(aDonor, otherProject, 1000, "second donation");

		assertEquals(system.accumulatedPoints(aDonor), 2500);
	}
}
