package com.abhijit.random;

public class Fibonacci {

    public static int fibonacci(int n) {
        if(n ==0){
            return 0;
        }    
        
        if(n == 1){
            return 1;
        }
        
        int store[] = new int[n+1];
        for(int i=0;i<n+1;i++){
        	store[i]= -1;
        }
        store[0] = 0;
        store[1] = 1;
        int result = fibonacciUtil(store,n);
        return result;
      
    }
    
    public static int fibonacciUtil(int store[],int num){
        if(store[num] != -1){
            return store[num];
        }else{
            store[num]= fibonacciUtil(store,num-2)+fibonacciUtil(store,num-1);
            return store[num];
        }
        
    }
    

    public static void main(String[] args) {
        int n =3;
        System.out.println(fibonacci(n));
    }

}
