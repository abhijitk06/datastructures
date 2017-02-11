package com.abhijit.ctci;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Median {

	public static void main(String args[]){
		Median mm = new Median();
		for(int i =1 ; i < 11 ; i++){
			mm.add(i);
            mm.printMedian();
		}
	}


	int size;
	int capacity =10;
	double items[] = new double[capacity];
	float median;

	public void ensureCapacity(){
		if(capacity == size){
			items = Arrays.copyOf(items, 2*capacity);
			capacity *= 2;
		}
	}

	public void add(int num){
		ensureCapacity();
		items[size] = num;
		size ++;
		updateMedian();

	}

	public boolean isEven(){
		return (size %2 == 0 );
	}

	public void swap(int i, int j){
		double temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	public void sortItems(){
		int index = 0;
		while(index < size-1 ){
			if(items[index] > items[index+1]){
				swap(index, index+1);
			}
			index ++;
		}		
	}
	public void updateMedian(){
		sortItems();
		double num;
		if(isEven()){
			num = (items[size/2] +(items[(size/2)-1])) ;
			median = (float) (num/2.0f);
		}else{
			num = items[size/2];
			median = (float)(num *1.0f);
		}
	}

	public void printMedian(){
		DecimalFormat df = new DecimalFormat("#.#");
		System.out.println((median));
	}

}
