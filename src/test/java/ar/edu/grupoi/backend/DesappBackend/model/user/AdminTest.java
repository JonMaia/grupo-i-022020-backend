package ar.edu.grupoi.backend.DesappBackend.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.grupoi.backend.DesappBackend.model.project.Location;
import ar.edu.grupoi.backend.DesappBackend.model.project.Project;

public class AdminTest {

	private Admin aAdmin;
	
	 @BeforeEach
	 void setUp() {
		 aAdmin = new Admin("Cris", "cris@gmail.com", "admiCris123");
	 }
	 
	 @Test
	 void aAdminIsShouldValidWhenGettersValuesMatch() {
		 assertEquals(aAdmin.getName(), "Cris");
		 assertEquals(aAdmin.getMail(), "cris@gmail.com");
		 assertEquals(aAdmin.getPassword(), "admiCris123");
	 }
	 
	 @Test
	 void WhenAAdminCreateProjectShouldReturnAValidProject() {
		 Location location = mock(Location.class);
		 when(location.getName()).thenReturn("Quilmes");
		 
		 Project newProject = Mockito.spy(aAdmin.createProject("project1", 55.2, LocalDate.of(2020, 9, 20), location, 1000));
		 
		 when(newProject.getName()).thenReturn("project1");
		 when(newProject.getMinPercentage()).thenReturn(55.2);
		 when(newProject.getEndDate()).thenReturn(LocalDate.of(2020, 9, 20));
		 when(newProject.getLocation()).thenReturn(location);
		 when(newProject.getFactor()).thenReturn(1000);
		 
		 
		 assertEquals(newProject.getName(), "project1");
		 assertEquals(newProject.getMinPercentage(), 55.2);
		 assertEquals(newProject.getEndDate(), LocalDate.of(2020, 9, 20));
		 assertEquals(newProject.getLocation(), location);
		 assertEquals(newProject.getFactor(), 1000);
	 }
}
