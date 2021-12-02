package graphCityConnections;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.PrimMST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class CityConnectionsCE {

	public static void main(String[] args) {
		
		    String filename  = "src/graphCityConnections/source/CityConnections.csv";
	        String delimiter = ",";
	        EdgeWeightedSymbolGraph sg = new EdgeWeightedSymbolGraph(filename, delimiter);
	        EdgeWeightedGraph graph = sg.graph();
	        PrimMST citys = new PrimMST(graph);
	        
	        System.out.println("Cities to connect with a bike trail:");
	        System.out.println("------------------------------------");
	        
			for (Edge el : citys.edges()) {
				System.out.println(sg.nameOf(el.either()) + " to " + sg.nameOf(el.other(el.either())) + " weight " + "("
						+ el.weight() + ")");

			}
			
	        System.out.println();
	        System.out.println("Total length of the bike trail: "+citys.weight());
	        
	
	        
	    }

	}


