package cz.danakut.dnd.newgui;

import cz.danakut.dnd.CharacterData;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

public class MainWindow extends JFrame {

    private static final Color MENUBAR_COLOR = new Color(255,153,42);
    private static final Dimension FRAME_SIZE = new Dimension(800,600);
    private static final String MENUTEXT_CREATE_CHARACTER = "Create New Character";
    private static final String MENUTEXT_LOAD_FILE = "Load Character from File";
    private static final String MENUTEXT_SAVE_FILE = "Save Character to File";
    private static final float FONTSIZE_DEFAULT = 16.0f;
    private static final float FONTSIZE_TITLE = 16.0f;
    private static final float FONTSIZE_MENU = 20.0f;
    private static final List<String> ABILITY_NAMES  = Arrays.asList("Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma");

    private Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();


    private JFrame frame;
    JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu files;
    JPanel leftPanel;
    JPanel rightPanel;
    Font defaultFont;
    Font titleFont;


    public void createAndShowGUI() {

        createAndSetTopFrame();

        createMenuAndSetToFrame();
        createContentPaneAndSetToFrame();
        setUpBasicFonts();
        createAndSetLeftPanel();
        createAndSetRightPanel();
        displayWindow();
    }



    private void createAndSetTopFrame() {
        frame = new JFrame("DnD Character Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createMenuAndSetToFrame() {
        menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(MENUBAR_COLOR);
        menuBar.add(createFilesMenu());
        frame.setJMenuBar(menuBar);
    }

    private JMenu createFilesMenu() {
        JMenu menu = new JMenu("Files");
        fillMenuWith(menu, MENUTEXT_CREATE_CHARACTER, MENUTEXT_LOAD_FILE, MENUTEXT_SAVE_FILE);
        Font font = menu.getFont().deriveFont(FONTSIZE_MENU);
        menu.setFont(font);
        return menu;
    }

    private void fillMenuWith(JMenu menuToFill, String... itemNames) {
        for (String itemName : itemNames) {
            JMenuItem item = new JMenuItem(itemName);
            item.addActionListener(e -> filesMenuItemActivated(e));
            Font currentFont = item.getFont();
            Font newFont = currentFont.deriveFont(Font.PLAIN,20.0f);
            item.setFont(newFont);
            menuToFill.add(item);
        }
    }

    private void filesMenuItemActivated(ActionEvent e) {
        JMenuItem sourceMenuItem = (JMenuItem) e.getSource();

        //predelat na actionCommand misto rozpoznavani textem (ktery se muze zmenit?)?
        String sourceText = sourceMenuItem.getText();
        if (sourceText.equals(MENUTEXT_LOAD_FILE)) {
            //load file
        }
        if (sourceText.equals(MENUTEXT_SAVE_FILE)) {
            //save file
        }
    }

    private void createContentPaneAndSetToFrame() {
        contentPane = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[fill, grow]" +
                "[fill, grow]",
                // rows
                "[fill, grow]" +
                "[]"));
        frame.setContentPane(contentPane);
    }

    private void setUpBasicFonts() {
        JLabel testLabel = new JLabel();
        testLabel.setBorder(new TitledBorder("Test"));
        defaultFont = testLabel.getFont().deriveFont(FONTSIZE_DEFAULT);
        TitledBorder border = (TitledBorder) testLabel.getBorder();
        titleFont = border.getTitleFont().deriveFont(FONTSIZE_TITLE);
    }

    private void displayWindow() {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createAndSetLeftPanel() {
        PanelSettings settings = new PanelSettings();
        settings.put("defaultFont", defaultFont);
        settings.put("titleFont", titleFont);
        contentPane.add(new LeftPanel(settings), "cell 0 0");
    }


    /*---------------------------------right panel stuff---------------------------*/

    private void createAndSetRightPanel() {
        rightPanel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[]" +
                        "[]" +
                        "[]",
                // rows
                "[]" +
                        "[]" +
                        "[]"));
        rightPanel.setBackground(Color.red);
        contentPane.add(rightPanel, "cell 1 0");
    }

}
