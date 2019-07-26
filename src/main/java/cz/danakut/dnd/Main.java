package cz.danakut.dnd;

import cz.danakut.dnd.gui.FileParser;
import cz.danakut.dnd.gui.MainScreen;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
//
//        CharacterData chardata = new CharacterData();
//        FileParser parser = new FileParser(chardata);
//        StringBuilder builder = parser.characterToText();
//        String characterToSave = builder.toString();
//        System.out.println(characterToSave);


        SwingUtilities.invokeLater(Main::run);

    }

    private static void run() {
        MainScreen screen = new MainScreen();
        screen.setVisible(true);
    }
}
