package graphSymobol;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/**
 * 
 * @author Qi Cao
 * This class is using Symbol Grahp and BreadthFirstPaths to find shortest paths
 *
 */
public class RouteFinder {

	public static void main(String[] args) {
		
		    String filename  = "src/graphSymobol/resource/routes.txt";// args[0];
	        String delimiter = " ";  // args[1];
	        SymbolGraph sg = new SymbolGraph(filename, delimiter);
	        Graph graph = sg.graph();
	        
	        System.out.println("Please enter a airport: ");
	        
			while (StdIn.hasNextLine()) {
				String source = StdIn.readLine();
				Queue<String> dfsQueue = new Queue<>();
				String dfsString = "";

				if (sg.contains(source)) {
					int s = sg.indexOf(source);
					// using indexOf from Symbol graph just like Symbol table
					BreadthFirstPaths dfs = new BreadthFirstPaths(graph, s);
					for (int v = 0; v < graph.V(); v++) {
						if (dfs.hasPathTo(v)) {
							dfsString = sg.nameOf(v) + ": ";
							for (int x : dfs.pathTo(v)) {
								if (x == s) {
									dfsString = dfsString + sg.nameOf(x);
								} else {
									dfsString = dfsString + " " + sg.nameOf(x);
								}
							}
							dfsQueue.enqueue(dfsString);
							dfsString = "";
						}
					}
					for (int v = 0; v < graph.V(); v++) {
						System.out.println(dfsQueue.dequeue());
					}
				} else {
					StdOut.println("The departure'" + source + "could not be found. ");
				}
			}
		}

	

}
