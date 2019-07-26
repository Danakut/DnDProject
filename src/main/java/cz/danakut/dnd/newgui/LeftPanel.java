package cz.danakut.dnd.newgui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import cz.danakut.dnd.CharacterData;
import cz.danakut.dnd.PlayerSkill;
import cz.danakut.dnd.enums.SkillName;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftPanel extends JPanel {

    private static final Color MENUBAR_COLOR = new Color(255,153,42);
    private static final Dimension FRAME_SIZE = new Dimension(800,600);
    private static final String MENUTEXT_CREATE_CHARACTER = "Create New Character";
    private static final String MENUTEXT_LOAD_FILE = "Load Character from File";
    private static final String MENUTEXT_SAVE_FILE = "Save Character to File";
    private static final float FONTSIZE_DEFAULT = 16.0f;
    private static final float FONTSIZE_TITLE = 16.0f;
    private static final float FONTSIZE_MENU = 20.0f;
    private static final List<String> ABILITY_NAMES  = Arrays.asList("Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma");
    private static final int PROFICIENCIES_PANEL_MINWIDTH = 190;

    private Font defaultFont;
    private Font titleFont;

    public LeftPanel(PanelSettings settings) {
        super(new MigLayout("hidemode 3",
                // columns
                "[]" +
                        "[]",
                // rows
                "[]" +
                        "[]" +
                        "[]"));

        defaultFont = (Font) settings.get("defaultFont");
        titleFont = (Font) settings.get("titleFont");

        this.setBackground(Color.blue);
        this.add(portrait(), "cell 0 0");
        this.add(abilities(), "cell 0 1");
        this.add(bio(), "cell 1 0");
        this.add(acInitSpeed(), "cell 1 1");
        this.add(hitpoints(), "cell 1 2 ");
        this.add(skillProficiencies(), "cell 0 2");
        this.add(otherProficiencies(), "cell 0 3");
        this.add(classesAndLevels(), "cell 0 4");
    }

    private JPanel portrait() {
        JPanel panel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[]",
                // rows
                "[]"));
        panel.setName("Portrait");

        JLabel label = new JLabel();
        label.setMaximumSize(new Dimension(200,200));
        label.setIcon(new ImageIcon("/home/dana/Pictures/npc pics/charrrrr.png"));
        panel.add(label);

        return panel;
    }

    private JPanel abilities() {
        JPanel panel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[]" +
                        "[]" +
                        "[]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));
        panel.setName("Abilities");
        panel.setBorder(titledBorderWithTitle(panel.getName()));

        for (int i = 0; i < ABILITY_NAMES.size() ; i++) {
            JLabel label = new JLabel();
            label.setName(ABILITY_NAMES.get(i));
            label.setText(ABILITY_NAMES.get(i));
            panel.add(label, "cell 0 " + i);
        }

        for (int i = 0; i < ABILITY_NAMES.size(); i++) {
            JLabel label = new JLabel();
            label.setText("12");
            panel.add(label, "cell 1 " + i);
        }

        for (int i = 0; i < ABILITY_NAMES.size(); i++) {
            JLabel label = new JLabel();
            label.setText("+1");
            panel.add(label, "cell 2 " + i);
        }

        return panel;
    }

    private TitledBorder titledBorderWithTitle(String title) {
        return new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, titleFont);
    }

    private JPanel bio() {
        JPanel panel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[]" +
                        "[]" +
                        "[]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));
        panel.setName("Bio");
        panel.setBorder(titledBorderWithTitle(panel.getName()));

        JLabel label = new JLabel();
        label.setName("Race");
        label.setText(label.getName() + ": ");
        panel.add(label, "cell 0 0");

        label = new JLabel();
        label.setName("Sex");
        label.setText(label.getName() + ": ");
        panel.add(label, "cell 0 1");

        label = new JLabel();
        label.setName("Age");
        label.setText(label.getName() + ": ");
        panel.add(label, "cell 1 1");

        label = new JLabel();
        label.setName("Alignment");
        label.setText(label.getName() + ": ");
        panel.add(label, "cell 0 2");

        label = new JLabel();
        label.setName("Background");
        label.setText(label.getName() + ": ");
        panel.add(label, "cell 0 3");

        return panel;
    }

    private JPanel acInitSpeed() {
        JPanel panel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[]" +
                        "[]" +
                        "[]",
                // rows
                "[]" +
                        "[]"));
        panel.setName("AcInitSpeed");

        JLabel label = new JLabel();
        label.setName("AC");
        label.setText(label.getName());
        panel.add(label, "cell 0 0");

        label = new JLabel();
        label.setName("Initiative");
        label.setText(label.getName());
        panel.add(label, "cell 1 0");

        label = new JLabel();
        label.setName("Speed");
        label.setText(label.getName());
        panel.add(label, "cell 2 0");

        label = new JLabel();
        label.setText("20");
        panel.add(label, "cell 0 1");

        label = new JLabel();
        label.setText("10");
        panel.add(label, "cell 1 1");

        label = new JLabel();
        label.setText("30 feet");
        panel.add(label, "cell 2 1");

        return panel;
    }

    private JPanel hitpoints() {
        JPanel panel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[]" +
                        "[]" +
                        "[]",
                // rows
                "[]" +
                        "[]"));
        panel.setName("HP & Hit Dice");
        panel.setBorder(titledBorderWithTitle(panel.getName()));

        JLabel label = new JLabel();
        label.setText("Hitpoints");
        panel.add(label, "cell 0 0 2 1");

        label = new JLabel();
        label.setName("Max");
        label.setText(label.getName());
        panel.add(label, "cell 0 1");

        label = new JLabel();
        label.setName("Current");
        label.setText(label.getName());
        panel.add(label, "cell 1 1");

        label = new JLabel();
        label.setName("Temporary");
        label.setText(label.getName());
        panel.add(label, "cell 2 1");

        label = new JLabel();
        label.setText("20");
        panel.add(label, "cell 0 2");

        label = new JLabel();
        label.setText("10");
        panel.add(label, "cell 1 2");

        label = new JLabel();
        label.setText("0");
        panel.add(label, "cell 2 2");

        label = new JLabel();
        label.setText("Hit Dice");
        panel.add(label, "cell 0 4 2 1");

        label = new JLabel();
        label.setName("Total");
        label.setText(label.getName());
        panel.add(label, "cell 0 5");

        label = new JLabel();
        label.setName("Left");
        label.setText(label.getName());
        panel.add(label, "cell 1 5");

        label = new JLabel();
        label.setText("6");
        panel.add(label, "cell 0 6");

        label = new JLabel();
        label.setText("4");
        panel.add(label, "cell 1 6");


        return panel;
    }

    private JPanel skillProficiencies() {
        String panelRows = "";
        //docasne reseni, bude nahrazeno modelem postavy z character enginu
        List<String> listOfSkills = new ArrayList<>();
        SkillName[] values = SkillName.values();
        for (int i = 0; i < values.length; i++) {
            panelRows += "[]";
            listOfSkills.add(values[i].toString());
        }
        //
        JPanel panel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[grow]" +
                        "[]" +
                        "[]",
                // rows
                panelRows));
        panel.setName("Skill Proficiencies");
        panel.setBorder(titledBorderWithTitle(panel.getName()));

        //fix to widen the panel to accomodate the full width of the title
        panel.setMinimumSize(new Dimension(PROFICIENCIES_PANEL_MINWIDTH, 1));


        JLabel label = new JLabel();
        label.setName(listOfSkills.get(0).toLowerCase());
        label.setText(label.getName());
        panel.add(label, "cell 0 0");

        label = new JLabel();
        label.setText("8");
        panel.add(label, "cell 1 0");

        label = new JLabel();
        label.setText("*");
        panel.add(label, "cell 2 0");

        label = new JLabel();
        label.setName(listOfSkills.get(1).toLowerCase());
        label.setText(label.getName());
        panel.add(label, "cell 0 1");

        label = new JLabel();
        label.setText("10");
        panel.add(label, "cell 1 1");

        label = new JLabel();
        label.setText("");
        panel.add(label, "cell 2 1");

        return panel;
    }

    private JPanel otherProficiencies() {
        String panelRows = "";
        //docasne reseni, bude nahrazeno modelem postavy z character enginu
        List<String> listOfSkills = Arrays.asList("Simple Weapons", "Shields", "Artisan's Tools");
        for (int i = 0; i < listOfSkills.size(); i++) {
            panelRows += "[]";
        }
        //
        JPanel panel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[grow]" +
                        "[]" +
                        "[]",
                // rows
                panelRows));
        panel.setName("Other Proficiencies");
        panel.setBorder(titledBorderWithTitle(panel.getName()));

        //fix to widen the panel to accomodate the full width of the title
        panel.setMinimumSize(new Dimension(PROFICIENCIES_PANEL_MINWIDTH, 1));


        JLabel label = new JLabel();
        label.setName(listOfSkills.get(0).toLowerCase());
        label.setText(label.getName());
        panel.add(label, "cell 0 0");

        label = new JLabel();
        label.setText("9");
        panel.add(label, "cell 1 0");

        label = new JLabel();
        label.setText("*");
        panel.add(label, "cell 2 0");

        label = new JLabel();
        label.setName(listOfSkills.get(1).toLowerCase());
        label.setText(label.getName());
        panel.add(label, "cell 0 1");

        label = new JLabel();
        label.setText("10");
        panel.add(label, "cell 1 1");

        label = new JLabel();
        label.setText("");
        panel.add(label, "cell 2 1");

        label = new JLabel();
        label.setName(listOfSkills.get(2).toLowerCase());
        label.setText(label.getName());
        panel.add(label, "cell 0 2");

        label = new JLabel();
        label.setText("4");
        panel.add(label, "cell 1 2");

        label = new JLabel();
        label.setText("*");
        panel.add(label, "cell 2 2");


        return panel;
    }

    private JPanel classesAndLevels() {
        JPanel panel = new JPanel(new MigLayout("hidemode 3",
                // columns
                "[][]",
                // rows
                "[][]"));
        //vytvorit metodu, ktera vymysli pocet radku pro kazdou viceradkovou polozku, kde neni pocet radku predem znam
        panel.setName("Classes & Levels");
        panel.setBorder(titledBorderWithTitle(panel.getName()));
        //spolecna metoda na nastaveni sirky - rozdeleni dle druhu panelu?
        panel.setMinimumSize(new Dimension(165,1));

        JLabel label = new JLabel();
        label.setText("Cleric");
        panel.add(label, "cell 0 0");

        label = new JLabel();
        label.setText("Fighter");
        panel.add(label, "cell 0 1");

        label = new JLabel();
        label.setText("4");
        panel.add(label, "cell 1 0");

        label = new JLabel();
        label.setText("2");
        panel.add(label, "cell 1 1");

        label = new JLabel();
        label.setName("Experience");
        label.setText(label.getName());
        panel.add(label, "cell 0 3");

        panel.addLabelWithTextAndOrName("Experience", null, 0, 3);

        label = new JLabel();
        label.setText("2856");
        panel.add(label, "cell 1 3");

        return panel;
    }
}
