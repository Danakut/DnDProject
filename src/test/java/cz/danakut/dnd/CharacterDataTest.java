package cz.danakut.dnd;

import cz.danakut.dnd.enums.Language;
import cz.danakut.dnd.enums.Sex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterDataTest {

    @Test
    @DisplayName("name")
    public void testName() {
        CharacterData testChar = new CharacterData();

        testChar.name = "Adam Smith";
        assertEquals("Adam Smith", testChar.name);
    }

    @Test
    @DisplayName("sex")
    public void testSex() {
        CharacterData testChar = new CharacterData();

        testChar.sex = Sex.FEMALE;
        assertEquals("FEMALE", testChar.sex.toString());
    }

    @Test
    @DisplayName("race + subrace")
    public void testRace() {
        CharacterData testChar = new CharacterData();

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
        CharacterData testChar = new CharacterData();

        testChar.speed = Dwarf.speed;
        assertEquals(25, testChar.speed.walk);
        assertEquals(0, testChar.speed.fly);
    }

    @Test
    @DisplayName("size")
    public void testSize() {
        CharacterData testChar = new CharacterData();

        testChar.speed = Dwarf.speed;
        assertEquals(25, testChar.speed.walk);
        assertEquals(0, testChar.speed.fly);
    }

    @Test
    @DisplayName("languages")
    public void testLanguages() {
        CharacterData testChar = new CharacterData();

        testChar.languages = Elf.languages;
        String languages = makeLanguageString(testChar);
        assertEquals("COMMON, ELVISH", languages);
    }

    private String makeLanguageString(CharacterData testChar) {
        StringBuilder allLanguages = new StringBuilder("");
        for (Language language : testChar.languages) {
            allLanguages.append(language.toString() + ", ");
        }
        //remove the last comma and space
        allLanguages.setLength(allLanguages.length() - 2);
        return allLanguages.toString();
    }
}
