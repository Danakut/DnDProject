package cz.danakut.dnd;

import java.util.List;
import java.util.Map;

public class PlayerChar {

    String name;
    Race race;
    Sex sex;
    Size size;
    Speed speed;
    List<Language> languages;

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



}
