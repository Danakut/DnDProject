package cz.danakut.dnd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    public static final int INITIAL_SKILL_VALUE = 0;


    public static String convertToTextWithFirstCapitalLetters(String toConvert) {
        String changedString;

        if (toConvert.contains("_")) {
            changedString = replaceKnownUderscores(toConvert);
        } else {
            changedString = toConvert;
        }

        String result = capitalizeEveryFirstLetter(changedString);
        return result;
    }

    private static String capitalizeEveryFirstLetter(String uncapitalizedWords) {
        String uncapitalized[] = uncapitalizedWords.split(" ");
        String capitalized[] = new String[uncapitalized.length];

        for (int i = 0; i < uncapitalized.length; i++) {
            String word = uncapitalized[i];
            String firstLetter = word.substring(0,1).toUpperCase();
            String otherLetters = word.substring(1, word.length()).toLowerCase();
            capitalized[i] = firstLetter + otherLetters;

        }
        String capitalizedWords = "";
        for (String word : capitalized) {
            capitalizedWords += word + " ";
        }

        //trim() removes one redundant space after last word
        return capitalizedWords.trim();
    }

    private static String replaceKnownUderscores(String toReplace) {
        String changedString = null;
        changedString = checkPatternsAndReplaceUnderscoresWith(TextPatterns.whitespacePatterns, " ", toReplace);
        //if a matching pattern has been found in whitespacePatterns, matching with hyphenPatterns is skipped
        // (as there is only one match in all TextPatterns)
        if (changedString == null) {
            changedString = checkPatternsAndReplaceUnderscoresWith(TextPatterns.hyphenPatterns, "-", toReplace);
        }
        return changedString;
    }

    private static String checkPatternsAndReplaceUnderscoresWith(List<Pattern> patternsToCheck, String replaceWith, String toCheck) {
        String correctedString = null;
        for (Pattern pattern : patternsToCheck) {
            Matcher matcher = pattern.matcher(toCheck);
            if (matcher.matches()) {
                correctedString = toCheck.replaceAll("_", replaceWith);
            }
        }
        return correctedString;
    }

    private static class TextPatterns {
        private static List<Pattern> whitespacePatterns = new ArrayList<>();
        private static List<Pattern> hyphenPatterns = new ArrayList<>();
        static {
            whitespacePatterns.add(Pattern.compile("sleight_of_hand", Pattern.CASE_INSENSITIVE));
            whitespacePatterns.add(Pattern.compile("animal_handling", Pattern.CASE_INSENSITIVE));
            hyphenPatterns.add(Pattern.compile("half_elf", Pattern.CASE_INSENSITIVE));
            hyphenPatterns.add(Pattern.compile("half_orc", Pattern.CASE_INSENSITIVE));
        }

    }

}


