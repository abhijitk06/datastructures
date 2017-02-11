package com.abhijit.powerset;

public class Powerset {// A Java program to print all subsets of a set
	// Print all subsets of given set[]
	static void printSubsets(char set[])
	{
		int n = set.length;

		// Run a loop for printing all 2^n
		// subsets one by obe

		int test = 1<<n;
		System.out.println(test);
		for (int i = 0; i < (1<<n); i++)
		{
			System.out.println("i = "+ i);
			System.out.print("{ ");

			// Print current subset
			for (int j = 0; j < n; j++){


				// (1<<j) is a number with jth bit 1
				// so when we 'and' them with the
				// subset number we get which numbers
				// are present in the subset and which
				// are not
                System.out.println(" j " + j);
                System.out.println("1 << j  = " + ( 1 << j)) ;
				if ((i & (1 << j)) > 0){
					System.out.print(set[j] + " ");
				}
			}

			System.out.println("}");



		}
	}
	
	// nCk
	public static int permutation(int n, int k){
		if(n == k  || k ==0){
			return 1;
		}
		int p1 = permutation(n-1, k-1);
		int p2 =  permutation(n-1, k);
		return p1+p2;
	}

	// Driver code
	public static void main(String[] args)
	{
		int result = permutation(4, 2);
		System.out.println(result);
		//char set[] = {'a', 'b', 'c'};
		//printSubsets(set);
	}

}
