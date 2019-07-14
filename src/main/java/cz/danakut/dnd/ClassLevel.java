package cz.danakut.dnd;

import cz.danakut.dnd.enums.DndclassName;

public class ClassLevel {

    int level;
    DndclassName className;

    public ClassLevel(int level, DndclassName className) {
        this.level = level;
        this.className = className;
    }
}
