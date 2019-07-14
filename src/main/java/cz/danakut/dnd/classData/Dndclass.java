package cz.danakut.dnd.classData;

import cz.danakut.dnd.Skill;
import cz.danakut.dnd.enums.AbilityName;
import cz.danakut.dnd.enums.ArmorProficiency;
import cz.danakut.dnd.enums.ToolProficiency;
import cz.danakut.dnd.enums.WeaponProficiency;

import java.util.ArrayList;
import java.util.List;

public abstract class Dndclass {

    abstract int getHitDice();
    abstract List<ArmorProficiency> getStartingArmorProficiencies();
    abstract List<WeaponProficiency> getStartingWeaponProficiencies();
    abstract List<ToolProficiency> getStartingToolProficiencies();
    abstract List<AbilityName> getStartingSavingThrows();
    abstract List<Skill> offerStartingSkillsToChooseFrom();
}