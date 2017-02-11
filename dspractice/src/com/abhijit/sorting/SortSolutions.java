package com.abhijit.sorting;

public class SortSolutions {
	
	public void bubbleSort(int items[]){
		boolean isSorted = false;
		int lastUnsortedIndex = items.length-1;
		while(!isSorted){
			for(int i=0; i < lastUnsortedIndex; i++){
				if(items[i] > items[i+1]){
		             swap(i,i+1,items);
				}
			}	
			lastUnsortedIndex--;
			if(lastUnsortedIndex == 0){
				isSorted = true;
			}
		}
	}
	
	public void mergeSort(int items[]){
		int temp[] = new int[items.length];
		mergerSort(items, 0,items.length,temp);
		
	}
	
	public void mergerSort(int items[], int leftStart, int rightEnd,int temp[]){
		if(leftStart >= rightEnd){
			return;
		}
		int middle = (leftStart + rightEnd)/2;
		mergerSort(items, leftStart, middle,temp);
		mergerSort(items, middle+1, rightEnd,temp);
		mergeArray(items,leftStart,rightEnd,temp);
	}
	
	public void mergeArray(int items[], int leftStart, int rightEnd,int temp[]){
		int leftEnd =(leftStart+rightEnd)/2;
		int rightStart = leftEnd+1;
		int size = rightEnd+leftEnd +1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd){
			if(items[index] <= items[index]){
				temp[index] = items[left];
				left++;
			}else{
				temp[index] = items[right];
				right++;
			}
			index++;
		}
		System.arraycopy(items, left, temp, index, leftEnd-left);
		System.arraycopy(items, right, temp, index, rightEnd-right);
		System.arraycopy(temp, leftStart, items, leftStart, size);
			
		
	}
	
	public void swap(int index1, int index2, int items[]){
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
		
	}
	
	
	public boolean binarySearch(int items[], int num){
		return binarySearchUtil(items, 0, items.length-1,num);
	}
	
	public boolean binarySearchUtil(int items[], int rightStart, int leftEnd,int num){
		if(rightStart < leftEnd){
			int middle = (rightStart+leftEnd)/2;
			if(items[middle] == num){
				return true;
			}else if(num < items[middle]){
				binarySearchUtil(items, rightStart, middle-1, num);
			}else{
				binarySearchUtil(items, middle+1, leftEnd, num);
			}		
		
		}
			return false;
		
	}
	
	public static void main(String args[]){
		int t[] = new int[3];
		for(int i: t){
			System.out.println(i);
		}
		
		SortSolutions ss = new SortSolutions();
		int input[] = new int[]{5,7,4,9,3,1,2,6};
		ss.bubbleSort(input);
		for(int i:input){
			System.out.print(i);
			System.out.print(",")  ;
		}
		System.out.println(ss.binarySearch(input, 10));
			
	}
	
	
}
