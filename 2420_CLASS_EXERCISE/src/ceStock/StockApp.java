package ceStock;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Demonstrates how to use a symbol table.
 * 
 * @author Qi Cao
 *
 */
public class StockApp {

	
	
	//read data from csv file and use it to fill the symbol table.
	//The csv file incluod a header that is ignored
	/**
	 * 
	 * @param myFile
	 * @param keyField
	 * @param valField
	 * @return
	 */
	private ST<java.util.Date, Double> readCSV(File myFile,int keyField,int valField) {
	
		ST <java.util.Date,Double> st = new ST<>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		In in = new In(myFile);
		in.readLine();
		
		while(in.hasNextLine()) {
			
			String line = in.readLine();
			String[] tokens = line.split(",");
			
			try {
				
				java.util.Date key = formatter.parse(tokens[keyField]);
				
				Double val = Double.parseDouble(tokens[valField]);
				
				st.put(key, val);
				
			}catch (NumberFormatException | ParseException e) {
				
				StdOut.println(""+line);
				e.printStackTrace();
				
			}
		
			
		}
		
		return st;
	}
	
	public static void main(String[] args) {
		// main
		File myFile = new File("src/ceStock/resources/AMZN.csv");
		int keyField = 0;
		int valField = 4;
		ST <Date, Double> st = readCSV(myFile, keyField, valField);

	}

}
