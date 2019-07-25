package cz.danakut.dnd;

import cz.danakut.dnd.enums.AbilityName;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbilityTest {

    @Test
    @DisplayName("Ability (characterName, score) created.")
    public void testConstructor() {
        Ability tested = new Ability(AbilityName.CONSTITUTION, 10);
        //intentionally not testing modifier sign methods, just basic Strings
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

        Ability tested = new Ability(AbilityName.INTELLIGENCE, 5);
        Exception setScoreException = assertThrows(IllegalArgumentException.class, () ->
               tested.setScore(-5));
//        assertEquals("Ability score out of bounds (0-30).", setScoreException.getMessage());
    }

    @Test
    @DisplayName("Comparator sorts abilities in usual DnD order.")
    public void testCompareTo() {
        Ability first = new Ability(AbilityName.STRENGTH, 7);
        Ability second = new Ability(AbilityName.DEXTERITY, 17);
        Ability third = new Ability(AbilityName.STRENGTH, 10);
        assertEquals(-1, first.compareTo(second));
        assertEquals(1, second.compareTo(first));
        assertEquals(0, third.compareTo(first));
    }


}
