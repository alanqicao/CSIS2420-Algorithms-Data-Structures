package ceStock;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private static ST<Date, Double> readCSV(String myFile,int keyField,int valField) {
	
		ST <Date,Double> st = new ST<>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		In in = new In(myFile);
		in.readLine();
		
		while(in.hasNextLine()) {
			
			String line = in.readLine();
			String[] tokens = line.split(",");
			
			try {
				
				Date key = formatter.parse(tokens[keyField]);
				
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
		String fileString = "src/ceStock/resources/AMZN.csv";				
		int keyField = 0;
		int valField = 4;	
		
		ST <java.util.Date, Double> st = readCSV(fileString, keyField, valField);
		
		System.out.println("Number of element: "+st.size());		

		System.out.printf("\nA) Oldest closing price: %tF $%.2f.",st.min(),st.get(st.min()));
		System.out.printf("\nB) Newest closing price: %tF $%.2f.",st.max(),st.get(st.max()));		
		String condition = (st.get(st.max())-st.get(st.min())>0)? "increased":"decreased";
		System.out.printf("\nC) The closing price %s by $%.2f.",condition,st.get(st.max())-st.get(st.min()));
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");		
		Date date1 = null;
		Date date2 = null;
		Date date2019 = null;
		Date date2020 =null;
		try {
			date1 = formatter.parse("2018-08-31");
			date2 = formatter.parse("2020-03-10");
			date2019 = formatter.parse("2019-01-01");
			date2020 = formatter.parse("2020-12-31");
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		System.out.printf("\n\nD) Closing price from 08/31/18: $%.2f.",st.get(date1));
		System.out.printf("\nE) Closing price from 03/10/20: $%.2f.",st.get(date2));
		condition = st.get(date2)-st.get(date1)>0? "increased":"decreased";
		System.out.printf("\nF) The closing price %s by $%.2f.",condition,Math.abs(st.get(date2)-st.get(date1)));
				
		System.out.printf("\n\nG) First available closing price in 2019: %tD $%.2f",st.ceiling(date2019),st.get(st.ceiling(date2019)));
		System.out.printf("\nH) Last available closing price in 2020: %tD $%.2f",st.floor(date2020),st.get(st.floor(date2020)));

		

	}

}
