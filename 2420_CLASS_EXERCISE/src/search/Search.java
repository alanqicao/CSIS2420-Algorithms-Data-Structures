package search;

/**
 * Prvides algorithms to search keys in arrays of numbers.
 * 
 * @author Alan
 *
 */
public class Search {
	/**
	 * Identifies the first occurrence of element key in the array numbers and
	 * return its index. If key is not included in the array, the method returns -1.
	 * 
	 * @param number
	 * @param key
	 * @return
	 * @exception NullPointerExxception if array is null.
	 */
	public static int liner(int[] number, int key) {

		for (int i = 0; i < number.length; i++) {
			if (number[i] == key) {

				return i;

			}

		}
		return -1;

	}

	/**
	 * Identifies the first occurrence of element key in the array reference type
	 * and return its index. If key is not included in the array, the method returns
	 * -1.
	 * 
	 * @param a   array of reference type.
	 * @param key
	 * @return
	 * @exception NullPointerExxception if array is null.
	 */
	public static <T> int liner(T[] a, T key) {

		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(key)) {
			
				return i;
			}

		}
		return -1;

	}

	/**
	 * 
	 * If Key is not inclued in the array, the method returns -1
	 * 
	 * @param numbers
	 * @param key
	 * @return
	 */

	public static int binary(int[] numbers, int key) {
		return 0;// TODO
	}

}
