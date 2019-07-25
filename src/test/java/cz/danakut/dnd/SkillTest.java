package cz.danakut.dnd;

import cz.danakut.dnd.enums.SkillName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Skill first = new Skill(SkillName.ARCANA);
        Skill second = new Skill(SkillName.DECEPTION);
        Skill third = new Skill(SkillName.ARCANA);
        assertEquals(-1, first.compareTo(second));
        assertEquals(1, second.compareTo(first));
        assertEquals(0, first.compareTo(third));
    }
}
