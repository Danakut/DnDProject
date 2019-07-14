package cz.danakut.dnd;

import cz.danakut.dnd.gui.MainScreen;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::run);

    }

    private static void run() {
        MainScreen screen = new MainScreen();
        screen.setVisible(true);
    }
}
