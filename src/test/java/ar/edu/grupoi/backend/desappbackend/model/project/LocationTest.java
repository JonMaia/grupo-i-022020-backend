package ar.edu.grupoi.backend.desappbackend.model.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationTest {

    private Location location;
    private System system;

    @BeforeEach
    void setUp() {
        location = new Location("Avellaneda", "Buenos Aires", 342677, true);
        system   = new System(null);
    }

    @Test
    void aLocationIsShouldValidWhenGettersValuesMatch() {
        assertEquals(location.getName(), "Avellaneda");
        assertEquals(location.getProvince(), "Buenos Aires");
        assertEquals(location.getPopulation(), 342677);
        assertTrue(location.getState());
    }

    @Test
    void whenALocationIsCreatedItIsAddedToTheSystem() {
        system.addLocation(location);
        assertEquals(system.locations.size(), 1);
    }
}
