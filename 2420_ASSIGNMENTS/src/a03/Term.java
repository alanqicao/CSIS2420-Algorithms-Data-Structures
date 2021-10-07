package a03;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Immutable Data type class that represents an auto-complete term
 * 
 * @author Qi Cao, Samuel Bailey
 *
 */
public class Term implements Comparable<Term>{
	private final String query;
	private final double weight;

	/**
	 * Construct a term with string query and weight
	 * 
	 * @param query  a string type of query
	 * @param weight a double type of weight
	 */
    public Term(String query, double weight) {
    	if(query == null) {
    		throw new java.lang.NullPointerException("The query cannot be null");
    	}
    	if(weight < 0) {
    		throw new java.lang.IllegalArgumentException("Weight cannot be negative");
    	}
    	this.query = query;
    	this.weight = weight;
    }

    /**
	 * Compare and sort by weight in reverse order
	 * 
	 * @return Sorted type Term by reverse weight order
	 */
    public static Comparator<Term> byReverseWeightOrder(){
    	return new Comparator<Term>() {

			@Override
			public int compare(Term w1, Term w2) {
				return Double.compare(w2.weight, w1.weight);
			}
    	};
    }

    /**
	 * Sort Term lexicographically using a prefix of <code>r</code> letters
	 * 
	 * @param r first r characters want to be sort in prefix.
	 * @return Sorted type Term by prefix order
	 */
    public static Comparator<Term> byPrefixOrder(int r){
    	if(r < 0) {
    		throw new java.lang.IllegalArgumentException("Cannot compare a negative amount of characters");
    	}
    	return new Comparator<Term>() {

			@Override
			public int compare(Term s1, Term s2) {
				String sub1;
				String sub2;
				if(r > s1.query.length()) {
					sub1 = s1.query;
				}else {
					sub1 = s1.query.substring(0, r);
				}
				
				if(r > s2.query.length()) {
					sub2 = s2.query;
				}
				else {
					sub2 = s2.query.substring(0, r);
				}
				
				return sub1.compareTo(sub2);
			}
    	};
    }

    /**
	 * Compare the terms in lexicographic order by query
	 */
    public int compareTo(Term that) {
    	return this.query.compareTo(that.query);
    }

    /**
	 * Return a string represent term format weight followed tab followed by query
	 */
    @Override
    public String toString() {
		return weight + "\t" + query;
    }
    
	public static void main(String[] args) {
	
		
		Term [] newTerms = {
				
				new Term("cat",3.0),	
				new Term("dogcatcher",4.5),	
				new Term("do",5.0),
				new Term("dog",6.0),
		};
		
		Arrays.parallelSort(newTerms,Term.byPrefixOrder(3));
		
		//Arrays.parallelSort(newTerms,Term.byReverseWeightOrder());
		System.out.println("Sorted by Prefix: " + Arrays.toString(newTerms));
	}

}
