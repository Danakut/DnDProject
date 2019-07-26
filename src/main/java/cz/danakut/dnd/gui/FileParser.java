package cz.danakut.dnd.gui;

import cz.danakut.dnd.CharacterData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileParser {

    CharacterData data;

    public FileParser(CharacterData data) {
        this.data = data;
    }

    public void saveCharacterDataToFile(Path file) {
        String characterText = characterToText();
        saveTextToFile(file, characterText);
    }

    private String characterToText() {
       StringBuilder text = new StringBuilder();
       text.append("Name: " + data.getCharacterName() + "\n");
       text.append("Sex: " + data.getSex() + "\n");
       text.append("Race: " + data.getRace().getSubrace() + "\n");
       text.append("Size: " + data.getSize() + "\n");
       text.append("Speed: " + data.getSpeed() + "\n");
       text.append("Level: " + listContents(data.getLevels()) + "\n");
       text.append("Skills: " + listContents(data.getSkillProficiencies()) + "\n");
       return text.toString();
   }

    private <T> String listContents(List<T> list) {
        String contentInString = new String();
        for (T contentPiece : list) {
            contentInString += contentPiece.toString() + " | " ;
        }

        String deletedTrailingPipe = contentInString.substring(0, contentInString.length() - 3);
        return deletedTrailingPipe;
    }

    private void saveTextToFile (Path file, String text) {
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write(text);
        } catch (IOException ex) {
        }

    }

}
