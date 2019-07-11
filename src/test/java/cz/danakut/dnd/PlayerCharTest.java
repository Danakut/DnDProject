package cz.danakut.dnd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerCharTest {

    @Test
    @DisplayName("name")
    public void testName() {
        PlayerChar testChar = new PlayerChar();

        testChar.name = "Adam Smith";
        assertEquals("Adam Smith", testChar.name);
    }

    @Test
    @DisplayName("sex")
    public void testSex() {
        PlayerChar testChar = new PlayerChar();

        testChar.sex = Sex.FEMALE;
        assertEquals("FEMALE", testChar.sex.toString());
    }

    @Test
    @DisplayName("race + subrace")
    public void testRace() {
        PlayerChar testChar = new PlayerChar();

        testChar.race = new Dwarf(Dwarf.Subrace.HILL);
        assertEquals(Dwarf.Subrace.HILL, testChar.race.subrace );
        testChar.race = new Human();
        assertEquals(null, testChar.race.subrace);
        testChar.race = new Elf(Elf.Subrace.WOOD);
        assertEquals(Elf.Subrace.WOOD, testChar.race.subrace);
    }

    @Test
    @DisplayName("speed")
    public void testSpeed() {
        PlayerChar testChar = new PlayerChar();

        testChar.speed = Dwarf.speed;
        assertEquals(25, testChar.speed.walk);
        assertEquals(0, testChar.speed.fly);
    }

    @Test
    @DisplayName("size")
    public void testSize() {
        PlayerChar testChar = new PlayerChar();

        testChar.speed = Dwarf.speed;
        assertEquals(25, testChar.speed.walk);
        assertEquals(0, testChar.speed.fly);
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

    @Test
    @DisplayName("get/set skill")
    public void testGetSetSkill() {
        PlayerChar testChar = new PlayerChar();
        testChar.setSkillScore(SkillName.HISTORY, 6);
        assertEquals(6, testChar.getSkillScore(SkillName.HISTORY));
        
    }

    @Test
    @DisplayName("languages")
    public void testLanguages() {
        PlayerChar testChar = new PlayerChar();

        testChar.languages = Elf.languages;
        String languages = makeLanguageString(testChar);
        assertEquals("COMMON, ELVISH", languages);
    }

    private String makeLanguageString(PlayerChar testChar) {
        StringBuilder allLanguages = new StringBuilder("");
        for (Language language : testChar.languages) {
            allLanguages.append(language.toString() + ", ");
        }
        //remove the last comma and space
        allLanguages.setLength(allLanguages.length() - 2);
        return allLanguages.toString();
    }
}
