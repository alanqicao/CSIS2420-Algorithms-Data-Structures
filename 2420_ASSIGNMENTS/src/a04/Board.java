/**
 * 
 */
package a04;

/**
 * @author Qi Cao
 *
 */
public class Board {
	
	private int N;
	//one dimansion array
	private int [] oneDimenArray= new int[N*N];
	
	
	/**
	 * construct a board from an N-by-N array of blocks
	 * (where blocks[i][j] = block in row i, column j)
	 * @param blocks
	 */
	public Board(int[][] blocks) {
		
		//row size
		this.N = blocks.length;
		
		//convert two dimansion to one dimansion
		int idx= 0;
		for(int i = 0; i<blocks.length;i++) {
			for(int j = 0 ; j<blocks[i].length;j++) {
				oneDimenArray[idx++]= blocks[i][j];
			}
		}
	}          

	/**
	 * board size N
	 * @return
	 */
	public int size() {
		
		return N*N;
	}                   
	
	/**
	 * number of blocks out of place
	 * @return
	 */
	public int hamming() {
		
		return 0;
		
	} 
	
	/**
	 * sum of Manhattan distances between blocks and goal
	 * @return
	 */
	public int manhattan() {
		
		return 0;
	}
	
	/**
	 * is this board the goal board?
	 * @return
	 */
	public boolean isGoal() {
		
		return false;
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
		
		return null;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
