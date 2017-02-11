package com.abhijit.permutation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringCombination {
	public void combine(String inputStr){
		char inputChar[] = inputStr.toCharArray();
		Map<Character,Integer> mapOfCharAndInt= new HashMap<Character,Integer>();
		for(char iChar:inputChar){

			mapOfCharAndInt.compute(iChar, (k,v) ->{
				if(v == null){
					return 1;
				}else{
					return v+1;
				}
			}
			);
		}
		
		char str[] = new char[mapOfCharAndInt.size()];
		int num[] = new int[mapOfCharAndInt.size()];
		int i =0;
		for(Entry<Character, Integer> mEntry: mapOfCharAndInt.entrySet()){
			str[i] = mEntry.getKey();
			num[i] = mEntry.getValue();
			i++;
		}
		char result[] = new char[inputStr.length()];
		
		computeUtil(str, num,0, result, 0);
		
	}
    
	public void printArray(char result[], int len){
	 for(int i =0; i < len; i++){
		 System.out.print(result[i]);
	 }
	 System.out.println("");
	}

	public void computeUtil(char[] inputChar, int[] num, int pos, char[] result, int level){	
		printArray(result,pos);

		if(level == result.length){
			
				return;
			}
		for(int i=pos; i < inputChar.length; i++){
			if(num[i] == 0 ){
				continue;
			}
			result[level] = inputChar[i];
			num[i]--;	
			computeUtil(inputChar, num,i, result, level+1);
			num[i]++;
		}
	}
	
	public static void main(String args[]){
		StringCombination sc = new StringCombination();
		sc.combine("abc");
		
	}
}
