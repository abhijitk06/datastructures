package com.abhijit.random;

public class CoinChangingMinCoins {
	
	public static int numberOfSolutions(int total, int coins[]){
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
    }
	
	public static int getMinCoins(int sum, int coins[]){
		int minWays[][] = new int [coins.length+1] [sum+1]; 
		for(int i=0;i<coins.length+1;i++){
			minWays[i][0]= 1;
		}
		for(int i =1; i <= coins.length; i++){
			for(int j =1; j <= sum; j++){
				if(j >= coins[i-1]){
					int val1 = 1+ minWays[i][j-coins[i]];
					System.out.println(val1);
					int val2 = minWays[i-1][j];
					System.out.println(val2);
					if(val1 < val2){
						minWays[i][j] = val1;
					}else{
						minWays[i][j] = val2;
					}
				}else{
                    System.out.println(minWays[i-1][j]);
					minWays[i][j] = minWays[i-1][j];
				}
								
			}
		}
		
		return minWays[coins.length][sum];
	}
	
	
	public static void main (String args[]){
		int coins[] = new int []{1,5,6,8};
		int sum = 11;
		System.out.println(numberOfSolutions(sum,coins));
		System.out.println(getMinCoins(sum,coins));
	}

}
