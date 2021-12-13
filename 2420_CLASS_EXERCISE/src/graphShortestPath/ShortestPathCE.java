/**
 * 
 */
package graphShortestPath;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;

/**
 * Modify EdgeWeightedDigraph with Symbol Digraph and DirectedEdge to find
 * the shortest path from Start to End in a graph
 * @author Qi Cao
 *
 */
public class ShortestPathCE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 String filename  = "src/graphShortestPath/source/airports.txt";
	     String delimiter = " ";
	     EdgeWeightedSymbolDigraph sg = new EdgeWeightedSymbolDigraph(filename,delimiter);	     
	     DijkstraSP sp = new DijkstraSP(sg.digraph(), 0);
	     
	     System.out.println("Shortest path from Start to End:");
	     System.out.println("--------------------------------");
	     
	     double totalWeight = 0;
	     for(DirectedEdge e: sp.pathTo(sg.indexOf("End"))) {	    	 
	    	 System.out.println(sg.nameOf(e.from())+" to "+sg.nameOf(e.to())+" ("+e.weight()+")");
	    	 totalWeight = totalWeight+e.weight();	    	 
	     }
	     
	     System.out.println();
	     System.out.println("Total length from Start to End: "+totalWeight);
	}

}
