package Exprep;

import edu.princeton.cs.algs4.Stack;

public class Demoreturnlterable {

	public static void main(String[] args) {
		
	
		Stack<String> s = new Stack<>();
		s.push("0zero");
		Iterable<String> results = transform(s);
		
		System.out.println("results: ");
		for(String el: results) {
			System.out.println(el+" ");
		}

	}
	
	/**
	 * transfor 
	 * A duplicate strings that start with a number(0-9)
	 * B sorten words that are longer than length 5 to the first 5 characters
	 * C reverse order
	 * 
	 * example
	 * []=>[]
	 * ["0zero"] =>["0zero","0zero"]
	 * ["01zeroOne"] =>["01zer","01zer"]
	 * ["a","b","c"] =>["c","b","a"]
	 * ["1step","2s","333"] =>"333","333","1step","3step","2s","2s"
	 * ["longString"]=>["longS"]
	 * ["10","x3","abcdefg"] =>["abcdef","x3","10","10"]
	 * 
	 * @param s
	 * @return
	 */
	public static Iterable<String> transform(Stack<String> s){
		
		Stack <String> stack = new Stack<>(); //transformed stack
		
		for(String el: s) {
			String current = el;
			
			if(current.length()>5) {
				
				
				current = el.substring(0, 5);
				
			}
			
			stack.push(current);
			
			if(Character.isDigit(current.charAt(0))) 
				stack.push(current);	
		}
		return stack;
			
	}

	
	}

