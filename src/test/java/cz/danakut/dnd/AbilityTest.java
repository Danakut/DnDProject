package cz.danakut.dnd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbilityTest {

    @Test
    @DisplayName("Ability (name, score) created.")
    public void testConstructor() {
        Ability tested = new Ability(AbilityName.CONSTITUTION, 10);
        //custom String is used as actual value instead of Ability.toString,
        // since getModifierWithSign() - a part of toString() - has not been tested at this point
        assertEquals("CONSTITUTION 10/0", tested.getName() + " " + tested.getScore() + "/" + tested.getModifier());
    }

    @Test
    @DisplayName("Modifiers are properly converted to Strings.")
    void testModifierWithSign() {
        Ability zeroModifier = new Ability(AbilityName.WISDOM, 11);
        assertEquals("+0", zeroModifier.getModifierWithSign());

        Ability negModifier = new Ability(AbilityName.WISDOM, 9);
        assertEquals("-1", negModifier.getModifierWithSign());

        Ability posModifier = new Ability(AbilityName.WISDOM, 12);
        assertEquals("+1", posModifier.getModifierWithSign());

    }

    @Test
    @DisplayName("Setting up a new value updates modifier correctly.")
    public void testSetScore() {
        Ability lowValue = new Ability(AbilityName.STRENGTH, 7);
        lowValue.setScore(20);
        assertEquals("STRENGTH 20/+5", lowValue.toString());

        Ability highValue = new Ability(AbilityName.DEXTERITY, 17);
        highValue.setScore(7);
        assertEquals("DEXTERITY 7/-2", highValue.toString());
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


}
