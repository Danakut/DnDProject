package cz.danakut.dnd;

import cz.danakut.dnd.enums.SkillName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkillTest {

    @Test
    @DisplayName("Skill properly converted to String.")
    public void testToString() {
        Skill tested = new Skill(SkillName.ARCANA);
        assertEquals("Arcana", tested.toString());
    }

    @Test
    @DisplayName("Comparator sorts skills in usual DnD order.")
    public void testCompareTo() {
        Skill first = new Skill(SkillName.INVESTIGATION);
        Skill second = new Skill(SkillName.ARCANA);
        Skill third = new Skill(SkillName.DECEPTION);
        Skill fourth = new Skill(SkillName.INVESTIGATION);
        assertTrue(first.compareTo(second) > 0, "Investigation should come after Arcana.");
        assertTrue(first.compareTo(third) < 0, "Investigation should come before Deception.");
        assertTrue(first.compareTo(fourth) == 0, "Investigation should be equal to Investigation.");
    }
}
