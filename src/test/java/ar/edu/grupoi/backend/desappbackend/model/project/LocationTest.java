package ar.edu.grupoi.backend.desappbackend.model.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationTest {

    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location("Avellaneda", "Buenos Aires", 342677, true);
    }

    @Test
    void aLocationIsShouldValidWhenGettersValuesMatch() {
        assertEquals(location.getName(), "Avellaneda");
        assertEquals(location.getProvince(), "Buenos Aires");
        assertEquals(location.getPopulation(), 342677);
        assertTrue(location.getState());
    }
}
