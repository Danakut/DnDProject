package cz.danakut.dnd.newgui;

public class WindowRunner {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(WindowRunner::run);

    }

    private static void run() {
        MainWindow window = new MainWindow();
        window.createAndShowGUI();
    }
}
