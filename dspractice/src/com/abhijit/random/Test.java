package com.abhijit.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test {
	public static int printMaxSeq(int input[]){
		HashSet<Integer> holder = new HashSet<Integer>(); 
		for(int in:input){
			holder.add(in);
		}
		
		int maxLength = 0;
		for(int i=0;i<input.length;i++){
			if(! holder.contains(input[i]-1)){
				int firstE = input[i];
				while(holder.contains(firstE)){
					firstE++;
				}
				if((firstE-input[i]) > maxLength ){
					maxLength = (firstE-input[i]);
				}
			}
		}
		return maxLength;
	}
	
	public static int[] reverse(int rev[],int n){
		int s = 0 ;
		int end = n-1;
	
		return rev;
	}

	
	public static int getMaxCount(int input[]){
		int max_so_far =Integer.MIN_VALUE;
		int max_ending_here = 0;
		for(int i=0;i<input.length;i++){
			max_ending_here = max_ending_here + input[i];
			if(max_ending_here > max_so_far){
				max_so_far = max_ending_here;
			}
			if(max_ending_here <0){
				max_ending_here =0;
			}
			
		}		
		return -1;
		
	}
	public static void main(String argsp[]){
		int arr[] =  {1, 9, 3, 10, 4, 20, 2};
		System.out.println(printMaxSeq(arr));
	}
}
