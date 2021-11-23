/**
 * 
 */
package graphDirected;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Topological;

/**
 * CE directed exercise with topological order
 * @author Qi
 *
 */
public class DirectedCE {

	
	public static void main(String[] args) {
		
		String fileString = "/Volumes/GoogleDrive/My Drive/SLCC/Fall2021/CISI2420/Code/2420_CLASS_EXERCISE/src/graphDirected/Resources/TopologicalOrderGraph.txt";
		In in = new In(fileString);
		Digraph D = new Digraph(in);
		
		Topological topoDirected = new Topological(D);
		System.out.println("Toplological order:");
		
		for(int el: topoDirected.order()) {
			System.out.print(el+" ");
		}

	}

}
