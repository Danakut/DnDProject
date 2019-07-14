package cz.danakut.dnd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HitPointsTest {

    @Test
    @DisplayName("Constructor set up properly.")
    public void testConstructor() {
        HitPoints hitpoints = new HitPoints(200);
        assertEquals(200, hitpoints.getMaximum());
        assertEquals(200, hitpoints.getCurrent());
        assertEquals(0, hitpoints.getTemporary());
    }

    @Test
    @DisplayName("Negative maximum HP is converted to 0.")
    public void testSetMaximum() {
        HitPoints hitpoints = new HitPoints();
        hitpoints.setMaximum(10);
        assertEquals(10, hitpoints.getMaximum());
        hitpoints.setMaximum(-55);
        assertEquals(0, hitpoints.getMaximum());
    }

    @Test
    @DisplayName("Current HP calculated correctly.")
    public void testGetCurrent() {
        HitPoints hitpoints = new HitPoints(50);
        hitpoints.addTemporary(20);
        assertEquals(70, hitpoints.getCurrent());
    }

    @Test
    @DisplayName("Losing and adding HP.")
    public void testLoseHitpoints() {
        HitPoints hitpoints = new HitPoints(50);
        hitpoints.addTemporary(20);

        hitpoints.loseHitPoints(15);
        assertEquals(5, hitpoints.getTemporary());
        assertEquals(55, hitpoints.getCurrent());

        hitpoints.loseHitPoints(20);
        assertEquals(0, hitpoints.getTemporary());
        assertEquals(35, hitpoints.getCurrent());

        hitpoints.addHitPoints(10);
        assertEquals(45, hitpoints.getCurrent());
    }
    
}
