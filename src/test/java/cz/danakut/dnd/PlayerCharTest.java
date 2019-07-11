package cz.danakut.dnd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerCharTest {

    @Test
    @DisplayName("A helper test for character creation.")
    public void testPlayerChar() {
        PlayerChar testChar = new PlayerChar();

        /*
        testChar.name = "Adam Smith";
        assertEquals("Adam Smith", testChar.name);

        testChar.race = new Dwarf(Dwarf.Subrace.HILL);
        assertEquals(Dwarf.Subrace.HILL, testChar.race.subrace );
        testChar.race = new Human();
        assertEquals(null, testChar.race.subrace);
        testChar.race = new Elf(Elf.Subrace.WOOD);
        assertEquals(Elf.Subrace.WOOD, testChar.race.subrace);

        testChar.sex = Sex.FEMALE;
        assertEquals("FEMALE", testChar.sex.toString());

        testChar.speed = Dwarf.speed;
        assertEquals(25, testChar.speed.walk);
        assertEquals(0, testChar.speed.fly);

        testChar.size = Dwarf.size;
        assertEquals("MEDIUM", testChar.size.toString());
        */

    }


    @Test
    @DisplayName("playerChar.skills is properly initialized.")
    public void testInitializeSkills() {
        PlayerChar testChar = new PlayerChar();

        Map<Skill, Integer> mockedMapValues = createMockedMapOfSkills();
        assertEquals(mockedMapValues, testChar.skills);
    }

    private Map<Skill, Integer> createMockedMapOfSkills() {
        Map<Skill, Integer> mockedMap = new HashMap<>();
        Set<Skill> mockedMapKeys = createMockedMapKeys();
        for (Skill skill : mockedMapKeys) {
            mockedMap.put(skill, Utilities.INITIAL_SKILL_VALUE);
        }
        return mockedMap;
    }

    private Set<Skill> createMockedMapKeys() {
        SkillName[] names = SkillName.values();
        List<Skill> listOfSkills = new ArrayList<>();
        for (SkillName name : names) {
            listOfSkills.add(new Skill(name));
        }
        return new HashSet<>(listOfSkills);
    }
}
