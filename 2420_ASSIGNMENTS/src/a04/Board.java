/**
 * 
 */
package a04;

import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Qi Cao
 *
 */
public class Board {

	private int N;
	// one dimansion array
	private int[] oneDimenArray;
	// two dimansion array
	private int[][] twoDimenArray;
	// target board
	private Board targetBoard;
	// target board one DimenArray
	private int[] targetOneDArray;
	// empty spot in witch row
	private int emptySpotRow;

	/**
	 * construct a board from an N-by-N array of blocks (where blocks[i][j] = block
	 * in row i, column j)
	 * 
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		
		if(blocks == null) {
			throw new NullPointerException("blocks cannot be null");
		}

		// row size
		this.N = blocks.length;

		// convert two dimansion to one dimansion
		this.oneDimenArray = new int[N * N];

		int counter = 0;

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (blocks[i][j] == 0) {

					emptySpotRow = i;
				}
				oneDimenArray[counter++] = blocks[i][j];
			}
		}

		// copy two diman array blocks to class field
		this.twoDimenArray = new int[blocks.length][blocks.length];
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				this.twoDimenArray[i][j] = blocks[i][j];
			}
		}

		goalBoard();
		
		if(isSolvable() == false) {
			throw new IllegalArgumentException("blocks cannot be sovle");
		}
	}

	/**
	 * board size N
	 * 
	 * @return
	 */
	public int size() {

		return N;
	}

	/**
	 * number of blocks out of place
	 * 
	 * @return
	 */
	public int hamming() {

		// Hamming move
		int totalHamming = 0;

		for (int i = 1; i < oneDimenArray.length + 1; i++) {

			if (oneDimenArray[i - 1] == 0) {

			} else if (oneDimenArray[i - 1] != i) {
				totalHamming++;
			}

		}

		return totalHamming;

	}

	/**
	 * sum of Manhattan distances between blocks and goal
	 * 
	 * @return
	 */
	public int manhattan() {

		int manDistance = 0;

		int indexGiven;
		int indexTarget;
		
		int givenX;
		int givenY;
	
		int targetX;
		int targetY;

		for (int i = 0; i < oneDimenArray.length; i++) {

			if (oneDimenArray[i] == 0) {

			} else {
				indexGiven = i;
				indexTarget = oneDimenArray[i]-1;
				
				givenX = indexGiven % N;
				givenY = indexGiven / N;

				targetX = indexTarget % N;
				targetY = indexTarget / N;

				manDistance += Math.abs(targetX - givenX) + Math.abs(targetY - givenY);

			}
		}

		return manDistance;
	}

	/**
	 * is this board the goal board?
	 * 
	 * @return
	 */
	public boolean isGoal() {

		return manhattan() == 0 && hamming() == 0;
	}

	// generate goal board
	private int[][] goalBoard() {

		int[][] goalBoard = new int[N][N];

		int counter = 1;

		for (int row = 0; row < N; row++) {
			for (int column = 0; column < N; column++) {

				goalBoard[row][column] = counter++;

			}
		}

		goalBoard[N - 1][N - 1] = 0;

		targetOneDArray = new int[N * N];

		counter = 0;

		for (int i = 0; i < goalBoard.length; i++) {
			for (int j = 0; j < goalBoard[i].length; j++) {
				targetOneDArray[counter++] = goalBoard[i][j];
			}
		}

		return goalBoard;
	}

	/**
	 * is this board solvable?
	 * 
	 * @return
	 */
	public boolean isSolvable() {

		int inversion = 0;

		for (int i = 0; i < oneDimenArray.length; i++) {
			if(oneDimenArray[i]== 0) {
				
			}else {
			for (int j = i ; j < oneDimenArray.length; j++) {
				if (oneDimenArray[i] > oneDimenArray[j] && oneDimenArray[j]!=0) {

					inversion++;
				}
			}
			}
		}

		if (N % 2 != 0) {
			

			return inversion % 2 == 0;
			// maybe a bug for inversion

		}

		else {

		
			return inversion + emptySpotRow % 2 != 0;
		}
	}


	@Override
	public boolean equals(Object y) {
		if (this == y)
			return true;
		if (y == null)
			return false;
		if (getClass() != y.getClass())
			return false;
		Board other = (Board) y;
		if (N != other.N)
			return false;
		if (emptySpotRow != other.emptySpotRow)
			return false;
		if (!Arrays.equals(oneDimenArray, other.oneDimenArray))
			return false;
		if (targetBoard == null) {
			if (other.targetBoard != null)
				return false;
		} else if (!targetBoard.equals(other.targetBoard))
			return false;
		if (!Arrays.equals(targetOneDArray, other.targetOneDArray))
			return false;
		if (!Arrays.deepEquals(twoDimenArray, other.twoDimenArray))
			return false;
		return true;
	}

	/**
	 * all neighboring boards
	 * 
	 * @return
	 */
	public Iterable<Board> neighbors() {
		
		Queue<Board> neighbors = new Queue<Board>();
		
		
		
		
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
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {

		int[] testArray1D = { 1,0,3,4,2,5,7,8,6};
		int[][] testArray2D = new int[3][3];

		int counter = 0;

		for (int i = 0; i < testArray2D.length; i++) {
			for (int j = 0; j < testArray2D[i].length; j++) {
				testArray2D[i][j] = testArray1D[counter++];
			}
		}

		Board testBorad = new Board(testArray2D);

		// testing Hamming distances expect 5
		System.out.println("Hamming distances: " + testBorad.hamming());
		// old twoD array
		System.out.println("Old board: " + Arrays.deepToString(testArray2D));
		// Print target borad
		System.out.println("target board: " + Arrays.deepToString(testBorad.goalBoard()));
		// testing Manhattan distance expect 10
		System.out.println("Man distances: " + testBorad.manhattan());
		// testing isSolvable expect false
		System.out.println("isSolvable: " + testBorad.isSolvable());
		//testing is goal?
		System.out.println("Is Goal?: " + testBorad.isGoal());
		
		

	}

}
