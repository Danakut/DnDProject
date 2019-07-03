package cz.danakut.dnd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbilityTest {

    @Test
    @DisplayName("Ability (name, score) created.")
    public void testConstructor() {
        Ability tested = new Ability(AbilityName.CONSTITUTION, 10);
        assertEquals("CONSTITUTION 10/+0", tested.toString());
    }

    @Test
    @DisplayName("Setting up a new value updates modifier correctly.")
    public void testSetScore() {
        Ability lowValue = new Ability(AbilityName.STRENGTH, 7);
        lowValue.setScore(20);
        assertEquals("STRENGTH 20/+5", lowValue.toString());

        Ability highValue = new Ability(AbilityName.DEXTERITY, 17);
        highValue.setScore(9);
        assertEquals("DEXTERITY 9/-1", highValue.toString());
    }

    @Test
    @DisplayName("Setting up a new value out of bounds throws exception.")
    void testSetScoreException() {
        Exception constructorException = assertThrows(IllegalArgumentException.class, () ->
                new Ability(AbilityName.CHARISMA, 38));
        assertEquals("Ability score out of bounds (0-30).", constructorException.getMessage());

        Ability tested = new Ability(AbilityName.INTELLIGENCE, 5);
        Exception setScoreException = assertThrows(IllegalArgumentException.class, () ->
               tested.setScore(-5));
        assertEquals("Ability score out of bounds (0-30).", setScoreException.getMessage());
    }

    @Test
    @DisplayName("Modifiers are properly converted to Strings.")
    void testModifierWithSign() {
        Ability negModifier = new Ability(AbilityName.WISDOM, 5);
        assertEquals("-3", negModifier.getModifierWithSign());

        Ability posModifier = new Ability(AbilityName.WISDOM, 24);
        assertEquals("+7", posModifier.getModifierWithSign());

    }
}
