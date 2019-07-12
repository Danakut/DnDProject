package cz.danakut.dnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillProficiencies {

    private static final List<SkillName> ALL_SKILL_NAMES = Arrays.asList(SkillName.values());

    List<PlayerSkill> skillsAndProficiences;

    SkillProficiencies() {
        skillsAndProficiences = new ArrayList<>();

        for (SkillName name : ALL_SKILL_NAMES) {
            skillsAndProficiences.add(new PlayerSkill(name));
        }
    }

    void addProficiencyForExistingSkill(SkillName name) {
        PlayerSkill skill = getSkillFromTheList(name);
        skill.setProficiency(true);
    }

    void removeProficiencyFromExistingSkill(SkillName name) {
        PlayerSkill skill = getSkillFromTheList(name);
        skill.setProficiency(false);
    }

    private PlayerSkill getSkillFromTheList(SkillName nameToLookUp) throws IllegalArgumentException {
        int positionInList = -1;
        for (PlayerSkill skill : skillsAndProficiences) {
            if (skill.getName().equals(nameToLookUp)) {
                positionInList = skillsAndProficiences.indexOf(skill);
                break;
            }
        }

        if (positionInList > -1) {
            return skillsAndProficiences.get(positionInList);
        } else {
            throw new IllegalArgumentException("SkillName " + nameToLookUp + " not present.");
        }
    }




//todo Need to override equals()? Is a skill without proficiency equal to the same skill WITH proficiency? Needs to be decided.

}
