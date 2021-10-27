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
		
		
		extracted(st);	
		
		System.out.println("All keys"+st.keys());
		StdOut.print("All keys:");
		for(Integer e: st.keys()) {
			StdOut.print(e);
		}
		
		
		StdOut.print("All names:");
		for(Integer key: st.keys()) {
			StdOut.print(st.get(key).getName()+" ");
			
		}
		StdOut.print();
		
		if(st.contains(10)||st.contains(17)||st.contains(24)) {
			
			StdOut.print(st.get(10));
		}else {
			StdOut.print("Not found");
		}
		
		
	}
	
	private static Integer getUniquePetId(BinarySearchST <Integer,Pet> st) {
		
		if(st.size()>=20) {
			throw new UnsupportedOperationException("noe more keys");
			
		}
		
		Integer id = null;
		
		do {
			
			id = StdRandom.uniform(10, 30);
			
		}while(st.contains(id));
		
		return id;
	}

	/**
	 * @param st
	 */
	private static void extracted(BinarySearchST<Integer, Pet> st) {
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
	}
//	
//	private static void displayCorespondPet(BinarySearchST<Integer, Pet> st) {
//		
//		if(st.contains(key)) {
//			StdOut.print(st.get(10));
//		}else {
//			StdOut.print("Not found");
//		
//		}
//	}

}
