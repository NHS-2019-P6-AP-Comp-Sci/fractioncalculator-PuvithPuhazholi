/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner console = new Scanner(System.in);
		System.out.println("Enter your expression: ");
		String input = console.nextLine();
		System.out.println(produceAnswer(input));
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		String string = input;
		int first = input.indexOf(" ");
		String firstTerm = "";
		int space = input.indexOf(" ") + 1;
		char operator = input.charAt(space);
		int second = input.indexOf(" ") + 3;
		String secondTerm = "";

		for (int i = second; i < input.length(); i++) {
			secondTerm += String.valueOf(input.charAt(second));
			second++;

		}
		for (int j = 0; j < first; j++) {
			firstTerm += String.valueOf(input.charAt(j));
		}
		return secondTerm;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
