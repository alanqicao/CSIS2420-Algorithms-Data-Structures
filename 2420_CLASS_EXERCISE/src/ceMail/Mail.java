package ceMail;

import edu.princeton.cs.algs4.StdRandom;

public class Mail implements Comparable<Mail>{
	
	
	private DeliveryType type;
	private String mailCode;
	
	public Mail(DeliveryType type, String mailCode) {
		
		this.type = type;
		this.mailCode = mailCode;
	}
	
	/**
	 * create a new mail object with a random type
	 * and random mail code.
	 */
	public Mail() {

		this.type = randomType();
		this.mailCode = randomMailCode();
	}
	
	/**
	 * Generates a mail code that is a string consisting of five random upper-case letter
	 * @return mail code;
	 */
	private String randomMailCode() {
		
		
		
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i<5;i++) {
			
			str.append((char) ('A'+StdRandom.uniform(26)));
		}
		
		
		char[] code =new char[5];
		
		for(int j=0; j<code.length;j++) {
			
			code[j] = (char) ('A'+StdRandom.uniform(26));
		}
		//return String.valuOf(code)
		
		
		return str.toString();
	}
	
	private DeliveryType randomType() {
		DeliveryType [] allTypes = DeliveryType.values();
		
		
		
		return allTypes[StdRandom.uniform(allTypes.length)];
	}

	@Override
	public String toString() {
		return mailCode+"("+type+")";
	}

	@Override
	public int compareTo(Mail other) {
		if(this.type == other.type) {
			return this.mailCode.compareTo(other.mailCode);
		}else
		return	this.type.compareTo(other.type);
	}
	
	
	
}
