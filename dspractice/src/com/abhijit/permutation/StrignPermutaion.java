package com.abhijit.permutation;

import java.util.HashMap;
import java.util.Map;

public class StrignPermutaion {
	public void permute(String inputStr){
		char[] inputArray = inputStr.toCharArray();
		Map<Character, Integer> mapOfCharAndNumber = new HashMap<Character, Integer>();
		for(char ichar:inputArray){
			mapOfCharAndNumber.compute(ichar, (k,v) -> {
				if(v == null){
					return 1;
				}else{
					return v +1 ;
				}				
			});			
		}

		char[] str = new char[mapOfCharAndNumber.size()];
		int[] count = new int[mapOfCharAndNumber.size()];
		int index = 0;
		for(Map.Entry<Character, Integer> mapEntry: mapOfCharAndNumber.entrySet()){
			str[index] = mapEntry.getKey();
			count[index] = mapEntry.getValue();
			index++;
		}

		char[] result = new char[inputStr.length()];
		permuteUtil(str, count, result, 0);
	}

	public void permuteUtil(char str[], int count[], char result[], int level ){
		
		if(level == result.length){
		printArray(result);
			return;
		}

		for(int i=0 ; i< str.length; i++){
			if(count[i] == 0){
				continue;
			}
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level+1);
			count[i]++;
		}


	}

	public static void main(String args[]){
		StrignPermutaion sp = new StrignPermutaion();
		sp.permute("abccdeefff");

	}

	public void printArray(char result[]){
		for(char cc: result){
			System.out.print(cc);

		}
		System.out.println("");
	}

}
