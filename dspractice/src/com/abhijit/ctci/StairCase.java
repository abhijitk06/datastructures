package com.abhijit.ctci;

public class StairCase {

	public static int calcNum(int n) {
		int[] array = new int[n];
		if (n == 1) {
			return 1;
		}
		else if(n == 2) {
			return 2;
		}
		else if(n == 3) {
			return 4;
		}
		array[0] = 1;
		array[1] = 2;
		array[2] = 4;
		for (int i = 3; i < n; i++) {
			array[i] = array[i-1] + array[i-2] + array[i-3];
		}
		return array[array.length-1];
	}

	public static int getNumberOfWays(int height){

		if(height == 1 ){
			return 1;
		}
		if(height == 2){
			return 2;
		}
		if(height == 3){
			return 4;
		}
		int first = getNumberOfWays(height-1);

		int second = getNumberOfWays(height-2);
		int third = getNumberOfWays(height-3);

		int numOfWays = first + second + third;		
		return numOfWays;
	}

	public static void main(String args[]){
		int input[] = new int[]{32,33,35,36,36};
		for(int i:input){
			System.out.println(getNumberOfWays(i));
		}
		System.out.println("************");
		for(int i:input){
			System.out.println(calcNum(i));
		}
	}



}
