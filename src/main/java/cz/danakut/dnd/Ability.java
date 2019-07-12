package cz.danakut.dnd;

import cz.danakut.dnd.enums.AbilityName;

public class Ability {

    private AbilityName name;
    private int score;
    private int modifier;

    public Ability(AbilityName name, int score) {
        this.name = name;
        this.setScore(score);
    }

    public AbilityName getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score < 0 || score > 30) {
            throw new IllegalArgumentException("Ability score out of bounds (0-30).");
        }
        this.score = score;
        this.modifier = calculateModifier(score);
    }

    public int getModifier() {
        return modifier;
    }

    public String getModifierWithSign() {
        return modifier >= 0 ? "+" + modifier : "" + modifier;
    }

    private int calculateModifier(int score) {
        //To determine an ability modifier, subtract 10 fram the ability score
        //and then divide the result by 2 (round down).
        int afterSubtraction = score - 10;
        //Odd negative numbers are rounded UP as integers. To compensate, (afterSubtraction - 1) is added for negative numbers.
        return (afterSubtraction < 0 ? (afterSubtraction-1)/2 : afterSubtraction/2);
    }

    @Override
    public String toString() {
        return name + " " + score + "/" +  this.getModifierWithSign();
    }
}
