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
        panel.setName("Hitpoints");
        panel.setBorder(titledBorderWithTitle(panel.getName()));

        JLabel label = new JLabel();
        label.setName("Max");
        label.setText(label.getName());
        panel.add(label, "cell 0 0");

        label = new JLabel();
        label.setName("Current");
        label.setText(label.getName());
        panel.add(label, "cell 1 0");

        label = new JLabel();
        label.setName("Temporary");
        label.setText(label.getName());
        panel.add(label, "cell 2 0");

        label = new JLabel();
        label.setText("20");
        panel.add(label, "cell 0 1");

        label = new JLabel();
        label.setText("10");
        panel.add(label, "cell 1 1");

        label = new JLabel();
        label.setText("0");
        panel.add(label, "cell 2 1");

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
                "[fill, grow]" +
                        "[]" +
                        "[]",
                // rows
                panelRows));
        panel.setName("Skill Proficiencies");
        panel.setBorder(titledBorderWithTitle(panel.getName()));

        //fix to widen the panel to accomodate the full width of the title
        panel.setMinimumSize(new Dimension(180, 20));


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
}
