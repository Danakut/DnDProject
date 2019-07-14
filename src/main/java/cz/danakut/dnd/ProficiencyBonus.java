package cz.danakut.dnd;

public class ProficiencyBonus {

    public static int getBonusForCharacterLevel(int level) {
        if (level < 5) {
            return 2;
        } else if (level < 9) {
            return 3;
        } else if (level < 13) {
            return 4;
        } else if (level < 17) {
            return 5;
        } else return 6;
    }
}
