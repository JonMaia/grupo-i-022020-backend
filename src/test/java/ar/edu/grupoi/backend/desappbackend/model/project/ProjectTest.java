package ar.edu.grupoi.backend.desappbackend.model.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProjectTest {

    private Project aProject;
    private Location location;
    private LocalDate aInitialDate;
    private System system;

    @BeforeEach
    void setUp() {
        system    = new System(null);
        location  = mock(Location.class);
        aProject  = new Project("Avellaneda con Internet", LocalDate.of(2020,11,23),
                                location, 50.0, null);
        aInitialDate = LocalDate.now();
    }

    @Test
    void aProjectIsShouldValidWhenGettersValuesMatch() {
        assertEquals(aProject.getName(), "Avellaneda con Internet");
        assertEquals(aProject.getEndDate(), LocalDate.of(2020, 11, 23));
        assertEquals(aProject.getLocation(), location);
        assertEquals(aProject.getMinPercentage(), 50.0);
        assertEquals(aProject.getFactor(), 1000);
        assertTrue(aProject.getActive());
        assertEquals(aProject.getCollection(), 0);
        assertEquals(aProject.getInitialDate(), aInitialDate);
        assertEquals(aProject.getPercentage(), 0);
    }

    @Test
    void whenAskHowMuchMoneyIsNeededToFinishWith2000PopulationShouldReturnAMoneyRequired2000000Project() {
        when(location.getPopulation()).thenReturn(2000);

        assertEquals(aProject.getFactor(), 1000.0);
        assertEquals(location.getPopulation(), 2000);
        assertEquals(aProject.moneyRequired(), 2000000.0);
    }

    @Test
    void whenAProjectSetNewMinPercentage80ShouldGetMinPercentageUpdatedValuesMatch() {
        aProject.modifyMinPercentage(80.0);
        assertEquals(aProject.getMinPercentage(), 80.0);
    }

    @Test
    void whenAProjectSetNewMinPercentage30ShouldGetErrorMessageMinNotAllowed() {
        try {
            aProject.modifyMinPercentage(30.0);
        } catch (IllegalArgumentException e) {
            assertEquals("The min percentage value should be within 50 and 100", e.getMessage());
        }
    }

    @Test
    void whenAProjectSetNewEndDate20201101ShouldUpdateEndDate() {
    	LocalDate newDate = LocalDate.now().plusDays(1);
        aProject.changeEndDate(newDate);
        assertEquals(aProject.getEndDate(), newDate);
    }

    @Test
    void whenAProjectSetNewEndDateBeforeInitialDateShouldViewErrorMessage() {
        try {
            aProject.changeEndDate(LocalDate.of(2020,7,11));
        } catch (IllegalArgumentException e) {
            assertEquals("Date used is not allowed, please try another date", e.getMessage());
        }
    }

    @Test
    void whenAProjectSetNewFactor2000ShouldUpdateFactor() {
        aProject.changeFactor(2000);
        assertEquals(aProject.getFactor(), 2000);
    }

    @Test
    void whenAProjectSetNewFactor0ShouldViewErrorMessage() {
        try {
            aProject.changeFactor(0);
        } catch (IllegalArgumentException e) {
            assertEquals("The factor must be greater than 0 and less than 100000", e.getMessage());
        }
    }

    @Test
    void when1000IsDonatedToAProjectWith0CollectionItUpdatesItsCollectionBy1000() {
        aProject.updateCollection(1000);
        assertEquals(aProject.getCollection(), 1000);
    }

    @Test
    void whenAProjectIsCreatedItIsAddedToTheSystem() {
        system.addProject(aProject);
        assertEquals(system.projects.size(), 1);
    }
}
