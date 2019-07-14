package cz.danakut.dnd.gui;

import cz.danakut.dnd.CharacterData;
import cz.danakut.dnd.ClassLevel;

import java.util.List;

public class FileParser {

    CharacterData data;

    public FileParser(CharacterData data) {
        this.data = data;
    }

    public StringBuilder characterToText() {
       StringBuilder text = new StringBuilder();
       text.append("Name: " + data.getCharacterName() + "\n");
       text.append("Sex: " + data.getSex() + "\n");
       text.append("Race: " + data.getRace().getSubrace() + "\n");
       text.append("Size: " + data.getSize() + "\n");
       text.append("Speed: " + data.getSpeed() + "\n");
       text.append("Level: " + listContents(data.getLevels()) + "\n");
       text.append("Skills: " + listContents(data.getSkillProficiencies()) + "\n");
       return text;
   }

    private <T> String listContents(List<T> list) {
        String contentInString = new String();
        for (T contentPiece : list) {
            contentInString += contentPiece.toString();
        }

        return contentInString;
    }
}
