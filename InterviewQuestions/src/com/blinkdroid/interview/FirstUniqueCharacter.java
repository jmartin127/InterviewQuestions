package com.blinkdroid.interview;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
    System.out.println("Word: " + inputString + " first unique: " + findFirstUniqueCharacterPerformantWithLambda(inputString));
  }

  // Solution #1: This is a bit less coding since it uses some built-in functions, but is not as performant O(N^2)
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

  // Solution #2: This is a bit faster since it runs in O(N) time
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
  
  // Solution #3: This also runs in O(N) time, but is much more readable, and uses lambdas and the stream API from Java 8
  //              Also, it is only three lines of code!
  private static String findFirstUniqueCharacterPerformantWithLambda(String inputString) {
    final List<String> inputCharacters = Arrays.asList(inputString.split(""));
    
    // first, construct a map to count the number of occurrences of each character
    final Map<Object, Long> characterCounts = inputCharacters
        .stream()
        .collect(groupingBy(s -> s, counting()));
    
    // then, find the first unique character by consulting the count map
    return inputCharacters
        .stream()
        .filter(s -> characterCounts.get(s) == 1)
        .findFirst()
        .orElse(null);
  }

}
