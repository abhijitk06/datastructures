package com.abhijit.ctci;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CommanElementsInSortedArray {
	public void getCommanElements(int array1[], int array2[]){
		LinkedList<Integer> result = new LinkedList<Integer>();
		for(int i =0; i < array1.length; i ++){
			for(int j =0; j < array2.length; j ++){
			   if(array1[i] == array2[j]){
				   result.add(array1[i]);
			   }
			}
		}
	}
	
	public void getCommanElementByHashSet(int array1[], int array2[]){
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i =0; i < array1.length; i ++){
			if(hm.containsKey(array1[i])){
				hm.put(array1[i], hm.get(array1[i])+1);	
			}else{
				hm.put(array1[i], 1);	
			}			
		}
		
	}

}
