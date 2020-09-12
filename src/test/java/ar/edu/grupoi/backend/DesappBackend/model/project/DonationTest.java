package ar.edu.grupoi.backend.DesappBackend.model.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DonationTest {
	
	private Donation aDonation;
	
	@BeforeEach
	 void setUp() {
		Project project = mock(Project.class);
		Location location = mock(Location.class);
		
		when(location.getPopulation()).thenReturn(3000);
		when(project.getLocation()).thenReturn(location);
		when(project.getNombre()).thenReturn("project");
		
		aDonation = new Donation(LocalDate.now(), 1000, project, "cris", "donation");
	}
	
	@Test
	void aDonotionIsShouldValidWhenGettersValuesMatch() {
		assertEquals(aDonation.getDate(), LocalDate.now());
		assertEquals(aDonation.getAmount(), 1000);
		assertEquals(aDonation.getNickname(), "cris");
		assertEquals(aDonation.getComment(), "donation");
		assertEquals(aDonation.getProject().getNombre(),"project");
	}
	
	@Test
	void WhenADonotionSetAmountShouldGetAmountUpdatedValuesMatch() {
		aDonation.setAmount(100);
		assertEquals(aDonation.getAmount(), 100);
	}
	
	@Test
	void WhenADonotionSetNicknameShouldGetNicknameUpdatedValuesMatch() {
		aDonation.setNickname("nick");;
		assertEquals(aDonation.getNickname(), "nick");
	}

	@Test
	void WhenADonotionSetCommentShouldGetCommentUpdatedValuesMatch() {
		aDonation.setComment("comment");
		assertEquals(aDonation.getComment(), "comment");
	}

	@Test
	void WhenADonotionSetProjectShouldGetProjectUpdatedValuesMatch() {
		Project newProject = mock(Project.class);
		when(newProject.getNombre()).thenReturn("instalation");
		aDonation.setProject(newProject);
		assertEquals(aDonation.getProject().getNombre(), "instalation");
	}
	
	@Test
	void WhenADonationOf1000PesosAccumulatedPointsShould1000Points() {
		aDonation.calculatePointsEarned();
		assertEquals(aDonation.getPoints(), 1000);
	}
	
	@Test
	void WhenADonationOf100PesosAccumulatedPointsShould0Points() {
		aDonation.setAmount(100);
		aDonation.calculatePointsEarned();
		assertEquals(aDonation.getPoints(), 0);
	}
	
	@Test
	void WhenADonationOf10PesosWithProjectOf1000PopulationAccumulatedPointsShould20Points() {
		Project newProject = mock(Project.class);
		Location location = mock(Location.class);
		when(location.getPopulation()).thenReturn(1000);
		when(newProject.getLocation()).thenReturn(location);
				
		aDonation.setProject(newProject);
		aDonation.setAmount(10);
		aDonation.calculatePointsEarned();
		assertEquals(aDonation.getPoints(), 20);
	}
}
