package a04;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Solves puzzles based off the 8-puzzle problem given a board.  
 * 
 * @author Qi Cao, Glenna Williams
 *
 */
public class Solver {
	private int moves;
	private MinPQ<BoardCompare> boards;
	private Board initialBoard;
	private Stack<Board> solutions;
	
	/**
	 * Finds a solution to the initial board using the A* algorithm.
	 * 
	 * @param initial
	 */
	 @SuppressWarnings("unused")
	public Solver(Board initial) {
		 if(!initial.isSolvable()) {
			 throw new IllegalArgumentException("Board can not be solved. ");
		 }
		 if(initial == null){
			 throw new NullPointerException("Initial board can not be null. ");
		 }
		 
		 this.initialBoard = initial;
		 this.boards = new MinPQ<>();
		 this.solutions = new Stack<>();
		 boards.insert(new BoardCompare(initialBoard,null));
		 
			/*
			 * finds neighbors to store in neighbors pool. 
			 */
			if (initialBoard.isGoal()) {
				solutions.push(initialBoard);
			} else {

				while (!boards.min().board.isGoal()) {
					BoardCompare searchNode = boards.delMin();
					solutions.push(searchNode.board);
					moves++;

					for (Board el : searchNode.board.neighbors()) {
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
	 
	 /**
	  * Provides the minimum number of moves to solve initial board.
	  * 
	  * @return moves
	  */
	 public int moves() {		 
		 return moves;
	 }
	 
	 /**
	  * Provides the sequence of boards in a shortest solution.
	  * 
	  * @return solutionsCopy
	  */
	 public Iterable<Board> solution(){
		 
		 Stack<Board> solutionsCopy = new Stack<>();
		 
		 for(Board el: solutions) {
			 solutionsCopy.push(el);
		 }
		 
		 return solutionsCopy;
	 }
	 

	 /**
	  * Helper class implements Comparable for board comparison, compares
	  * each boards manhattan distance.  
	  * 	  
	  */
	 private class BoardCompare implements Comparable<BoardCompare>{
		 
		 private Board board;
		 private BoardCompare previous;
		 
		 
		 public BoardCompare(Board board,BoardCompare previous ) {
			 this.board = board;
			 this.previous = previous;		 
		 }
		 		 
		@Override
		public int compareTo(BoardCompare other) {			
			return this.board.manhattan() - other.board.manhattan(); 
		}		 
	 }

	/**
	 * Test client for Solver.  Solves a slider puzzle.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		 // create initial board from file
		int[] testArray1D = {1,2,3,7,0,6,5,4,8};
		int[][] testArray2D = new int[3][3];

		int counter = 0;

		for (int i = 0; i < testArray2D.length; i++) {
			for (int j = 0; j < testArray2D[i].length; j++) {
				testArray2D[i][j] = testArray1D[counter++];
			}
		}
		
	    Board initial = new Board(testArray2D);

	    // check if puzzle is solvable; if so, solve it and output solution
	    if (initial.isSolvable()) {
	        Solver solver = new Solver(initial);
	        StdOut.println("Minimum number of moves = " + solver.moves());
	        for (Board board : solver.solution())
	            StdOut.println(board);
	    }
	    // if not, report unsolvable
	    else {
	        StdOut.println("Unsolvable puzzle");
	    }

	}

}