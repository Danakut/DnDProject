package cz.danakut.dnd;

public class HitPoints {

    private int maximum;
    private int current;
    private int temporary;

    HitPoints() {

    }

    HitPoints(int maximum) {
        setMaximum(maximum);
        current = maximum;
        temporary = 0;
    }

    int getMaximum() {
        return maximum;
    }

    void setMaximum(int maximum) {
        if (maximum < 0) {
            maximum = 0;
        }
        this.maximum = maximum;
    }

    int getCurrent() {
        return current + temporary;
    }

    void addHitPoints(int hitPointsToAdd) {
        int hitPoints = current + hitPointsToAdd;
        current = (hitPoints > maximum)? maximum : hitPoints;
    }

    void loseHitPoints(int hitPointsToLose) {
        //First subtract temporary HP, if there are any. Any leftover damage lowers current HP. If all damage is soaked by
        //temporary HP, adjust the remaining TP accordingly.
        int hitPointsToLoseAfterApplyingTemporary = 0;
        if (temporary > 0) {
            hitPointsToLoseAfterApplyingTemporary = hitPointsToLose - temporary;
        }

        if (hitPointsToLoseAfterApplyingTemporary >= 0) {
            removeTemporary();
            current -= hitPointsToLoseAfterApplyingTemporary;
        } else {
            temporary -= hitPointsToLose;
        }
    }

    int getTemporary() {
        return temporary;
    }

    void addTemporary(int temporaryHitPoints) {
        if (temporaryHitPoints < 0) {
            temporaryHitPoints = 0;
        }
        this.temporary = temporaryHitPoints;
    }

    void removeTemporary() {
        this.temporary = 0;
    }


}
