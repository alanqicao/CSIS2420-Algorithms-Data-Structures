/**
 * 
 */
package graphlneternet;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KruskalMST;

/**
 * @author Qi Cao
 * Find minimum weight path to connect every vertex
 */
public class InternetCE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileString = "src\\graphlneternet\\source\\Graphlnternet.txt";
		In in = new In(fileString);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		KruskalMST office = new KruskalMST(G);
		int verualnode = 8;
		
		System.out.print("Offices needing to be connected: ");
		for (Edge el : office.edges()) {
			if(el.other(el.either()) != verualnode) {
			System.out.print(el.either() + "-" + el.other(el.either()));
			System.out.print(" ");}
		}
		
		System.out.println();
		System.out.print("Offices needing a router: ");
		for (Edge el : office.edges()) {
			if (el.other(el.either()) == verualnode)
				System.out.print(el.either()+" ");
		}
		System.out.println("\nTotal cost: $"+office.weight());
		
		

	}

}
