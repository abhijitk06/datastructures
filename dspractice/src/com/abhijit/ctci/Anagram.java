package com.abhijit.ctci;

import java.util.Arrays;

public class Anagram {
	
	public static int numberNeeded(String first, String second) {
		int[] lettercounts = new int[26];
		for(char c : first.toCharArray()){
			lettercounts[c-'a']++;
		}
		for(char c : second.toCharArray()){
			lettercounts[c-'a']--;
		}
		int result = 0;
		for(int i : lettercounts){
			result += Math.abs(i);
		}
		return result;
	}
	
	public static int numberNeededByJava8(String first, String second) {
        int[] freq = new int[26];
        first.chars().forEach((c) -> {
            freq[c - 97]++;
        });
        second.chars().forEach((c) -> {
            freq[c - 97]--;
        });
        return Arrays.stream(freq).map(Math::abs).sum();
}
	
	/*
	 * c - 'a' is the index of the array, which shold be an integer, so as you can see: if the char is a the index will be 0, and if the char is b then the index will be 1, and so on
PS: - 'a' is equivalent of - 97 according to ASCII table, except that it has a clearer expression of intention.
	 * 
	 * 
	 */

}
