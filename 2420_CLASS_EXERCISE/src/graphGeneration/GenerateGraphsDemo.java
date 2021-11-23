/**
 * 
 */
package graphGeneration;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DigraphGenerator;

/**
 * Demonstrates how to auto generate graphs.
 * @author Qi Cao
 *
 */
public class GenerateGraphsDemo {

	public static void main(String[] args) {
		//simple
		System.out.println("simple");
		Digraph demoGraph =DigraphGenerator.simple(7, 15);		
		System.out.println(demoGraph);
		System.out.println();
		
		//binaryTree
		System.out.println("Binary Tree");
		Digraph binarTree = DigraphGenerator.binaryTree(10);
		System.out.println(binarTree);
		System.out.println();
		
		//complete graph all strong
		System.out.println("complete graph");
		Digraph compleTree = DigraphGenerator.complete(5);
		System.out.println(compleTree);
		System.out.println();
		
	}

}
