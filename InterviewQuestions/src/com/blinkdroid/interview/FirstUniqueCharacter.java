package com.blinkdroid.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The problem posed here, is find the first unique character in a given String.
 */
public class FirstUniqueCharacter {

  public static void main(String[] args) {
    findAndPrintFirstUniqueCharacter("jeffreyallenmartin");
    findAndPrintFirstUniqueCharacter("jeffreyallenmartinj");
    findAndPrintFirstUniqueCharacter("jeffreyallenmartinjy");
    findAndPrintFirstUniqueCharacter("jeffreyallenmartinjym");
    findAndPrintFirstUniqueCharacter("jeffreyallenmartinjymt");
    findAndPrintFirstUniqueCharacter("jeffreyallenmartinjymti");
  }
  
  private static void findAndPrintFirstUniqueCharacter(String inputString) {
    System.out.println("Word: " + inputString + " first unique: " + findFirstUniqueCharacterPerformant(inputString));
  }

  // This is a bit less coding since it uses some built-in functions, but is not as performant O(N^2)
  private static Character findFirstUniqueCharacter(String inputString) {
    Set<Character> visitedCharacters = new HashSet<>();
    
    // iterate over each character within the input string until the first unique one is found
    for (int i = 0; i < inputString.length(); i++) {
      final char currentChar = inputString.charAt(i);
      final String remainingString = inputString.substring(i+1);
      if (!visitedCharacters.contains(currentChar) && remainingString.indexOf(currentChar) == -1) {
        return currentChar;
      }
      visitedCharacters.add(currentChar);
    }
    return null;
  }

  // This is a bit faster since it runs in O(N) time
  private static String findFirstUniqueCharacterPerformant(String inputString) {
    String[] inputCharacters = inputString.split("");
    
    // first, construct a map to count the number of occurrences of each character
    Map<String, Integer> characterCounts = new HashMap<>();
    for (String currentCharacter : inputCharacters) {
      if (!characterCounts.containsKey(currentCharacter)) { // add it to the map if it is missing
        characterCounts.put(currentCharacter, 0);
      }
      characterCounts.put(currentCharacter, characterCounts.get(currentCharacter) + 1); // increment
    }
    
    // then, find the first unique character by consutling the count map
    for (String currentCharacter : inputCharacters) {
      if (characterCounts.get(currentCharacter) == 1) {
        return currentCharacter;
      }
    }
    
    // if not found, then return null
    return null;
  }

}
