package cz.danakut.dnd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillTest {

    @Test
    @DisplayName("Skill properly converted to String.")
    public void testToString() {
        Skill tested = new Skill(SkillName.ARCANA);
        assertEquals("Intelligence (Arcana)", tested.toString());
    }
}
