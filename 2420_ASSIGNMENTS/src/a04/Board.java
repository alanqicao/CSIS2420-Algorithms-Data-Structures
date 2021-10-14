/**
 * 
 */
package a04;

import java.util.Arrays;

/**
 * @author Qi Cao
 *
 */
public class Board {
	
	private int N;
	//one dimansion array
	private int [] oneDimenArray;
	//two dimansion array
	private int [][] twoDimenArray;
	//target board
	private Board targetBoard;
	//empty spot
	private int emptySpot;
	
	/**
	 * construct a board from an N-by-N array of blocks
	 * (where blocks[i][j] = block in row i, column j)
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		
		//row size
		this.N = blocks.length;
		
		//convert two dimansion to one dimansion
		this.oneDimenArray = new int[N*N];
		
		int counter= 0;
		
		for(int i = 0; i<blocks.length;i++) {
			for(int j = 0 ; j<blocks[i].length;j++) {
				oneDimenArray[counter++]= blocks[i][j];
			}
		}
		
		//copy two diman array blocks to class field
		this.twoDimenArray = new int [blocks.length][blocks.length];
		for(int i = 0; i<blocks.length;i++) {
			for(int j =0; j<blocks.length; j++) {
				this.twoDimenArray[i][j] = blocks[i][j];
			}
		}
		
		
	}          

	

	/**
	 * board size N
	 * @return
	 */
	public int size() {
		
		return N;
	}                   
	
	/**
	 * number of blocks out of place
	 * @return
	 */
	public int hamming() {
		
		//Hamming move
		int totalHamming = 0;
		
		for(int i = 1; i<oneDimenArray.length+1; i++) {
			
			if(oneDimenArray[i-1] == 0) {
				
			}
			else if(oneDimenArray[i-1]!=i) {
				totalHamming++;
			}
								
		}
		
		return totalHamming;
		
	} 
	
	/**
	 * sum of Manhattan distances between blocks and goal
	 * @return
	 */
	public int manhattan() {
		
		int manDistance = 0;
		
		int [][] goalBoard = goalBoard(N);
		
		for(int row = 0; row < N; row++) {
			
			for(int column =0; column < N; column++) {
				
				if(twoDimenArray[row][column] == 0 ) {
					
					manDistance=manDistance;
					
				}else {
					//  psudo code
					manDistance += Math.abs(twoDimenArray[row] - goalBoard[row]);
					manDistance += Math.abs(twoDimenArray[column] - goalBoard[column]);
				}
			}
		}
		
		return 0;
	}
	
	/**
	 * is this board the goal board?
	 * @return
	 */
	public boolean isGoal() {
		
		return false;
	}
	
	//generate goal board
	private int [][] goalBoard(int n){
		
		int [][] goalBoard = new int[n][n];
		
		int counter = 1;
		
		for(int row = 0; row <n; row++) {
			for(int column = 0; column<n; column ++) {
				
				
				goalBoard[row][column] = counter++;
				
			}
		}
		
		goalBoard[n-1][n-1] =0;
		
		return goalBoard;
	}
	
	/**
	 * is this board solvable?
	 * @return
	 */
	public boolean isSolvable() {
		
		return false;
		
	}
	
	/**
	 * does this board equal y?
	
	 * @return
	 */
	public boolean equals(Object y) {
		
		return false;
		
	}
	
	/**
	 *  all neighboring boards
	 * @return
	 */
	public Iterable<Board> neighbors(){
		
		return null;
		
	}
	
	/**
	 * String representation of this board (in the output format specified below)
	 */
	public String toString() {
		
		 StringBuilder s = new StringBuilder();
		    s.append(N + "\n");
		    for (int i = 0; i < N; i++) {
		        for (int j = 0; j < N; j++) {
		            s.append(String.format("%2d ", twoDimenArray[i][j]));
		        }
		        s.append("\n");
		    }
		    return s.toString();
		
	}

	/**
	 * Testing
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] testArray1D = {8,1,3,4,0,2,7,6,5};
		int [][] testArray2D = new int[3][3];
		
		int counter = 0;
		
		for(int i= 0; i<testArray2D.length;i++) {
			for(int j = 0; j<testArray2D[i].length;j++) {
				testArray2D[i][j] = testArray1D[counter++];
			}
		}
		
		Board testBorad = new Board(testArray2D);
		
		//testing Hamming distances expect 5
		System.out.println("Hamming distances: "+testBorad.hamming());
		//old twoD array
		System.out.println("Old board: "+Arrays.deepToString(testArray2D));
		//testing generate goal board
		System.out.println("generate goal board: "+Arrays.deepToString(testBorad.goalBoard(3)));
		
	}

}
