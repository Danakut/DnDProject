package cz.danakut.dnd;

import java.util.List;
import java.util.Map;

public class Creature {

    String name;
    String race;
    String sex;
    Abilities abilities;
    int hitPoints;
    Alignment alignment;
    Size size;
    Speed speed;
    Map<AbilityName, Integer> savingThrows;
    List<Resistance> damageResistances;
    List<Resistance> damageImmunities;
    List<Condition> conditionImmunities;

    //subclasses: monsters, persons
    //make a class builder (builder that accepts an object as a parameter. the object contains initial settings of a person,
    // the builder fills in and calculates necessary values)

    //rozdelit equipment model a fighting model; fight nema vybaveni, ale zato mu naskocily efekty a cisla z vybaveni



}
