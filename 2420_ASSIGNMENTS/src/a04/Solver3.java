/**
 * 
 */
package a04;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Qi Cao
 *
 */
public class Solver3 {
	
	private int moves;
	private MinPQ<BoardCompare> boards;
	private Board3 initialBoard;
	private Stack<Board3> solutions;
	
	/**
	 * find a solution to the initial board (using the A* algorithm)
	 * @param initial
	 */
	 public Solver3(Board3 initial) {
	
		 //determine solvable
		 if(!initial.isSolvable()) {
			 throw new IllegalArgumentException("Board can not be solved");
		 }
		 
		 if(initial == null){
			 throw new NullPointerException("Initial borad can not be null");
		 }
		 
		 //init board, init MinPQ
		 this.initialBoard = initial;
		 this.boards = new MinPQ<>();
		 this.solutions = new Stack<>();
		 boards.insert(new BoardCompare(initialBoard,null));

			// find neighbors,
			// store in neighbors pool
			if (initialBoard.isGoal()) {
				solutions.push(initialBoard);
			} else {

				while (!boards.min().board.isGoal()) {

					BoardCompare searchNode = boards.delMin();
					solutions.push(searchNode.board);
					moves++;

					for (Board3 el : searchNode.board.neighbors()) {

						if (searchNode.previous == null || !el.equals(searchNode.previous.board)) {
							boards.insert(new BoardCompare(el, searchNode));
						}
					}

					if (boards.min().board.isGoal()) {
						solutions.push(boards.min().board);
					}
				}				
			}
		}
	 
	 //helper class implements comparable for board with integer compare mahattan
	 private class BoardCompare implements Comparable<BoardCompare>{
		 
		 private Board3 board;
		 private BoardCompare previous;
		 
		 
		 public BoardCompare(Board3 board,BoardCompare previous ) {
			 this.board = board;
			 this.previous = previous;		 
		 }
		 		 
		@Override
		public int compareTo(BoardCompare other) {			
			return this.board.manhattan() - other.board.manhattan(); 
		}		 
	 }
	 
	 /**
	  * min number of moves to solve initial board
	  * @return
	  */
	 public int moves() {		 
		 return moves;
	 }
	 
	 /**
	  * sequence of boards in a shortest solution
	  * @return
	  */
	 public Iterable<Board3> solution(){
		 
		 Stack<Board3> solutionsCopy = new Stack<>();
		 
		 for(Board3 el: solutions) {
			 solutionsCopy.push(el);
		 }
		 
		 return solutionsCopy;
	 }

	/**
	 * Solve a slider puzzle
	 * @param args
	 */
	public static void main(String[] args) {
		
		 // create initial board from file
		int[] testArray1D = {0,1,3,4,2,5,7,8,6};
		int[][] testArray2D = new int[3][3];

		int counter = 0;

		for (int i = 0; i < testArray2D.length; i++) {
			for (int j = 0; j < testArray2D[i].length; j++) {
				testArray2D[i][j] = testArray1D[counter++];
			}
		}
		
	    Board3 initial = new Board3(testArray2D);

	    // check if puzzle is solvable; if so, solve it and output solution
	    if (initial.isSolvable()) {
	        Solver3 solver = new Solver3(initial);
	        StdOut.println("Minimum number of moves = " + solver.moves());
	        for (Board3 board : solver.solution())
	            StdOut.println(board);
	    }

	    // if not, report unsolvable
	    else {
	        StdOut.println("Unsolvable puzzle");
	    }

	}

}
