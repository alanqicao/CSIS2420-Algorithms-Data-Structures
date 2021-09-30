package a03;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdOut;

/**
 * Immutable Data type class that represents an auto complete term
 * 
 * @author Qi Cao
 *
 */
public class Term implements Comparable<Term> {

	private final String query;
	private final double weight;

	/**
	 * Construct a term with string query and weight
	 * 
	 * @param query  a string type of query
	 * @param weight a double type of weight
	 */
	public Term(String query, double weight) {

		if (query == null) {
			throw new NullPointerException("Query can not be null");
		}
		if (weight < 0) {
			throw new IllegalArgumentException("Weight can not be negative");
		}

		this.query = query;
		this.weight = weight;
	}

	/**
	 * Compare and sort by weight in reverse order
	 * 
	 * @return Sorted type Term by reverse weight order
	 */
	public static Comparator<Term> byReverseWeightOrder() {

		return new Comparator<Term>() {

			@Override
			public int compare(Term t1, Term t2) {

				return	Double.compare(t2.weight, t1.weight);
			}

		};
	}

	/**
	 * Sort Term by prefix order
	 * 
	 * @param r first r characters.
	 * @return Sorted type Term by prefix order
	 */
	public static Comparator<Term> byPrefixOrder(int r) {

		if (r < 0) {
			throw new IllegalArgumentException("r can not be negative");
		}

		return new Comparator<Term>() {

			@Override
			public int compare(Term t1, Term t2) {
				
				if(t1.query.length() < r || t2.query.length() < r) {
					
					return t1.query.compareTo(t2.query);
					
				}else {
					return t1.query.substring(0, r).compareTo(t2.query.substring(0, r));
				}					
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
	public String toString() {
		return weight+"\t"+query;
	}
	
	
	/**
	 *  Testing
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		Term [] newTerms = {
				
				new Term("cat",3.0),	
				new Term("dogcatcher",4.5),	
				new Term("do",5.0),
				new Term("dog",6.0),
		};
		
		Arrays.parallelSort(newTerms,Term.byPrefixOrder(3));
		
		//Arrays.parallelSort(newTerms,Term.byReverseWeightOrder());
		StdOut.println("Sorted by Prefix: " + Arrays.toString(newTerms));
	}
}