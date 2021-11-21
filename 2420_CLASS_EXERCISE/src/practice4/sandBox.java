package practice4;

import edu.princeton.cs.algs4.StdRandom;

public class sandBox {
	private static Integer[] getRandomNumberArray(int size, int n) {
		if(n<1| n>10) {
			throw new IllegalArgumentException("Can't creat integers with the specified number of digits");
		}
		
		Integer[] array = new Integer[size];
		int counter = 0;
		
		while(counter<size) {
			
			Integer randomNumber = StdRandom.uniform((int) Math.pow(10, n - 1), (int) Math.pow(10, n));
			if( randomNumber % 2 == 0) {
				array[counter]=randomNumber;
				counter++;
			}
			
		}
		
		return array;
	}

	public static void main(String[] args) {
		Integer[] numbers = getRandomNumberArray(50000,8);
		for(Integer el: numbers) {
		System.out.println(el);
		}
	}

}
