package cz.danakut.dnd;

import cz.danakut.dnd.enums.SkillName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceThrowerTest {

    @Test
    @DisplayName("Simulate 3d6+5 roll.")
    public void test3d6roll() {
        DiceThrower thrower = new DiceThrower();
        int rollResult = thrower.makeRoll(6,3,5);
        assertEquals(true, rollResult >= 8);
        assertEquals(true, rollResult <= 23);
    }

    @Test
    @DisplayName("Simulate d20-1 roll.")
    public void testd20roll() {
        DiceThrower thrower = new DiceThrower();
        int rollResult = thrower.makeRoll(20,1,-1);
        assertEquals(true, rollResult >= 0);
        assertEquals(true, rollResult <= 19);
    }
}
