package cz.danakut.dnd;

import cz.danakut.dnd.enums.Condition;
import cz.danakut.dnd.enums.Sex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("languages")
    public void testLanguages() {
        PlayerChar testChar = new PlayerChar();

        testChar.languages = Elf.languages;
        String languages = makeLanguageString(testChar);
        assertEquals("COMMON, ELVISH", languages);
    }

    private String makeLanguageString(PlayerChar testChar) {
        StringBuilder allLanguages = new StringBuilder("");
        for (Condition.Language language : testChar.languages) {
            allLanguages.append(language.toString() + ", ");
        }
        //remove the last comma and space
        allLanguages.setLength(allLanguages.length() - 2);
        return allLanguages.toString();
    }
}
