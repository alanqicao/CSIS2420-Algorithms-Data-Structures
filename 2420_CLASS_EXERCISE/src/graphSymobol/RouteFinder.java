package graphSymobol;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RouteFinder {

	public static void main(String[] args) {
		
		 String filename  = "src/graphSymobol/resource/routes.txt";// args[0];
	        String delimiter = " ";  // args[1];
	        SymbolGraph sg = new SymbolGraph(filename, delimiter);
	        Graph graph = sg.graph();
	        
	        System.out.println("Please enter a airport: ");
	        
	        while (StdIn.hasNextLine()) {	        	
	            String source = StdIn.readLine();
	            
	            if (sg.contains(source)) {	            	
	                int s = sg.indexOf(source);
	                for (int v : graph.adj(s)) {
	                	
//	                	for(int el: graph.adj(v)) {
//	                		System.out.println(sg.nameOf(el));
//	                	}
	                	
	                    StdOut.println("   " + sg.nameOf(v));
	                    
	                    if(sg.contains(sg.nameOf(v))) {
	                    	int inside = sg.indexOf(sg.nameOf(v));
	                    	for(int el: graph.adj(inside)){
	                    		System.out.println("insed"+sg.nameOf(el));
	                    	}
	                    }
	                }
	            }
	            else {
	                StdOut.println("The departure'" + source + "could not be found. ");
	            }
	        }
	    }

	

}
