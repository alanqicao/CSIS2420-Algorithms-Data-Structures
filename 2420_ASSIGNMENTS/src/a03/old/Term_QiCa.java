package a03.old;
//package a03;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//
///**
// * Immutable Data type class that represents an auto complete term
// * 
// * @author Qi Cao
// *
// */
//public class Term_QiCa implements Comparable<Term_QiCa> {
//
//	private final String query;
//	private final double weight;
//
//	/**
//	 * Construct a term with string query and weight
//	 * 
//	 * @param query  a string type of query
//	 * @param weight a double type of weight
//	 */
//	public Term_QiCa(String query, double weight) {
//
//		if (query == null) {
//			throw new NullPointerException("Query can not be null");
//		}
//		if (weight < 0) {
//			throw new IllegalArgumentException("Weight can not be negative");
//		}
//
//		this.query = query;
//		this.weight = weight;
//	}
//
//	/**
//	 * Compare and sort by weight in reverse order
//	 * 
//	 * @return Sorted type Term by reverse weight order
//	 */
//	public static Comparator<Term_QiCao2> byReverseWeightOrder() {
//
//		return new Comparator<Term_QiCao2>() {
//
//			@Override
//			public int compare(Term_QiCao2 t1, Term_QiCao2 t2) {
//
//				return	Double.compare(t2.weight, t1.weight);
//			}
//
//		};
//	}
//
//	/**
//	 * Sort Term by prefix order
//	 * 
//	 * @param r first r characters want to be sort in prefix.
//	 * @return Sorted type Term by prefix order
//	 */
//	public static Comparator<Term_QiCao2> byPrefixOrder(int r) {
//
//		if (r < 0) {
//			throw new IllegalArgumentException("r can not be negative");
//		}
//
//		return new Comparator<Term_QiCao2>() {
//
//			@Override
//			public int compare(Term_QiCao2 t1, Term_QiCao2 t2) {
//				
//				if(t1.query.length() < r || t2.query.length() < r) {
//					
//					return t1.query.compareTo(t2.query);
//					
//				}else {
//					
//					return t1.query.substring(0, r).compareTo(t2.query.substring(0, r));
//					
//				}					
//			}
//		};
//
//	}
//
//	/**
//	 * Compare the terms in lexicographic order by query
//	 */
//	public int compareTo(Term_QiCao2 that) {
//		return this.query.compareTo(that.query);
//	}
//	
//
//	/**
//	 * Return a string represent term format weight followed tab followed by query
//	 */
//	public String toString() {
//		return "["+weight+"\t"+query+"]";
//	}
//	
//	
//	/**
//	 *  Testing
//	 * @param args
//	 */
//	public static void main(String[] args) {
//	
//		
//		Term_QiCao2 [] newTerms = {
//				
//				new Term_QiCao2("cat",3.0),	
//				new Term_QiCao2("dogcatcher",4.5),	
//				new Term_QiCao2("do",5.0),
//				new Term_QiCao2("dog",6.0),
//		};
//		
//		Arrays.parallelSort(newTerms,Term_QiCao2.byPrefixOrder(3));
//		
//		//Arrays.parallelSort(newTerms,Term.byReverseWeightOrder());
//		System.out.println("Sorted by Prefix: " + Arrays.toString(newTerms));
//	}
//}