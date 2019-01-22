import java.util.NoSuchElementException;
import java.util.Scanner;

/* Hakan ARAS, 10 November 2018 */
/* ID: 041701036 */
/* Mathematical Parenthesis Checker */
/* Analyzes parentheses in a mathematical expression given by the user.  */

public class hakan_aras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner userExpression = new Scanner(System.in); // Keep user expression
		myStack<Character> mathStack = new myStack<Character>();
		boolean tempIteration = false; // Use or not stack for exit the program

		boolean flag = true;
		do {

			System.out.println("Enter a mathematical expression:");
			String tempStr = userExpression.nextLine();
			// System.out.println(tempStr);

			if (tempStr.charAt(0) == 'e') { // User can exit with "e".
				flag = false;
				tempIteration = false;
				System.out.println("User input is finished.");
			}

			for (char inputMath : tempStr.toCharArray()) { // Convert a String to a character

				if ((inputMath == '(') || (inputMath == '[')) {
					tempIteration = true; // use a stack
					mathStack.push(inputMath);
					System.out.print("Stack Contents: [top] " + mathStack.toString() + " [bottom]\n");
				} else if (inputMath == ')') {
					try {
						if (mathStack.peek() == '(') {
							mathStack.pop();
						} else {
							System.out.println("Parentheses do not match. Program is finished running.");
							System.exit(1);
						}
					} catch (NoSuchElementException e) {
						System.out.println("Parentheses do not match. Program is finished running.");
						System.exit(1);
					}
				} else if (inputMath == ']') {
					try {
						if (mathStack.peek() == '[') {
							mathStack.pop();
						} else {
							System.out.println("Parentheses do not match. Program is finished running.");
							System.exit(1);
						}
					} catch (NoSuchElementException e) {
						System.out.println("Parentheses do not match. Program is finished running.");
						System.exit(2);
					}
				}
			}
			if (mathStack.size() == 0 && tempIteration == true) {
				System.out.println("Parentheses are correct.");
			} else if (tempIteration == true) {
				System.out.println("Parentheses do not match: Final stack is not empty!");
			} else if (mathStack.size() == 0) {
				System.out.println("The program could not find Parentheses.");
			}
		} while (flag == true);
		userExpression.close();
	}
}
