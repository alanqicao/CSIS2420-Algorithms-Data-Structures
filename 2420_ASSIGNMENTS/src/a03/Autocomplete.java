/**
 * 
 */
package a03;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;


/**
 * Immutable data type class that provides auto complete functionality
 * 
 * @author Qi Cao, Samuel Bailey
 *
 */
public class Autocomplete {
	
	private final Term[] terms;
	
    
	/**
	 * Initialize the data structure from the given array of terms.
	 * @param terms array of Term type data
	 */
    public Autocomplete(Term[] terms) {
    	
    	if(terms==null) {
    		
    		throw new NullPointerException("Search term cannot be null");
    		
    	}
    	
    	//Initialize the data
    	this.terms = Arrays.copyOf(terms,terms.length);
    	
    	//sort the terms in lexicographic order
    	Arrays.parallelSort(this.terms);
    }

   
    /**
     * Find all match terms that start with the given prefix.
     * @param prefix the string that we are searching for.
     * @return all match item return in descending order of weight.
     */
    public Term[] allMatches(String prefix) {
    	
    	if(prefix == null) {
    		throw new NullPointerException("Search term cannot be null");
    	}
    	//create a Term using prefix to looking matching Terms
    	Term searchBasePrefix = new Term(prefix,0);
    	
    	//search first index of the Terms array that match the search base,from a sorted array.
    	int firstIndexOfMatched = BinarySearchDeluxe.firstIndexOf(terms,searchBasePrefix,Term.byPrefixOrder(prefix.length()));
    	
    	//search last index of the Terms array that match the search base,from a sorted array.
    	int lastIndexOfMatched = BinarySearchDeluxe.lastIndexOf(terms,searchBasePrefix,Term.byPrefixOrder(prefix.length()));
    	
    	
    	
    	//create a empty array to hold the result.
    	Term[] resultTerms = new Term[lastIndexOfMatched-firstIndexOfMatched+1];
    	
    	//check if not found
    	if(firstIndexOfMatched <= 0 || lastIndexOfMatched <= 0) {
    		Term[] notFound = new Term[0];
    		return notFound;
    		
    	}else {
    		
    	//if found 
    	//putting the matched result in to new array  
    	
    	int indexCounter= firstIndexOfMatched;
    	
    	for(int i = 0; i<resultTerms.length;i++) {
    		
    		resultTerms[i]= terms[indexCounter++];
    	}
    	
    	//sort by weight
    	Arrays.parallelSort(resultTerms, Term.byReverseWeightOrder());
    	
    	//return result
    	return resultTerms;
    	
    	}
    }

   
    /**
     * Calculate total number of matched item.
     * @param prefix the string that we are searching for.
     * @return The total number of terms that start with the given prefix.
     */
    public int numberOfMatches(String prefix) {
    	
    	if(prefix == null) {
    		throw new NullPointerException("Search term cannot be null");
    	}
    	
    	//create a new object Term base on given prefix for searching 
    	Term searchBasePrefix = new Term(prefix,0);
    	
    	//search find first and last index    	
    	//search first index of the Terms array that match the search base,from a sorted array.
    	int firstIndexOfMatched = BinarySearchDeluxe.firstIndexOf(terms,searchBasePrefix,Term.byPrefixOrder(prefix.length()));
    	
    	//search last index of the Terms array that match the search base,from a sorted array.
    	int lastIndexOfMatched = BinarySearchDeluxe.lastIndexOf(terms,searchBasePrefix,Term.byPrefixOrder(prefix.length()));
    	
    	//calculate total matches
    	if(lastIndexOfMatched <= 0 && firstIndexOfMatched <= 0) {
    		return 0;
    	}else
    		return lastIndexOfMatched - firstIndexOfMatched + 1;
    	
    	
    }
    
    /**
     * Testing
     * @param args
     */
    public static void main(String[] args) {
    	
    	Term[] testing = new Term[7];
    	
    	testing[0] = new Term("the",56271872.00);
    	testing[1] = new Term("of",33950064.00);
    	testing[2] = new Term("and",29944184.00);
    	testing[3] = new Term("to",25956096.00);
    	testing[4] = new Term("in",17420636.00);
    	testing[5] = new Term("inside",11764797.00);
    	testing[6] = new Term("int",19764797.00);
    	
    	Autocomplete autocomplete = new Autocomplete(testing);
    	
    	String prefix = "i";
    	Term[] results = autocomplete.allMatches(prefix);
    	int numberMatch = autocomplete.numberOfMatches(prefix);
    	
    	for(Term e: results) {
    		StdOut.println(e);
    	}
    	
    	
    	StdOut.println("number of matches: "+numberMatch);
    		
    }

}