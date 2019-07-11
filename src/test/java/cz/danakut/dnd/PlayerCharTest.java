package cz.danakut.dnd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerCharTest {

    @Test
    @DisplayName("A helper test for character creation.")
    public void testPlayerChar() {
        PlayerChar testChar = new PlayerChar();

        testChar.name = "Adam Smith";
        assertEquals("Adam Smith", testChar.name);

        testChar.race = new Dwarf(Dwarf.Subrace.HILL);
        assertEquals(Dwarf.Subrace.HILL, testChar.race.subrace );
        testChar.race = new Human();
        assertEquals(null, testChar.race.subrace);
        testChar.race = new Elf(Elf.Subrace.WOOD);
        assertEquals(Elf.Subrace.WOOD, testChar.race.subrace);

    }
}
