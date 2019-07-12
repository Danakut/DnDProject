package cz.danakut.dnd.enums;

public enum Condition {
    BLINDED,
    CHARMED,
    DEAFENED,
    FRIGHTENED,
    GRAPPLED,
    INCAPACITATED,
    INVISIBLE,
    PARALYZED,
    PETRIFIED,
    POISONED,
    PRONE,
    RESTRAINED,
    STUNNED,
    UNCONSCIOUS;

    public static enum DamageType {

        ACID,
        BLUDGEONING,
        COLD,
        FIRE,
        FORCE,
        LIGHTNING,
        NECROTIC,
        PIERCING,
        POISON,
        PSYCHIC,
        RADIANT,
        SLASHING,
        THUNDER,

    }

    public static enum Language {
        COMMON,
        DWARVISH,
        ELVISH,
        GIANT,
        GNOMISH,
        GOBLIN,
        HALFLING,
        ORC,
        ABYSSAL,
        CELESTIAL,
        DRACONIC,
        DEEP_SPEECH,
        INFERNAL,
        PRIMORDIAL,
        SYLVAN,
        UNDERCOMMON
    }
}
