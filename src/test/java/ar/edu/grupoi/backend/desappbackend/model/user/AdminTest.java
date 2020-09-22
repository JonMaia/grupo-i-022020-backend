package ar.edu.grupoi.backend.desappbackend.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.project.System;

public class AdminTest {

	private Admin aAdmin;
	private System system;

	@BeforeEach
	void setUp() {
		aAdmin = new Admin("Cris", "cris@gmail.com", "admiCris123");
		system = new System(aAdmin);
	}

	@Test
	void aAdminIsShouldValidWhenGettersValuesMatch() {
		assertEquals(aAdmin.getName(), "Cris");
		assertEquals(aAdmin.getMail(), "cris@gmail.com");
		assertEquals(aAdmin.getPassword(), "admiCris123");
	}

	@Test
	void whenAAdminCreateProjectShouldReturnAValidProject() {
		Location location = mock(Location.class);
		when(location.getName()).thenReturn("Quilmes");

		Project newProject = Mockito
				.spy(aAdmin.createProject("project1", 55.2, LocalDate.of(2020, 9, 20), location, (double) 1000));

		when(newProject.getName()).thenReturn("project1");
		when(newProject.getMinPercentage()).thenReturn(55.2);
		when(newProject.getEndDate()).thenReturn(LocalDate.of(2020, 9, 20));
		when(newProject.getLocation()).thenReturn(location);
		when(newProject.getFactor()).thenReturn((double) 1000);

		assertEquals(newProject.getName(), "project1");
		assertEquals(newProject.getMinPercentage(), 55.2);
		assertEquals(newProject.getEndDate(), LocalDate.of(2020, 9, 20));
		assertEquals(newProject.getLocation(), location);
		assertEquals(newProject.getFactor(), 1000);
	}

	@Test
	void whenAdminCreateProjectItIsAddedToTheSystem() {
		Location location = mock(Location.class);
		Project newProject = Mockito
				.spy(aAdmin.createProject("project1", 55.2, LocalDate.of(2020, 9, 20), location, (double) 1000));

		system.addProject(newProject);

		assertEquals(system.projects.size(), 1);
	}

	@Test
	void whenAdminFinishCollectionOfProjectNotFinishThisIsActive() {
		Location location = mock(Location.class);
		Project newProject = Mockito
				.spy(aAdmin.createProject("project1", 55.2, LocalDate.of(2020, 9, 20), location, (double) 1000));

		aAdmin.finishCollection(newProject);
		assertTrue(newProject.getActive());
	}

	@Test
	void whenAdminFinishCollectionOfProjectFinishThisIsClose() {
		Donor aDonor = mock(Donor.class);
		Donor otherDonor = mock(Donor.class);
		Location location = mock(Location.class);
		when(location.getPopulation()).thenReturn(1000);
		Project newProject = Mockito
				.spy(aAdmin.createProject("project1", 55.2, LocalDate.of(2020, 9, 20), location, (double) 1000));

		when(aDonor.getNickname()).thenReturn("cris");
		when(aDonor.getNickname()).thenReturn("nick");

		system.donate(aDonor, newProject, 500000, "first donation");
		system.donate(otherDonor, newProject, 600000, "second donation");

		aAdmin.finishCollection(newProject);
		assertFalse(newProject.getActive());
	}

	@Test
	void whenAdminFinishCollectionOfProjectFinishThisNotifyNews() {
		Donor aDonor = new Donor("cristian", "cris@mail.com", "123", "cris");
		Donor otherDonor = new Donor("Nico", "nick@mail.com", "nick123", "nick");
		Location location = new Location("Avellaneda", "Buenos Aires", 342677, true);

		Project project = new Project("Avellaneda con Internet", LocalDate.of(2020, 11, 23), location, 50.0, null);

		system.addDonor(aDonor);
		system.addDonor(otherDonor);
		system.addLocation(location);
		system.addProject(project);
		system.donate(aDonor, project, 500000, "first donation");
		system.donate(otherDonor, project, 600000, "");

		assertTrue(system.projects.get(0).getActive());

		system.finishCollection(project);
		system.notifyNews(project);

		assertFalse(system.projects.get(0).getActive());

	}

}
