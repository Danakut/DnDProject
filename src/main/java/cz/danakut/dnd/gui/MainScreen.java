/*
 * Created by JFormDesigner on Sun Jul 14 16:19:14 CEST 2019
 */

package cz.danakut.dnd.gui;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import cz.danakut.dnd.Exceptions.FileSelectionAbortedException;
import net.miginfocom.swing.*;

/**
 * @author Dita Přikrylová
 */
public class MainScreen extends JFrame {
    public MainScreen() {
        initComponents();
        myContentPane = getContentPane();
    }

    private void mItemLoadFileActionPerformed() {
        Path fileToLoad = chooseFileToLoad();
//        handler.parseCharacter(fileToLoad);

    }

    private Path chooseFileToLoad() {
        JFileChooser chooser = setupFileChooser();
        Path pathToLoadFile = null;

        try {
            pathToLoadFile = acquireFilePathFromDialogue(chooser, JFileChooser.OPEN_DIALOG);
            checkIfFilePathExists(pathToLoadFile);
        } catch (FileSelectionAbortedException e) {
            //no action needed
        } catch (FileNotFoundException e) {
            //pop up info
        }

        return pathToLoadFile;
    }

    private JFileChooser setupFileChooser() {
        JFileChooser chooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Character Sheet - .chs", "chs");
        chooser.setFileFilter(filter);
        return chooser;
    }

    private Path acquireFilePathFromDialogue(JFileChooser chooser, int dialogueType) throws FileSelectionAbortedException {
        int returnValue = -1;
        if (dialogueType == JFileChooser.OPEN_DIALOG) {
            returnValue = chooser.showOpenDialog(myContentPane);
        } else if (dialogueType == JFileChooser.SAVE_DIALOG) {
            returnValue = chooser.showSaveDialog(myContentPane);
        }

        if (returnValue == JFileChooser.CANCEL_OPTION) {
            throw new FileSelectionAbortedException("Choose File dialogue cancelled by user.");
        }

        if (returnValue == JFileChooser.ERROR_OPTION) {
            throw new RuntimeException("An uknown error occured during file selection.");
        }


        Path file = chooser.getSelectedFile().toPath();
        return file;
    }

    private void checkIfFilePathExists(Path saveFile) throws FileNotFoundException {
        if (!Files.exists(saveFile)) {
            JOptionPane.showMessageDialog(myContentPane, "File " + saveFile.getFileName() + " not found.");
            throw new FileNotFoundException("File " + saveFile.getFileName() + " not found.");
        }
    }

    private Path chooseFileToSave() {
        JFileChooser chooser = setupFileChooser();
        Path pathToSaveFile = null;

        try {
            pathToSaveFile = acquireFilePathFromDialogue(chooser, JFileChooser.SAVE_DIALOG);
            checkForFileOverwrite(pathToSaveFile);
        } catch (FileSelectionAbortedException e) {
            //no action needed
        }

//        rewrite this to automatically add suffix
//        if (!soubor.getCharacterName().contains(".") && !soubor.exists()) {
//            soubor = new File(soubor.getParentFile(), soubor.getCharacterName() + ".blud");
//        }


        return pathToSaveFile;
    }

    private void checkForFileOverwrite(Path pathToSaveFile) throws FileSelectionAbortedException {
        if (Files.exists(pathToSaveFile)) {
            int overwriteConfirmation = JOptionPane.showConfirmDialog(myContentPane, "File " + pathToSaveFile.getFileName() + " already exists.\nOverwrite?", "Overwrite file?", JOptionPane.YES_NO_OPTION);
            if (overwriteConfirmation == JOptionPane.NO_OPTION) {
                throw new FileSelectionAbortedException("File " + pathToSaveFile.getFileName() + " overwrite rejected by user.");
            }
        }
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        mnBar = new JMenuBar();
        mnFile = new JMenu();
        mItemLoadFile = new JMenuItem();
        lblPortrait = new JLabel();
        lblName = new JLabel();
        lblClass = new JLabel();

        //======== this ========
        setTitle("Char Generator");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //======== mnBar ========
        {

            //======== mnFile ========
            {
                mnFile.setText("File");

                //---- mItemLoadFile ----
                mItemLoadFile.setText("text");
                mItemLoadFile.addActionListener(e -> mItemLoadFileActionPerformed());
                mnFile.add(mItemLoadFile);
            }
            mnBar.add(mnFile);
        }
        setJMenuBar(mnBar);

        //---- lblPortrait ----
        lblPortrait.setIcon(new ImageIcon("/home/dana/Pictures/npc pics/charrrrr.png"));
        contentPane.add(lblPortrait, "cell 0 0");

        //---- lblName ----
        lblName.setText("text");
        contentPane.add(lblName, "cell 0 1");

        //---- lblClass ----
        lblClass.setText("text");
        lblClass.setVisible(false);
        contentPane.add(lblClass, "cell 0 2");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JMenuBar mnBar;
    private JMenu mnFile;
    private JMenuItem mItemLoadFile;
    private JLabel lblPortrait;
    private JLabel lblName;
    private JLabel lblClass;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    Container myContentPane;


}
