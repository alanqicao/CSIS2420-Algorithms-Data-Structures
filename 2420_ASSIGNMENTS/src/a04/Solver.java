/**
 * 
 */
package a04;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 * @author Qi Cao
 *
 */
public class Solver {
	
	private int moves;
	private MinPQ<BoardCompare> boards;
	private Board initialBoard;
	private Stack<Board> solutions;
	
	/**
	 * find a solution to the initial board (using the A* algorithm)
	 * @param initial
	 */
	 public Solver(Board initial) {
	
		 //determine solvable
		 if(!initial.isSolvable()) {
			 throw new IllegalArgumentException("Board can not be solved");
		 }
		 
		 if(initial == null){
			 throw new NullPointerException();
		 }
		 
		 //init board, init MinPQ
		 this.initialBoard = initial;
		 this.boards = new MinPQ<>();
		 this.solutions = new Stack<>();
		 boards.insert(new BoardCompare(initialBoard,0,null));
		 System.out.println(boards.min().board.manhattan());
		 
		 //find neighbors,
		 //store in neighbors pool
		 if(initialBoard.isGoal()) {
			
			 solutions.push(initialBoard);
			 
		 }else {
		 
		 while(!boards.min().board.isGoal()){	
			 
				BoardCompare searchNode = boards.delMin();
				
				solutions.push(searchNode.board);//bug
				
			

					for (Board el : searchNode.board.neighbors()) {

						if (searchNode.previous == null || !el.equals(searchNode.previous.board)) {
							boards.insert(new BoardCompare(el, searchNode.moves+1,searchNode));						
						//	System.out.println("if loop:"+boards.min().board.manhattan());
						}

					}
					
					if(boards.min().board.isGoal()) {
						this.moves= searchNode.moves;
					}
				//	System.out.println("while loop:"+boards.min().board.manhattan());
			};
		 }
		 //repeat find neighbors
		 //counter++
		 //find solution

	 }
	 
	 //helper class implements comparable for board with integer compare mahantom
	 private class BoardCompare implements Comparable<BoardCompare>{
		 
		 private Board board;
		 private BoardCompare previous;
		 private int moves;
		 
		 public BoardCompare(Board board,int moves,BoardCompare previous ) {
			 this.board = board;
			 this.previous = previous;
			 this.moves=moves;
			 
		 }
		@Override
		public int compareTo(BoardCompare other) {
			
			return this.board.manhattan()-other.board.manhattan(); 
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
	 public Iterable<Board> solution(){
		 
		 Stack<Board> solutionsCopy = new Stack<>();
		 
		 for(Board el: solutions) {
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
