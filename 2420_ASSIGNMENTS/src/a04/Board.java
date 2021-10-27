package a04;

import java.util.Arrays;
import edu.princeton.cs.algs4.Queue;

/**
 * Board is an immutable data type that calculates information about a given
 * board, against a goal board.
 * 
 * @author Qi Cao, Glenna Williams
 *
 */
public class Board {
	private int N;
	private int[] oneDimenArray;
	private int[][] twoDimenArray;
	private int[] targetOneDArray;
	private int emptySpotRow;
	private int manDistance;
	private int totalHamming;

	/**
	 * Constructs a board from an N-by-N array of blocks (where blocks[i][j] = block
	 * in row i, column j)
	 * 
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		// row size
		this.N = blocks.length;

		convertOneDimension(blocks);

		// copy 2D array blocks to class field
		this.twoDimenArray = new int[blocks.length][blocks.length];
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				this.twoDimenArray[i][j] = blocks[i][j];
			}
		}

		goalBoard();
		manhattan();
		hamming();
	}

	/**
	 * The size of the board based on N.
	 * 
	 * @return N
	 */
	public int size() {
		return N;
	}

	/**
	 * Calculates the number of blocks out of place on the board.
	 * 
	 * @return the total number of blocks out of place.
	 */
	public int hamming() {
		totalHamming = 0;
		if (targetOneDArray.equals(oneDimenArray)) {
			return totalHamming = 0;
		}
		for (int i = 1; i < oneDimenArray.length + 1; i++) {
			if (oneDimenArray[i - 1] == 0) {
				continue;
			} else if (oneDimenArray[i - 1] != i) {
				totalHamming++;
			}

		}
		return totalHamming;

	}

	/**
	 * The sum of the Manhattan distances between given array blocks and the goal.
	 * 
	 * 
	 * @return the Manhattan distance
	 */
	public int manhattan() {
		manDistance = 0;

		int indexGiven;
		int indexTarget;

		int givenX;
		int givenY;

		int targetX;
		int targetY;

		for (int i = 0; i < oneDimenArray.length; i++) {

			if (oneDimenArray[i] == 0) {
				continue;
			} else {
				// index position in one dimension array
				indexGiven = i;
				indexTarget = oneDimenArray[i] - 1;
				// convert 1D array index position to 2D array position
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
	 * Validates the given board is the goal board.
	 * 
	 * @return true is the board is the goal board.
	 */
	public boolean isGoal() {
		return manhattan() == 0 || hamming() == 0;
	}

	/**
	 * Calculates whether a even or odd board is solvable or not based on the number
	 * of inversions.
	 * 
	 * @return
	 */
	public boolean isSolvable() {
		int inversion = 0;

		for (int i = 0; i < oneDimenArray.length; i++) {
			if (oneDimenArray[i] == 0) {
				continue;
			} else {
				for (int j = i; j < oneDimenArray.length; j++) {
					if (oneDimenArray[j] < oneDimenArray[i] && oneDimenArray[j] != 0) {
						inversion++;
					}
				}
			}
		}
		if (N % 2 != 0) {
			return inversion % 2 == 0;
		}
		else {
			return (inversion + emptySpotRow) % 2 != 0;
		}
	}

	/**
	 * Creates a copy of the old board to a new board. Depending on 0's current
	 * position, it changes direction and is added to the queue of neighbors.
	 * 
	 * @return the queue of neighboring boards
	 */
	public Iterable<Board> neighbors() {
		Queue<Board> neighbors = new Queue<Board>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// find 0 position in 2D array
				if (this.twoDimenArray[i][j] == 0) {
					// move 0 to the right one position and add to neighbors
					if (j < N - 1) {
						Board newBoard = new Board(this.twoDimenArray);
						// move the value of right 0 left to 0 position
						newBoard.twoDimenArray[i][j] = twoDimenArray[i][j + 1];
						// move 0 to right
						newBoard.twoDimenArray[i][j + 1] = 0;
						newBoard.convertOneDimension(newBoard.twoDimenArray);
						newBoard.hamming();
						neighbors.enqueue(newBoard);
					}

					// move 0 left one position and add to neighbors
					if (j > 0) {
						Board newBoard = new Board(this.twoDimenArray);
						// move the value of left 0 right to 0 position
						newBoard.twoDimenArray[i][j] = twoDimenArray[i][j - 1];
						// move 0 to left
						newBoard.twoDimenArray[i][j - 1] = 0;
						newBoard.convertOneDimension(newBoard.twoDimenArray);
						newBoard.hamming();
						neighbors.enqueue(newBoard);
					}

					// move 0 down one position and add to neighbors
					if (i < N - 1) {
						Board newBoard = new Board(this.twoDimenArray);
						// move the value blow 0 up to 0
						newBoard.twoDimenArray[i][j] = twoDimenArray[i + 1][j];
						// move 0 down
						newBoard.twoDimenArray[i + 1][j] = 0;
						newBoard.convertOneDimension(newBoard.twoDimenArray);
						newBoard.hamming();
						neighbors.enqueue(newBoard);
					}

					// move 0 UP one position and add to neighbors
					if (i > 0) {
						Board newBoard = new Board(this.twoDimenArray);
						// move the value above 0 down to 0
						newBoard.twoDimenArray[i][j] = twoDimenArray[i - 1][j];
						// move 0 up
						newBoard.twoDimenArray[i - 1][j] = 0;
						newBoard.convertOneDimension(newBoard.twoDimenArray);
						newBoard.hamming();
						neighbors.enqueue(newBoard);
					}
				}
			}
		}
		return neighbors;
	}
	
	/**
	 * Helper method generates a goal board for comparisons in other methods.
	 * 
	 * @return a goalboard for comparison
	 */
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
	 * Helper method to convert a two-dimensional array into a one-dimension.
	 * 
	 * @param blocks
	 */
	private void convertOneDimension(int[][] blocks) {
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
	}

	/**
	 * Compares two board objects.
	 * 
	 */
	@Override
	public boolean equals(Object y) {
		if (this == y)
			return true;
		if (y == null)
			return false;
		if (getClass() != y.getClass())
			return false;
		Board other = (Board) y;

		for (int i = 0; i < twoDimenArray.length; i++) {
			for (int j = 0; j < twoDimenArray.length; j++) {
				if (this.twoDimenArray[i][j] != other.twoDimenArray[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * String representation of the board. The format prints as follows, N, followed
	 * by the N-by-N initial board, using 0 to represent the blank square.
	 * 
	 */
	@Override
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
	 * Test client for the Board class.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		int[] testArray1D = { 1, 2, 3, 4, 5, 0, 6, 8, 9, 10, 7, 11, 13, 14, 15, 12 };
		int[][] testArray2D = new int[4][4];
		int counter = 0;

		for (int i = 0; i < testArray2D.length; i++) {
			for (int j = 0; j < testArray2D[i].length; j++) {
				testArray2D[i][j] = testArray1D[counter++];
			}
		}

		Board testBoard = new Board(testArray2D);

		// testing Hamming distances expect 5
		System.out.println("Hamming distances: " + testBoard.hamming());
		// old twoD array
		System.out.println("Old board: " + Arrays.deepToString(testArray2D));
		// Print target borad
		System.out.println("target board: " + Arrays.deepToString(testBoard.goalBoard()));
		// testing Manhattan distance expect 10
		System.out.println("Man distances: " + testBoard.manhattan());
		// testing isSolvable expect false
		System.out.println("isSolvable: " + testBoard.isSolvable());
		// testing is goal?
		System.out.println("Is Goal?: " + testBoard.isGoal());

		// print old twoD array
		System.out.println("\nOld board: \n\n" + testBoard.toString());

		// print neighbors
		System.out.println("neighbors: \n");
		for (Board e : testBoard.neighbors()) {
			System.out.println(e.toString());
		}

	}

}