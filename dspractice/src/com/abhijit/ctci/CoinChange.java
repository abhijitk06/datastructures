package com.abhijit.ctci;

import java.util.Arrays;

public class CoinChange {
	
	public int getNumOfWays(int sum, int coins[]){
		Arrays.sort(coins);
		int numCoins[] = new int[coins.length];	
		int sumAndWays[] = new int[sum+1];
		for(int i=0;i< sum+1;i++){
			sumAndWays[i] = -1;
		}
		
		int currentSum = 0;
		
		for(int i=0; i < coins.length; i++ ){
			if(sum < coins[i]){
				break;
			}else{
				while(currentSum < sum){
					currentSum = currentSum+i;
					numCoins[i] = numCoins[i]+1;
					if((sum - currentSum) > coins[i]){
						continue;
					}
				}
			}
		}
		return -1;
	}
	
	public int mySolution(int total, int coins[]){
		int numOfWays[][] = new int[coins.length+1][(total+1)];
		for(int i =0; i<= coins.length+1 ; i++){
			numOfWays[i][0]= 1;
		}
		for(int i=1; i <= coins.length ;i++){
			for(int j=1;j<= total;j++){
				if(j>coins[i] ){
					numOfWays[i][j] = numOfWays[i-1][j];
				}else{
					numOfWays[i][j] = numOfWays[i-1][j]+numOfWays[i][j-coins[i-1]];
				}
				
			}
		}
		
		return -1;
	}
	 
	public int numberOfSolutions(int total, int coins[]){
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
	
	public int getNumOfWaysUtil(int sum,int sumAndWays[],int coins[],int numCoins[] ){
		if(sumAndWays[sum] != -1){
			return sumAndWays[sum];
		}else{
			int numOfWays =0;
			int currentSum = 0;
			for(int i=0; i < coins.length;i++){
				getNumOfWaysUtil(sum-coins[i], sumAndWays, coins, numCoins);
			}
		}
		return -1;
	}
	
	
	public static void main(String args[]){
		CoinChange cc = new CoinChange();
		int coins[] = new int[]{1,2,3};
		int total = 3;
		System.out.println();
		cc.numberOfSolutions(total, coins);
	}
}

