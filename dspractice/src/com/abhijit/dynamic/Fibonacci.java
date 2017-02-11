package com.abhijit.dynamic;

public class Fibonacci {
	int mem[];
	boolean isResAvailalbe[];
	int number;
	
	public Fibonacci(int n) {
		number = n;
		mem = new int[n+1];
		isResAvailalbe = new boolean[n+1];
		for(int i =0 ; i< n+1 ; i++){
			isResAvailalbe[i] = false;
			mem[i] = 0;
		}
		
		mem[0] = 0;
		mem[1] = 1;
		isResAvailalbe[0] = true;
		isResAvailalbe[1] = true;
	}
	
	public int getResult(){
		return computeFib(this.number,this.mem,this.isResAvailalbe);
	}
	
	
	
	public int computeFib(int n, int mem[], boolean isResv[]){
		if(isResv[n]){
			return mem[n];
		}else{
			int result = computeFib(n-1, mem,isResv) +computeFib(n-2, mem,isResv); 
			mem[n] = result;
			isResv[n]=true;
			return result;
		}
	}
	
	public static void main(String args[]){
		Fibonacci ff = new Fibonacci(10);
		System.out.println(ff.getResult());
		
	}

}
