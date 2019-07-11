package cz.danakut.dnd;

public abstract class Race {
    Enum subrace;

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

    Elf(Subrace subrace) {
        super(subrace);
    }
}

class Halfling extends Race {
    enum Subrace {
        LIGHTFOOT,
        STOUT
    }

    Halfling(Subrace subrace) {
        super(subrace);
    }
}

class Human extends Race {

}

class Dragonborn extends Race {

}

class Gnome extends Race {
    enum Subrace {
        FOREST,
        ROCK
    }

    Gnome(Subrace subrace) {
        super(subrace);
    }
}

class Half_elf extends Race {
}

class Half_orc extends Race {
}

class Tiefling extends Race {
}


