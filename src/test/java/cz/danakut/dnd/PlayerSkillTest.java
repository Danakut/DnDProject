package cz.danakut.dnd;

import cz.danakut.dnd.enums.SkillName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerSkillTest {

    @Test
    @DisplayName("Skill properly converted to String.")
    public void testToString() {
        Skill tested = new PlayerSkill(SkillName.ARCANA);
        assertEquals("Arcana", tested.toString());

        tested = new PlayerSkill(SkillName.HISTORY, true);
        assertEquals("History - proficient", tested.toString());

        tested = new PlayerSkill(SkillName.ANIMAL_HANDLING, false);
        assertEquals("Animal Handling", tested.toString());
    }
}
