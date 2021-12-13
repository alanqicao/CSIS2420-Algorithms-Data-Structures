package finalCode;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.StdIn;

public class ExerciseFinal {


	public static void main(String[] args) {
		//setUp file
		String fileString = "src/finalCode/Resources/Route.txt";
		String delimiter = " ";
		In in = new In(fileString); 		
		int vertexes = Integer.parseInt(in.readLine()); //the first line is the number of vertexes
		//setUp graph
		Graph G = new Graph(vertexes);
		EdgeWeightedGraph EWGraph = new EdgeWeightedGraph(vertexes);
		
		while(in.hasNextLine()) {
			String[] line = in.readLine().split(delimiter);
			G.addEdge(
					 Integer.parseInt(line[0]), // int v
					 Integer.parseInt(line[1])// int w
					  );
			EWGraph.addEdge(new Edge(
					Integer.parseInt(line[0]), 
					Integer.parseInt(line[1]), 
					Double.parseDouble(line[2])
					));
		}
		
		KruskalMST channels = new KruskalMST(EWGraph);
	
		//find smallest and largest vertex
		int smallestVertex = 0;
		int largestVertex = 0;
		for (int v = 0; v < G.V(); v++) {
			for (int w : G.adj(v)) {
				if(w<smallestVertex) {
					smallestVertex = w;
				}
				if(w>largestVertex) {
					largestVertex = w;
				}
			}
		}
		System.out.println("smallestVertex: "+smallestVertex);
		System.out.println("largestVertex: "+largestVertex);
		//Part A
		//user input
		
		System.out.printf("Please enter the start and end betweent: %d to %d\n",smallestVertex,largestVertex);
		System.out.printf("Chose start betweent: %d to %d \n",smallestVertex,largestVertex);
		int start = Integer.parseInt(StdIn.readLine());
		System.out.printf("Chose end betweent: %d to %d \n",smallestVertex,largestVertex);
		int end = Integer.parseInt(StdIn.readLine());
		
		BreadthFirstPaths bfp= new BreadthFirstPaths(G,start);
		System.out.print("minimum bumber of operation: ");
		for(int v: bfp.pathTo(end)) {
			System.out.print(v+" ");
		}
		System.out.println();		
		System.out.println("total minimum distance: "+channels.weight());
		System.out.println("All the channels that are part of the shortest connection");
		for(Edge eg: channels.edges()) {
			System.out.println(eg);
		}
		
		
	
	}

}
