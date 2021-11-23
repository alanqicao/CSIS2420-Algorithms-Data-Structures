/**
 * 
 */
package grapDFSvsBFS;

import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstSearch;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;


/**
 * @author Alan
 *
 */
public class DFSvsBFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileString = "/Volumes/GoogleDrive/My Drive/SLCC/Fall2021/CISI2420/Code/2420_CLASS_EXERCISE/src/grapDFSvsBFS/Resocuces/SimpleGraph.txt";
		In in = new In(fileString); // TODO
		Graph G = new Graph(in);
		int source = 1;
		
		// Adjacency list:
				System.out.println("Adjacency list: ");
				System.out.println("----------");
				for (int v = 0; v < G.V(); v++) {
					System.out.print(v + " : ");
					boolean first = true;
					for (int w : G.adj(v)) {
						if (first) {
							first = !first;
						} else {
							System.out.print(" -> ");
						}
						System.out.print(w);
					}
					System.out.println();
				}
				System.out.println();
			
				//DFS				
				DepthFirstPaths dfs = new DepthFirstPaths(G,source);
				System.out.println("Paths DFS:              Shortest Paths BFS:");
				System.out.println("---------------         -------------------");
				for(int v = 0; v<G.V();v++) {
					if(dfs.hasPathTo(v)) {
						for(int x: dfs.pathTo(v)) {
			
							if(x == source) {
								System.out.print(""+x);
							}else {
								System.out.print(".."+x);
							}
							System.out.println();
						}
						
					}
				}
				//BFS
				
		
	}

}
