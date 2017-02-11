package com.abhijit.dynamic;

public class NQueenProblem {
	class Position{
		int row, col;
		Position(int row, int col){
			this.row = row;
			this.col = col;
		}
	}

	public Position[] solveNQueenOneSolution(int numOfQueen){
		Position posOfNQueens[] = new Position[numOfQueen];
		boolean result = solveNQueenOneSolutionUtil(numOfQueen, 0, posOfNQueens);
		if(result){
			return posOfNQueens;
		}else{
			return new Position[0];
		}

	}

	public boolean solveNQueenOneSolutionUtil(int numOfQueen, int row , Position posOfNQueens[]){
		if(row == numOfQueen){
			return true;
		}
		for(int col=0; col< numOfQueen; col++){
			boolean isSafe = true;
			for(int queen=0; queen <row; queen ++ ){
				int rowNotAllowed = posOfNQueens[queen].row;
				int colNotAllowed = posOfNQueens[queen].col;
				int digNotAllowed = rowNotAllowed - colNotAllowed;
				int dig2NotAllowed = rowNotAllowed + colNotAllowed;
				if(col == colNotAllowed || ((row-col) == digNotAllowed) || ((row+col) == dig2NotAllowed)){
					isSafe = false;
					break;
				}
			}  
			if(isSafe){
				posOfNQueens[row] = new Position(row, col);
				if(solveNQueenOneSolutionUtil(numOfQueen, row+1, posOfNQueens)){
					return true;   
				}
			}
		}
		return false;
	}
}

