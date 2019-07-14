package cz.danakut.dnd;

import cz.danakut.dnd.enums.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterData {

    String characterName;
    Sex sex;
    Race race;
    Size size;
    Speed speed;
    Alignment alignment;
    Abilities abilities;
    HitPoints hitPoints;
//    SkillProficiencies skillProficiencies;
    List<ClassLevel> levels;
    List<Skill> skillProficiencies;
    List<ArmorProficiency> armorProficiencies;
    List<WeaponProficiency> weaponProficiencies;
    List<AbilityName> savingThrows;


    List<Resistance> damageResistances;
    List<Resistance> damageImmunities;
    List<Condition> conditionImmunities;
    List<Language> languages;

    //subclasses: monsters, persons
    //make a class builder (builder that accepts an object as a parameter. the object contains initial settings of a person,
    // the builder fills in and calculates necessary values)

    //rozdelit equipment model a fighting model; fight nema vybaveni, ale zato mu naskocily efekty a cisla z vybaveni

    CharacterData() {
        characterName = "Named Character";
        sex = Sex.FEMALE;
        race = new Elf(Elf.Subrace.DARK);
        size = Elf.size;
        speed = Elf.speed;
        hitPoints = new HitPoints(42);
        levels = new ArrayList<>();
        levels.add(new ClassLevel(1, DndclassName.BARBARIAN));
        skillProficiencies = new ArrayList<>();
        skillProficiencies.add(new Skill(SkillName.ANIMAL_HANDLING));
    }

    //function for a variable that is no longer used, but the lambda was hard to get right, so I'm keeping this snippet around O:-)
//    private void initializeSkills() {
//        Stream<SkillName> skillNameStream = Arrays.stream(SkillName.values());
//        this.skills = skillNameStream.collect(Collectors.toMap(characterName -> new Skill(characterName), characterName -> Utilities.INITIAL_SKILL_VALUE));
//    }


    public String getCharacterName() {
        return characterName;
    }

    public Sex getSex() {
        return sex;
    }

    public Race getRace() {
        return race;
    }

    public Size getSize() {
        return size;
    }

    public Speed getSpeed() {
        return speed;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public HitPoints getHitPoints() {
        return hitPoints;
    }

    public List<ClassLevel> getLevels() {
        return levels;
    }

    public List<Skill> getSkillProficiencies() {
        return skillProficiencies;
    }

    public List<ArmorProficiency> getArmorProficiencies() {
        return armorProficiencies;
    }

    public List<WeaponProficiency> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public List<AbilityName> getSavingThrows() {
        return savingThrows;
    }

    public List<Resistance> getDamageResistances() {
        return damageResistances;
    }

    public List<Resistance> getDamageImmunities() {
        return damageImmunities;
    }

    public List<Condition> getConditionImmunities() {
        return conditionImmunities;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
