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
 *
 */
public class InternetCE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileString = "/Volumes/GoogleDrive/My Drive/SLCC/Fall2021/CISI2420/Code/2420_CLASS_EXERCISE/src/graphlneternet/Graphlnternet.txt";
		In in = new In(fileString);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		
		KruskalMST office = new KruskalMST(G);
		int verualnode = 8;
		System.out.println(office.weight());
		
		
		for(Edge el: office.edges()) {
			
			if(el.other(el.either())==verualnode) 
				System.out.println("router"+el.either());				
			
			
			
			
		}
		
		for(Edge el: office.edges()) {
			System.out.print(el.either()+"-"+el.other(el.either()));
			System.out.print(" ");
		}
		

	}

}
