package cz.danakut.dnd;

public class PlayerSkill extends Skill{

    boolean proficiency;

    PlayerSkill(SkillName name) {
        super(name);
        this.proficiency = false;
    }

    PlayerSkill(SkillName name, boolean proficiency) {
        super(name);
        this.proficiency = proficiency;
    }

    void setProficiency(boolean proficiency) {
        this.proficiency = proficiency;
    }

    public boolean hasProficiency() {
        return this.proficiency;
    }


    @Override
    public String toString() {
        return super.toString() + (proficiency ? " - proficient" : "");
    }
}
