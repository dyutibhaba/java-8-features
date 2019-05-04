/**
 * 
 */
package com.corejava.java8features.imperativeVSdeclarative;

import java.util.stream.IntStream;

/**
 * @author Bhabadyuti Bal
 *
 */
public class ImperativeVsDeclarativeEx1 {

	/**
	 * @param args
	 * Checking summation of 1...100 numbers 
	 */
	public static void main(String[] args) {
		
		/**
		 * Imperative - How style of programming
		 */
		int sum = 0;
		for(int i=0;i<=100;i++) {
			sum +=i;
		}
		System.out.println("Calculated sum in Imperative way: "+sum);
		
		/**
		 * Declarative - What style of programming
		 */
		 int sum2 = IntStream.rangeClosed(0, 100).sum();
		 System.out.println("Calculated sum in Imperative way: "+sum2);
		
	}

}
