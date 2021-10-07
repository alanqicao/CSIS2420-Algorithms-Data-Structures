package a03.old;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Immutable Data type class that represents an auto complete term
 * 
 * @author Qi Cao
 *
 */
public class Term_QiCao2 implements Comparable<Term_QiCao2>{
	private final String query;
	private final double weight;

	/**
	 * Construct a term with string query and weight
	 * 
	 * @param query  a string type of query
	 * @param weight a double type of weight
	 */
    public Term_QiCao2(String query, double weight) {
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
    public static Comparator<Term_QiCao2> byReverseWeightOrder(){
    	return new Comparator<Term_QiCao2>() {

			@Override
			public int compare(Term_QiCao2 w1, Term_QiCao2 w2) {
				return Double.compare(w2.weight, w1.weight);
			}
    	};
    }

    /**
	 * Sort Term by prefix order
	 * 
	 * @param r first r characters want to be sort in prefix.
	 * @return Sorted type Term by prefix order
	 */
    public static Comparator<Term_QiCao2> byPrefixOrder(int r){
    	if(r < 0) {
    		throw new java.lang.IllegalArgumentException("Cannot compare a negative amount of characters");
    	}
    	return new Comparator<Term_QiCao2>() {

			@Override
			public int compare(Term_QiCao2 s1, Term_QiCao2 s2) {
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
    public int compareTo(Term_QiCao2 that) {
    	return this.query.compareTo(that.query);
    }

    /**
	 * Return a string represent term format weight followed tab followed by query
	 */
    @Override
    public String toString() {
		return weight + "\t" + query;
    }
    
    /**
	 *  Testing
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		Term_QiCao2 [] newTerms = {
				
				new Term_QiCao2("cat",3.0),	
				new Term_QiCao2("dogcatcher",4.5),	
				new Term_QiCao2("do",5.0),
				new Term_QiCao2("dog",6.0),
		};
		
		Arrays.parallelSort(newTerms,Term_QiCao2.byPrefixOrder(3));
		
		//Arrays.parallelSort(newTerms,Term.byReverseWeightOrder());
		System.out.println("Sorted by Prefix: " + Arrays.toString(newTerms));
	}

}
