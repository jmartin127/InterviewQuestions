package com.blinkdroid.interview.bubble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Basic implementations of the bubble support in preparation for interviewing
 */
public class BubbleSortRunner {

	public static void main(String[] args) {
		// character sort of a String
		System.out.println(bubbleSortString("Testing"));
		System.out.println(bubbleSortString("Hello my name is jeff, what is your name"));
		
		// List<Integer> sort
		Integer[] phoneNumber = new Integer[] {8,0,1,6,6,1,5,9,3,6};
		List<Integer> listOne = Arrays.asList(phoneNumber);
		System.out.println(bubbleSortIntegerList(listOne));
		
		// Generic sort (Integer example)
		List<Integer> listTwo = Arrays.asList(phoneNumber);
		System.out.println(bubbleSortGeneric(listTwo));
		
		// Generic sort (String example)
		List<String> wordList = Arrays.asList("The quick brown fox jumps over the lazy do".split(" "));
		System.out.println(bubbleSortGeneric(wordList));
	}
	
	private static String bubbleSortString(String input) {
		if (input == null) {
			return "";
		}
		
		final char[] inputArray = input.toCharArray();
		boolean hasFinished = false;
		
		while (!hasFinished) {
			hasFinished = true;
			for (int i = 0; i < inputArray.length-1; i++) {
				final char firstChar = inputArray[i];
				final char secondChar = inputArray[i+1];
				if (firstChar > secondChar) {
					inputArray[i] = secondChar;
					inputArray[i+1] = firstChar;
					hasFinished = false;
				}
			}
		}
		
		return new String(inputArray);
	}
	
	private static List<Integer> bubbleSortIntegerList(List<Integer> input) {
		if (input == null) {
			return Collections.emptyList();
		}
		
		boolean hasFinished = false;
		while (!hasFinished) {
			hasFinished = true; // set to a clean state until a change is found
			for (int i = 0; i < input.size()-1; i++) {
				final Integer first = input.get(i);
				final Integer second = input.get(i+1);
				if (first > second) { // auto-boxing, TODO could run into NPE here
					input.set(i, second);
					input.set(i+1, first);
					hasFinished = false;
				}
			}
		}
		
		return input; // for chaining together method calls
	}
	
	private static <T extends Comparable<T>> List<T> bubbleSortGeneric(List<T> input) {
		if (input == null) {
			return new ArrayList<T>();
		}
		
		boolean hasFinished = false;
		while (!hasFinished) {
			hasFinished = true;
			for (int i = 0; i < input.size() - 1; i++) {
				T first = input.get(i);
				T second = input.get(i + 1);
				if (input.get(i).compareTo(second) > 0) { // TODO could run into NPE here
					input.set(i, second);
					input.set(i + 1, first);
					hasFinished = true;
				}
			}
		}
		
		return input;
	}

}
