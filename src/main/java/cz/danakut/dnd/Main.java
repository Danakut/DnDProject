package cz.danakut.dnd;

public class Main {

    public static void main(String[] args) {
        Creature one = new Creature();
        one.abilities = new Abilities(10,10,10,10,12,12);

        System.out.println(one.abilities);
    }
}
