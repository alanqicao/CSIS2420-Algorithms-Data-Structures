/**
 * 
 */
package grapDFSvsBFS;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;


/**
 * @author Qi Cao
 * This class is to compare DFS and BFS
 *
 */
public class DFSvsBFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileString = "src/grapDFSvsBFS/Resocuces/SimpleGraph.txt";
		In in = new In(fileString); 
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
				Queue<String> dfsQueue= new Queue<>();
				String dfsString="";
				DepthFirstPaths dfs = new DepthFirstPaths(G,source);
				System.out.println("Paths DFS:              Shortest Paths BFS:");
				System.out.println("---------------         -------------------");
				
				for(int v = 0; v<G.V();v++) {
					if(dfs.hasPathTo(v)) {
						for(int x: dfs.pathTo(v)) {		
							if(x == source) {
								dfsString = dfsString+x;
							}else {
								dfsString=dfsString+".."+x;
							}							
						}
						dfsQueue.enqueue(dfsString);
						dfsString="";
					}
				}				
			
				//BFS				
				BreadthFirstPaths bfp= new BreadthFirstPaths(G,source);
				Queue<String> bfpQueue= new Queue<>();
				
				for(int v = 0; v<G.V();v++) {
					if(bfp.hasPathTo(v)) {
						for(int x: bfp.pathTo(v)) {		
							if(x == source) {
								dfsString = dfsString+x;
							}else {
								dfsString=dfsString+".."+x;
							}						
						}
						bfpQueue.enqueue(dfsString);
						dfsString="";
					}
				}
				//print
				for(int v = 0; v<G.V();v++) {				
					System.out.format("%-23s %-23s\n", dfsQueue.dequeue(),bfpQueue.dequeue());
				}

				
	}
	

}
