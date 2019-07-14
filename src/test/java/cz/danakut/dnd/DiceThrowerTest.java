package cz.danakut.dnd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceThrowerTest {

    @Test
    @DisplayName("Simulate 3d6+5 roll.")
    public void test3d6roll() {
        DiceThrower thrower = new DiceThrower();
        int rollResult = thrower.makeRoll(6,3,5);
        assertTrue(rollResult >=8, "Result of 3d6+5 should be at least 8.");
        assertTrue(rollResult <= 23, "Result of 3d6+5 should be less or equal to 23.");
    }

    @Test
    @DisplayName("Simulate d20-1 roll.")
    public void testd20roll() {
        DiceThrower thrower = new DiceThrower();
        int rollResult = thrower.makeRoll(20,1,-1);
        assertTrue(rollResult >=0, "Result of d20-1 should be at least 0.");
        assertTrue(rollResult <= 19, "Result of d20-1 should be less or equal to 19.");
    }
}
