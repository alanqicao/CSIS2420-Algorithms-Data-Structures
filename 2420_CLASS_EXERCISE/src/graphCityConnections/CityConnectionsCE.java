package graphCityConnections;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class CityConnectionsCE {

	public static void main(String[] args) {
		
		    String filename  = "/Volumes/GoogleDrive/My Drive/SLCC/Fall2021/CISI2420/Code/2420_CLASS_EXERCISE/src/graphCityConnections/source/CityConnections.csv";
	        String delimiter = ",";
	        EdgeWeightedSymbolGraph sg = new EdgeWeightedSymbolGraph(filename, delimiter);
	        EdgeWeightedGraph graph = sg.graph();
	        
	        while (StdIn.hasNextLine()) {
	            String source = StdIn.readLine();
	            if (sg.contains(source)) {
	                int s = sg.indexOf(source);
	                for (Edge v : graph.adj(s)) {
	                    StdOut.println("   " + v);
	                }
	            }
	            else {
	                StdOut.println("input not contain '" + source + "'");
	            }
	        }
	        
	        
	    }

	}


