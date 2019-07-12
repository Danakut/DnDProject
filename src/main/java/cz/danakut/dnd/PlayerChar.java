package cz.danakut.dnd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerChar {

    String name;
    Sex sex;
    Race race;
    Size size;
    Speed speed;
    List<Language> languages;
    SkillProficiencies proficiencies;




    Abilities abilities;
    int hitPoints;
    Alignment alignment;

    Map<AbilityName, Integer> savingThrows;
    List<Resistance> damageResistances;
    List<Resistance> damageImmunities;
    List<Condition> conditionImmunities;

    //subclasses: monsters, persons
    //make a class builder (builder that accepts an object as a parameter. the object contains initial settings of a person,
    // the builder fills in and calculates necessary values)

    //rozdelit equipment model a fighting model; fight nema vybaveni, ale zato mu naskocily efekty a cisla z vybaveni

    PlayerChar() {
        proficiencies = new SkillProficiencies();

    }

    //function for a variable that is no longer used, but the lambda was hard to get right, so I'm keeping this snippet around O:-)
//    private void initializeSkills() {
//        Stream<SkillName> skillNameStream = Arrays.stream(SkillName.values());
//        this.skills = skillNameStream.collect(Collectors.toMap(name -> new Skill(name), name -> Utilities.INITIAL_SKILL_VALUE));
//    }



}
