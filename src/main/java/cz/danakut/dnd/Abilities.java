package cz.danakut.dnd;

import cz.danakut.dnd.enums.AbilityName;

public class Abilities {

    private Ability strength;
    private Ability dexterity;
    private Ability constitution;
    private Ability intelligence;
    private Ability wisdom;
    private Ability charisma;

    public Abilities(int strengthScore, int dexterityScore, int constitutionScore, int intelligenceScore, int wisdomScore, int charismaScore) {
        this.strength = new Ability(AbilityName.STRENGTH, strengthScore);
        this.dexterity = new Ability(AbilityName.DEXTERITY, dexterityScore);
        this.constitution = new Ability(AbilityName.CONSTITUTION, constitutionScore);
        this.intelligence = new Ability(AbilityName.INTELLIGENCE, intelligenceScore);
        this.wisdom = new Ability(AbilityName.WISDOM, wisdomScore);
        this.charisma = new Ability(AbilityName.CHARISMA, charismaScore);
    }

    public Ability getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength.setScore(strength);
    }

    public Ability getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity.setScore(dexterity);
    }

    public Ability getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution.setScore(constitution);
    }

    public Ability getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence.setScore(intelligence);
    }

    public Ability getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom.setScore(wisdom);
    }

    public Ability getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma.setScore(charisma);
    }

    @Override
    public String toString() {
        return strength.toString() + ", " + dexterity.toString() + ", " + constitution.toString() + ", " + intelligence.toString() +
                ", " + wisdom.toString() + ", " + charisma.toString();
    }
}
