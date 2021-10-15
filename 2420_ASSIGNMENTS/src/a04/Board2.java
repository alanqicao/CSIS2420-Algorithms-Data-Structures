/**
 * 
 */
package a04;

import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * @author Qi Cao
 *
 */
public class Board2 {

	private int N;
	// one dimension array
	private int[] oneDimenArray;
	// two dimension array
	private int[][] twoDimenArray;
	// target board
	private Board2 targetBoard;
	// target board one DimenArray
	private int[] targetOneDArray;
	// empty spot in  row
	private int emptySpotRow;
	// empty spot in column
	private int emptySpotColumn;

	/**
	 * construct a board from an N-by-N array of blocks (where blocks[i][j] = block
	 * in row i, column j)
	 * 
	 * @param blocks
	 */
	public Board2(int[][] blocks) {

		if (blocks == null) {
			throw new NullPointerException("blocks cannot be null");
		}

		// row size
		this.N = blocks.length;

		// convert two dimension to one dimension
		this.oneDimenArray = new int[N * N];

		int counter = 0;

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[i].length; j++) {
				if (blocks[i][j] == 0) {

					emptySpotRow = i;
					emptySpotColumn = j;
				}
				oneDimenArray[counter++] = blocks[i][j];
			}
		}

		// copy two dimension array blocks to class field
		this.twoDimenArray = new int[blocks.length][blocks.length];
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				this.twoDimenArray[i][j] = blocks[i][j];
			}
		}

		goalBoard();

		if (isSolvable() == false) {
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
				// index position in one dimension array
				indexGiven = i;
				indexTarget = oneDimenArray[i] - 1;
				//convert one dimension array index position to Two dimension array position
				givenX = indexGiven % N;
				givenY = indexGiven / N;

				targetX = indexTarget % N;
				targetY = indexTarget / N;
				// math for manhattan
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
			if (oneDimenArray[i] == 0) {

			} else {
				for (int j = i; j < oneDimenArray.length; j++) {
					if (oneDimenArray[i] > oneDimenArray[j] && oneDimenArray[j] != 0) {

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
		Board2 other = (Board2) y;
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
	public Iterable<Board2> neighbors() {

		Stack<Board2> neighbors = new Stack<Board2>();
		
					
					//move 0 UP one position and add to neighbors
					if(emptySpotRow > 0) {
						//copy old board to a new board
						Board2 newBoard = new Board2(this.twoDimenArray);
						//move the value above 0 down to 0
						newBoard.twoDimenArray[newBoard.emptySpotRow][newBoard.emptySpotColumn]= twoDimenArray[newBoard.emptySpotRow-1][newBoard.emptySpotColumn];
						//move 0 up
						newBoard.twoDimenArray[--newBoard.emptySpotRow][newBoard.emptySpotColumn] = 0;
						//add new board to queue
						neighbors.push(newBoard);
					}	
					//move 0 to the right one position and add to neighbors
					if(emptySpotColumn < N-1) {
						//copy old board to a new board
						Board2 newBoard = new Board2(this.twoDimenArray);
						//move the value of right 0 left to 0 position
						newBoard.twoDimenArray[newBoard.emptySpotRow][newBoard.emptySpotColumn]= twoDimenArray[newBoard.emptySpotRow][newBoard.emptySpotColumn+1];
						//move 0 to right
						newBoard.twoDimenArray[newBoard.emptySpotRow][++newBoard.emptySpotColumn] = 0;
						//add new board to queue
						neighbors.push(newBoard);
					}
					
					//move 0 down one position and add to neighbors
					if(emptySpotRow < N-1) {
						//copy old board to a new board
						Board2 newBoard = new Board2(this.twoDimenArray);
						//move the value blow 0 up to 0
						newBoard.twoDimenArray[newBoard.emptySpotRow][newBoard.emptySpotColumn]= twoDimenArray[newBoard.emptySpotRow+1][newBoard.emptySpotColumn];
						//move 0 down
						newBoard.twoDimenArray[++newBoard.emptySpotRow][newBoard.emptySpotColumn] = 0;
						//add new board to queue
						neighbors.push(newBoard);
					}
					
					//move 0 left one position and add to neighbors
					if(emptySpotColumn > 0) {
						//copy old board to a new board
						Board2 newBoard = new Board2(this.twoDimenArray);
						//move the value of left 0 right to 0 position
						newBoard.twoDimenArray[newBoard.emptySpotRow][newBoard.emptySpotColumn]= twoDimenArray[newBoard.emptySpotRow][newBoard.emptySpotColumn-1];
						//move 0 to left
						newBoard.twoDimenArray[newBoard.emptySpotRow][--newBoard.emptySpotColumn] = 0;
						//add new board to queue
						neighbors.push(newBoard);
					}
		return neighbors;

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

		int[] testArray1D = { 8, 1, 3, 4, 2, 0, 7, 6, 5 };
		int[][] testArray2D = new int[3][3];

		int counter = 0;

		for (int i = 0; i < testArray2D.length; i++) {
			for (int j = 0; j < testArray2D[i].length; j++) {
				testArray2D[i][j] = testArray1D[counter++];
			}
		}

		Board2 testBorad = new Board2(testArray2D);

		// testing Hamming distances expect 5
		System.out.println("Hamming distances: " + testBorad.hamming());
	
		
		// Print target borad
		System.out.println("target board: " + Arrays.deepToString(testBorad.goalBoard()));
		// testing Manhattan distance expect 10
		System.out.println("Man distances: " + testBorad.manhattan());
		// testing isSolvable expect false
		System.out.println("isSolvable: " + testBorad.isSolvable());
		// testing is goal?
		System.out.println("Is Goal?: " + testBorad.isGoal());
		
		
		
		// old twoD array	
		System.out.println("Old board: " + testBorad.toString());
		
		//neighbors		
		for(Board2 e: testBorad.neighbors()) {
			System.out.println(e.toString());
		}
		
		

	}

}
