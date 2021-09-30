package a03;

import java.util.Comparator;

public class Term {
	private final String query;
	private final double weight;

	// Initialize a term with the given query string and weight.
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

    // Compare the terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
    	return new Comparator<Term>() {

			@Override
			public int compare(Term w1, Term w2) {
				return Double.compare(w2.weight, w1.weight);
			}
    	};
    }

    // Compare the terms in lexicographic order but using only the first r characters of each query.
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
					sub1 = s1.query.substring(0, r-1);
				}
				
				if(r > s2.query.length()) {
					sub2 = s2.query;
				}
				else {
					sub2 = s2.query.substring(0, r-1);
				}
				
				return sub1.compareTo(sub2);
			}
    	};
    }

    // Compare the terms in lexicographic order by query.
    public int compareTo(Term that) {
    	return this.query.compareTo(that.query);
    }

    // Return a string representation of the term in the following format:
    // the weight, followed by a tab, followed by the query.
    @Override
    public String toString() {
		return weight + "\t" + query;
    }

}
