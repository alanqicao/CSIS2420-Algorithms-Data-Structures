/**
 * 
 */
package cePet;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Qi Cao
 * 
 *
 */
public class PetApp {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		BinarySearchST<Integer,Pet> st = new BinarySearchST<>();		
		fillST(st);	
		
		StdOut.println("All keys: "+st.keys());				
		StdOut.print("\nAll names: ");		
		for(Integer key: st.keys()) {
			StdOut.print(st.get(key).getName()+" ");
			
		}		
		StdOut.println();
		
		
		Integer[] containNumbers = {10,17,23};	
		for (Integer el : containNumbers) {
			if (st.contains(el)) {
				System.out.println("\nPet associated with " + el + ": " + st.get(el));
				
			}
			else
				System.out.println("\nThe key " + el + " was not found in the symbol table.");
		}
		StdOut.println();

		
		StdOut.println("\nSmalest pet ID: "+st.min());			 
	    StdOut.println("\nSmallest pet ID greater or equal to 17: "+ st.ceiling(17));			
		StdOut.println("\nNumber of pets: "+st.size());		
		StdOut.println("\nPet IDs smaller 25: "+st.rank(25));		
		StdOut.println("\nPet with ID 30: " +st.get(30));		
		StdOut.println("\nSecond smallest pet ID:"+st.select(1));
		StdOut.println();
		
		st.put(30, new Pet("Strolch",3,"dog"));

		StdOut.println("\nIDs  Pets");
		StdOut.println("---   -------------");		
		for(Integer key: st.keys()) {
			StdOut.println(key+"  "+st.get(key));	
		}		
		
	}

	private static Integer getUniquePetId(BinarySearchST <Integer,Pet> st) {
		
		if(st.size()>=20) {
			throw new UnsupportedOperationException("noe more keys");
			
		}
		
		Integer id = null;
		
		do {
			
			id = StdRandom.uniform(10, 29);
			
		}while(st.contains(id));
		
		return id;
	}
	
	

	/**
	 * @param st
	 */
	private static void fillST(BinarySearchST<Integer, Pet> st) {
		st.put(getUniquePetId(st), new Pet("Buddy",8,"dog"));
		st.put(getUniquePetId(st), new Pet("Bobo",50,"tortoise"));
		st.put(getUniquePetId(st), new Pet("Hazel",4,"rat"));
		st.put(getUniquePetId(st), new Pet("Smokey",5,"goldfish"));
		st.put(getUniquePetId(st), new Pet("Bella",5,"cat"));
		st.put(getUniquePetId(st), new Pet("Leo",9,"tortoise"));
		st.put(getUniquePetId(st), new Pet("Garfield",6,"cat"));
		st.put(getUniquePetId(st), new Pet("Maddox",2,"dog"));		
		st.put(getUniquePetId(st), new Pet("Sylvester",7,"cat"));
		st.put(getUniquePetId(st), new Pet("Strolch",3,"dog"));
		st.put(30, new Pet("Waldi",3,"dog"));
	}


}
