package cz.danakut.dnd;

import cz.danakut.dnd.enums.Condition;
import cz.danakut.dnd.enums.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Race {
    Enum subrace;
    static Speed speed;
    static Size size;
    static List<Condition.Language> languages;

    Race() {

    }

    Race(Enum subrace) {
        this.subrace = subrace;
    }
}

class Dwarf extends Race {
    enum Subrace {
        HILL,
        MOUNTAIN
    }

    static Speed speed = new Speed(25);
    static Size size = Size.MEDIUM;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON, Condition.Language.DWARVISH));

    Dwarf(Subrace subrace) {
        super(subrace);
    }
}

class Elf extends Race {
    enum Subrace {
        HIGH,
        WOOD,
        DARK
    }

    static Speed speed = new Speed(30);
    static Size size = Size.MEDIUM;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON, Condition.Language.ELVISH));

    Elf(Subrace subrace) {
        super(subrace);
    }
}

class Halfling extends Race {
    enum Subrace {
        LIGHTFOOT,
        STOUT
    }

    static Speed speed = new Speed(25);
    static Size size = Size.SMALL;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON, Condition.Language.HALFLING));

    Halfling(Subrace subrace) {
        super(subrace);
    }
}

class Human extends Race {
    static Speed speed = new Speed(30);
    static Size size = Size.MEDIUM;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON));

    //+one extra language
}

class Dragonborn extends Race {
    static Speed speed = new Speed(30);
    static Size size = Size.MEDIUM;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON, Condition.Language.DRACONIC));
}

class Gnome extends Race {
    enum Subrace {
        FOREST,
        ROCK
    }

    static Speed speed = new Speed(25);
    static Size size = Size.SMALL;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON, Condition.Language.GNOMISH));

    Gnome(Subrace subrace) {
        super(subrace);
    }
}

class Half_elf extends Race {
    static Speed speed = new Speed(30);
    static Size size = Size.MEDIUM;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON, Condition.Language.ELVISH));

    //+one extra language
}

class Half_orc extends Race {
    static Speed speed = new Speed(30);
    static Size size = Size.MEDIUM;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON, Condition.Language.ORC));
}

class Tiefling extends Race {
    static Speed speed = new Speed(30);
    static Size size = Size.MEDIUM;
    static List<Condition.Language> languages = new ArrayList<>(Arrays.asList(Condition.Language.COMMON, Condition.Language.INFERNAL));
}


