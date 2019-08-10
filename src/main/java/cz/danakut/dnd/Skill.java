package cz.danakut.dnd;

import cz.danakut.dnd.enums.AbilityName;
import cz.danakut.dnd.enums.SkillName;

import java.util.Objects;

public class Skill implements Comparable<Skill> {

    SkillName name;
    AbilityName associatedAbility;

    public Skill(SkillName name) {
        this.name = name;
        this.associatedAbility = findAssociatedAbilityBy(name);
    }

    public AbilityName findAssociatedAbilityBy(SkillName name) {
        switch (name) {
            case ATHLETICS: return AbilityName.STRENGTH;

            case ACROBATICS:
            case SLEIGHT_OF_HAND:
            case STEALTH: return AbilityName.DEXTERITY;

            case ARCANA:
            case HISTORY:
            case INVESTIGATION:
            case NATURE:
            case RELIGION: return AbilityName.INTELLIGENCE;

            case ANIMAL_HANDLING:
            case INSIGHT:
            case MEDICINE:
            case PERCEPTION:
            case SURVIVAL: return AbilityName.WISDOM;

            case DECEPTION:
            case INTIMIDATION:
            case PERFORMANCE:
            case PERSUASION: return AbilityName.CHARISMA;

            default: return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return this.name == skill.name &&  this.associatedAbility == skill.associatedAbility;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, associatedAbility);
    }

    @Override
    public String toString() {
        String convertedName = Utilities.convertToTextWithFirstCapitalLetters(name.toString());
        return convertedName;
    }

    public SkillName getName() {
        return name;
    }

    public AbilityName getAssociatedAbility() {
        return associatedAbility;
    }

    @Override
    public int compareTo(Skill o) {
        int abilityComparation = this.associatedAbility.compareTo(o.associatedAbility);
        if (abilityComparation != 0) {
            return abilityComparation;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}
