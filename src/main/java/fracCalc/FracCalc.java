/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner console = new Scanner(System.in);
		System.out.println("Enter your expression(type in 'quit' to exit): ");
		String input = console.nextLine();
		// Keep repeating program until user types "quit"
		while (!input.equals("quit")) {
			produceAnswer(input);
			System.out.println("Enter your expression(type in 'quit' to exit): ");
			input = console.nextLine();
		}
		console.close();
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
		String finalAnswer = "";
		String stringHold = "";
		String stringHold1 = "";
		String whole = "";
		String whole1 = "";
		String numerator = "";
		String numerator1 = "";
		String denominator = "";
		String denominator1 = "";
		// Parse through input, and figure out the first term, operator, and second term
		int first = input.indexOf(" ");
		String firstTerm = "";
		int space = input.indexOf(" ") + 1;
		char operator = input.charAt(space);
		int space2 = input.indexOf(" ") + 1;
		while (!String.valueOf(input.charAt(space2)).equals(" ")) {
			space2 += 1;

		}
		int second = space2 + 1;
		String secondTerm = "";

		for (int i = second; i < input.length(); i++) {
			secondTerm += String.valueOf(input.charAt(second));
			second++;

		}
		for (int j = 0; j < first; j++) {
			firstTerm += String.valueOf(input.charAt(j));
		}
		// Parse through each term and separate the whole number, numerator, and
		// denominator
		int t = 0;
		int z = 0;
		int k = 0;
		boolean v = false;
		boolean g = false;
		while (t < secondTerm.length()) {
			if (String.valueOf(secondTerm.charAt(t)).equals("_")) {
				v = true;
				for (int d = 0; d < secondTerm.indexOf("_"); d++) {
					whole += String.valueOf(secondTerm.charAt(d));
				}

				for (int h = t + 1; h < secondTerm.length(); h++) {
					stringHold += String.valueOf(secondTerm.charAt(h));
					t++;
				}
				while (z < stringHold.length()) {
					if (String.valueOf(stringHold.charAt(z)).equals("/")) {
						for (int e = 0; e < stringHold.indexOf("/"); e++) {
							numerator += String.valueOf(stringHold.charAt(e));
						}

						for (int p = z + 1; p < stringHold.length(); p++) {
							denominator += String.valueOf(stringHold.charAt(p));
							z++;
						}

					}
					z++;
				}

			}
			t++;
		}

		if (v != true) {
			while (k < secondTerm.length()) {
				if (String.valueOf(secondTerm.charAt(k)).equals("/")) {
					g = true;
					whole = "0";
					for (int a = 0; a < secondTerm.indexOf("/"); a++) {
						numerator += String.valueOf(secondTerm.charAt(a));
					}

					for (int q = k + 1; q < secondTerm.length(); q++) {
						denominator += String.valueOf(secondTerm.charAt(q));
						k++;
					}

				}
				k++;
			}
			if (g != true) {
				whole = secondTerm;
				numerator = "0";
				denominator = "1";
			}

		}

		int u = 0;
		int l = 0;
		int s = 0;
		boolean f = false;
		boolean m = false;
		while (u < firstTerm.length()) {
			if (String.valueOf(firstTerm.charAt(u)).equals("_")) {
				f = true;
				for (int y = 0; y < firstTerm.indexOf("_"); y++) {
					whole1 += String.valueOf(firstTerm.charAt(y));
				}

				for (int n = u + 1; n < firstTerm.length(); n++) {
					stringHold1 += String.valueOf(firstTerm.charAt(n));
					u++;
				}
				while (l < stringHold1.length()) {
					if (String.valueOf(stringHold1.charAt(l)).equals("/")) {
						for (int r = 0; r < stringHold1.indexOf("/"); r++) {
							numerator1 += String.valueOf(stringHold1.charAt(r));
						}

						for (int b = l + 1; b < stringHold1.length(); b++) {
							denominator1 += String.valueOf(stringHold1.charAt(b));
							l++;
						}

					}
					l++;
				}

			}
			u++;
		}

		if (f != true) {
			while (s < firstTerm.length()) {
				if (String.valueOf(firstTerm.charAt(s)).equals("/")) {
					m = true;
					whole1 = "0";
					for (int o = 0; o < firstTerm.indexOf("/"); o++) {
						numerator1 += String.valueOf(firstTerm.charAt(o));
					}

					for (int w = s + 1; w < firstTerm.length(); w++) {
						denominator1 += String.valueOf(firstTerm.charAt(w));
						s++;
					}

				}
				s++;
			}
			if (m != true) {
				whole1 = firstTerm;
				numerator1 = "0";
				denominator1 = "1";
			}

		}
		String splitString2 = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
		String splitString1 = "whole:" + whole1 + " numerator:" + numerator1 + " denominator:" + denominator1;
		String simpOperator1 = "";
		String simpOperator2 = "";
		String solution = "";
		String commDenominator = "";
		String commNumerator1 = "";
		String commNumerator2 = "";
		String solution1 = "";
		String solution2 = "";
		int finalWhole = 0;
		// Find the numerator for each term, and convert it if it is in mixed fraction
		// form
		if (numerator1.equals("0")) {
			simpOperator1 = whole1;
			denominator1 = "1";
		} else if (whole1.equals("0")) {
			simpOperator1 = numerator1;
		} else if (!whole1.equals("0") && !numerator1.contentEquals("0")) {
			if (Integer.valueOf(whole1) < 0) {
				simpOperator1 = String.valueOf(
						(Integer.valueOf(whole1) * -1 * Integer.valueOf(denominator1) + Integer.valueOf(numerator1))
								* -1);
			} else {
				simpOperator1 = String
						.valueOf(Integer.valueOf(whole1) * Integer.valueOf(denominator1) + Integer.valueOf(numerator1));
			}
		} else {
			System.out.println("ERROR. Please check the first term: " + firstTerm);
		}
		if (numerator.equals("0")) {
			simpOperator2 = whole;
			denominator = "1";
		} else if (whole.equals("0")) {
			simpOperator2 = numerator;
		} else if (!whole.equals("0") && !numerator.equals("0")) {
			if (Integer.valueOf(whole) < 0) {
				simpOperator2 = String.valueOf(
						(Integer.valueOf(whole) * -1 * Integer.valueOf(denominator) + Integer.valueOf(numerator)) * -1);
			} else {
				simpOperator2 = String
						.valueOf(Integer.valueOf(whole) * Integer.valueOf(denominator) + Integer.valueOf(numerator));
			}
		} else {
			System.out.println("ERROR. Please check the second term: " + secondTerm);
		}
		// Do the calculations depending on the operator
		boolean o = true;
		if (!String.valueOf(input.charAt(input.indexOf(" ") + 2)).equals(" ")) {
			System.out.println("ERROR. Please check the operator.");
			o = false;
		} else if (Integer.valueOf(denominator) == 0 || Integer.valueOf(denominator1) == 0
				|| (Integer.valueOf(whole) == 0 & Integer.valueOf(denominator) == 1 & Integer.valueOf(numerator) == 0)
						& String.valueOf(operator).equals("/")) {
			System.out.println("ERROR. Cannot divide by zero.");
			o = false;
		} else if (String.valueOf(operator).equals("+")) {
			if (denominator1.equals(denominator)) {
				solution1 = String.valueOf(Integer.valueOf(simpOperator1) + Integer.valueOf(simpOperator2));
				solution2 = denominator;
				solution = solution1 + "/" + solution2;

			} else {
				commDenominator = String.valueOf(Integer.valueOf(denominator1) * Integer.valueOf(denominator));
				commNumerator1 = String.valueOf(Integer.valueOf(simpOperator1) * Integer.valueOf(denominator));
				commNumerator2 = String.valueOf(Integer.valueOf(simpOperator2) * Integer.valueOf(denominator1));
				solution1 = String.valueOf(Integer.valueOf(commNumerator1) + Integer.valueOf(commNumerator2));
				solution2 = commDenominator;
				solution = solution1 + "/" + solution2;

			}
		} else if (String.valueOf(operator).equals("-")) {
			if (denominator1.equals(denominator)) {
				solution1 = String.valueOf(Integer.valueOf(simpOperator1) - Integer.valueOf(simpOperator2));
				solution2 = denominator;
				solution = solution1 + "/" + solution2;

			}

			else {
				commDenominator = String.valueOf(Integer.valueOf(denominator1) * Integer.valueOf(denominator));
				commNumerator1 = String.valueOf(Integer.valueOf(simpOperator1) * Integer.valueOf(denominator));
				commNumerator2 = String.valueOf(Integer.valueOf(simpOperator2) * Integer.valueOf(denominator1));
				solution1 = String.valueOf(Integer.valueOf(commNumerator1) - Integer.valueOf(commNumerator2));
				solution2 = commDenominator;
				solution = solution1 + "/" + solution2;

			}
		} else if (String.valueOf(operator).equals("*")) {

			solution1 = String.valueOf(Integer.valueOf(simpOperator1) * Integer.valueOf(simpOperator2));
			solution2 = String.valueOf(Integer.valueOf(denominator1) * Integer.valueOf(denominator));
			solution = solution1 + "/" + solution2;

		} else if (String.valueOf(operator).equals("/")) {

			solution1 = String.valueOf(Integer.valueOf(simpOperator1) * Integer.valueOf(denominator));
			solution2 = String.valueOf(Integer.valueOf(denominator1) * Integer.valueOf(simpOperator2));
			solution = solution1 + "/" + solution2;

		}
		// Calculate highest common denominator for fraction reduction
		boolean p = true;
		int highcomden = 1;
		if (Integer.valueOf(solution2) > 0) {
			for (int x = Integer.valueOf(solution2); x > highcomden; x--) {
				if ((Integer.valueOf(solution2) % x == 0) & (Integer.valueOf(solution1) % x == 0)) {
					highcomden = x;
				p = false;
				}
			}
		}
		else {
			for (int x = Integer.valueOf(solution2) * -1; x > highcomden; x--) {
				if ((Integer.valueOf(solution2) % x == 0) & (Integer.valueOf(solution1) % x == 0)) {
					highcomden = x;
					p = false;
				}
		}
			}
		System.out.println(highcomden);
		solution1 = String.valueOf(Integer.valueOf(solution1) / highcomden);
		solution2 = String.valueOf(Integer.valueOf(solution2) / highcomden);
		System.out.println(solution1);
		System.out.println(solution2);
		int holdSolution = Integer.valueOf(solution1);
		if (Integer.valueOf(solution1) < 0) {
			holdSolution = Integer.valueOf(solution1) * -1;
		}		
		// Print solution accordingly, whether it is a whole number, fraction or mixed
		// fraction.
		if (o) {
			if (Integer.valueOf(solution1) % Integer.valueOf(solution2) == 0) {
				finalAnswer = String.valueOf(Integer.valueOf(solution1) / Integer.valueOf(solution2));
				System.out.println(finalAnswer);
			} else if (Integer.valueOf(finalWhole) == 0 & (holdSolution < Integer.valueOf(solution2))) {
				finalAnswer = solution1 + "/" + solution2;
				System.out.println(finalAnswer);
			} else if (Integer.valueOf(finalWhole) == 0 & (holdSolution < Integer.valueOf(solution2) * -1)) {
				finalAnswer = String.valueOf(Integer.valueOf(solution1) * -1) + "/" + String.valueOf(Integer.valueOf(solution2) * -1);
				System.out.println(finalAnswer);
			} else if (Integer.valueOf(solution2) < 0 || Integer.valueOf(solution1) < 0) {
				finalWhole = Integer.valueOf(solution1) / Integer.valueOf(solution2);
				if (finalWhole < 0) {
					if (Integer.valueOf(solution1) < 0)  {
						finalAnswer = String.valueOf(finalWhole) + "_"
								+ String.valueOf((Integer.valueOf(solution1) - Integer.valueOf(solution2) * finalWhole) * -1)
								+ "/" + String.valueOf(Integer.valueOf(solution2));
					}
					else if (Integer.valueOf(solution2) < 0)  {
						finalAnswer = String.valueOf(finalWhole) + "_"
								+ String.valueOf(Integer.valueOf(solution1) -  Integer.valueOf(solution2) * finalWhole)
								+ "/" + String.valueOf(Integer.valueOf(solution2) * -1);
					}
				}
				else {
					finalAnswer = String.valueOf(finalWhole) + "_"
							+ String.valueOf((Integer.valueOf(solution1) -  Integer.valueOf(solution2) * finalWhole) * -1)
							+ "/" + String.valueOf(Integer.valueOf(solution2) * -1);
				}
				
				System.out.println(finalAnswer);
				
				} 
				else if (Integer.valueOf(solution1) < 0) {
			} else {
				finalWhole = Integer.valueOf(solution1) / Integer.valueOf(solution2);
				finalAnswer = String.valueOf(finalWhole) + "_"
						+ String.valueOf(Integer.valueOf(solution1) - Integer.valueOf(solution2) * finalWhole) + "/"
						+ solution2;
				System.out.println(finalAnswer);
			}

		}
		return finalAnswer;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

	
	}
	
