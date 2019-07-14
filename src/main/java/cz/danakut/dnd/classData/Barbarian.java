package cz.danakut.dnd.classData;

import cz.danakut.dnd.Skill;
import cz.danakut.dnd.enums.*;

import java.util.ArrayList;
import java.util.List;

class Barbarian extends Dndclass {

    @Override
    int getHitDice() {
        return 12;
    }

    @Override
    List<ArmorProficiency> getStartingArmorProficiencies() {
        List<ArmorProficiency> list = new ArrayList<>();
        list.add(ArmorProficiency.LIGHT);
        list.add(ArmorProficiency.MEDIUM);
        list.add(ArmorProficiency.SHIELD);
        return list;
    }

    @Override
    List<WeaponProficiency> getStartingWeaponProficiencies() {
        List<WeaponProficiency> list = new ArrayList<>();
        list.add(WeaponProficiency.SIMPLE);
        list.add(WeaponProficiency.MARTIAL);
        return list;
    }

    @Override
    List<ToolProficiency> getStartingToolProficiencies() {
        return new ArrayList<ToolProficiency>();
    }

    @Override
    List<AbilityName> getStartingSavingThrows() {
        List<AbilityName> list = new ArrayList<>();
        list.add(AbilityName.STRENGTH);
        list.add(AbilityName.CONSTITUTION);
        return list;
    }

    @Override
    List<Skill> offerStartingSkillsToChooseFrom() {
        List<Skill> list = new ArrayList<>();
        list.add(new Skill(SkillName.ANIMAL_HANDLING));
        list.add(new Skill(SkillName.ATHLETICS));
        list.add(new Skill(SkillName.INTIMIDATION));
        list.add(new Skill(SkillName.NATURE));
        list.add(new Skill(SkillName.PERCEPTION));
        list.add(new Skill(SkillName.SURVIVAL));
        return list;
    }
}
