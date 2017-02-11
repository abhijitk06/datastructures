package com.abhijit.ctci;


public class ArrayLeftRotation {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		if(k ==0){
			return a;
		}else if(k>n){
			return arrayLeftRotation(a,n,(k-n));
		}else{
			int extra[] = new int[n];
			for(int i =0; i< n; i++){
				extra[i] = -1;
			}
			int newArray[] = new int[n];
			for(int i =n-1;i >= 0; i--){
				if((i-k) >= 0){
					newArray[i-k] = a[i];
				}else{
					int nInd = k-i;
					extra[(n-nInd)] = a[i];
				}
			}
			for(int i =0;i< extra.length;i++){
				if(extra[i] != -1){
					newArray[i]=extra[i];	
				}
				
			}
			return newArray;			
		}
	}
	
	

	public static void main(String[] args) {
		
		int n = 5;
		int k = 4;
		int a[] = new int[]{1,2,3,4,5};
		
		int[] output = new int[n];
		output = arrayLeftRotation(a, n, k);
		for(int i = 0; i < n; i++)
			System.out.print(output[i] + " ");

		System.out.println();

	}
}

