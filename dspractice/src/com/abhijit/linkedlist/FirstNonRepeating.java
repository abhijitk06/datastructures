package com.abhijit.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeating {
	public static Character getFirstNonRepeating(String str){
		char[] carArray = str.toCharArray();
		Map<Character,Integer> sfs = new HashMap<Character, Integer>();
		for(char cc: carArray){
			if(sfs.containsKey(cc)){
				sfs.put(cc, sfs.get(cc)+1);
			}else{
				sfs.put(cc, 1);
			}
		}
		for(char cc: carArray){
			if(sfs.get(cc) == 1){
				return cc;
			}
		}
		return null;
		
	}
	
	public static void main(String[] args){
		System.out.println(getFirstNonRepeating("stress"));
		
	}

}
