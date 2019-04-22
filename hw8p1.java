package hw8;

import java.util.Random;
/**
 * * <Program that plays the game sticks References: <With whom you
 * discussed this assignment and what resources you used.> * @author <Kevin
 * O'Connell> * @version <Created: 3/23/19, Modified: n/a - description>
 */
import java.util.Scanner;

public class hw8p1 {
	/*
	 * create method for creating the number of straws at the beginning of the game
	 * create a method that creates the turns and formatting between user and
	 * program create method that checks for finish and who performed it ask user
	 * for input (yes/no) on whether or not they want to play again, if yes, restart
	 * loop
	 */
	public static void main(String[] args) {

		// makes boolean to check if user wants to play again
		boolean c = true;
		Scanner scan = new Scanner(System.in);
		// while c is true, everything here is done
		do {
			game();
			System.out.println("Do you want to play another game? yes/no");

			// takes in the next letter
			String g = scan.next();
			// if the user puts in y the game is restarted
			if (g.equals("yes") || g.equals("Yes")) {
				// keeps c true and restarts the loop
				c = true;

			}
			// if user puts in n the game is ended
			else if (g.equals("no") || g.equals("No")) {
				// prints ending statement and closes the loop
				System.out.println("Have a good day.");
				c = false;

			}
		} while (c);

	}

	public static int begin() {
		Random r = new Random();

		// where the number is randomized, inside nextInt() is where the max would be, +
		// c makes the floor of the numbers
		int x = r.nextInt(11) + 10;
//checks to see if number is one more than number divisible by 4 
		if ((x - 1) % 4 == 0) {
			x++;
		}
		// returns the final result
		return x;

	}

//checks to see if there are no sticks
	public static boolean result(int a, int b) {
		boolean f = true;
		int d = 0;
		d = a - b;
// if the game is over, it returns a boolean called true, if not then its fault
		if (d <= 0) {
			f = true;

		} else
			f = false;

		return f;
	}

	public static void game() {
//creates random class and scanner as well as a boolean that helps end the program
		Random r = new Random();
		Scanner scan = new Scanner(System.in);

		boolean e = true;

		// i checks who's turn it is, o to see how many sticks program takes, b to take
		// in how many sticks are avaliable at start
		int i = 2;

		int o = 0;
		int b = begin();
		// prints beginning amount of sticks
		System.out.println("There are " + b + " sticks at start.");
		// while there are sticks
		while (b > 0 && e == true) { // takes random number between 1 and 3 that is used to rep number of sticks
										// taken
			o = ((r.nextInt(2) + 1));
//checks to see if the game will end with the amount of sticks are taken and its programs turn
			if ((result(b, o) == true) && i % 2 == 0) {

				System.out.println("The opponent took " + o + " sticks");

				System.out.println("There are 0 sticks remaining.");

				System.out.println("You won! congrats!");
				// program ends
				e = false;
				break;
			} else {
				// otherwise subtracts numbers taken and prints out number remaining, prompts
				// user to take sticks

				b = b - o;

				System.out.println("The opponent took " + o + " sticks");

				System.out.println("There are " + b + " sticks remaining.");

				System.out.println("");
				System.out.print("Take 1,2 or 3 sticks ");
				i++;
			}

//allow user to put input in
			int u = scan.nextInt();
//forces user to input number between 1 and 3
			if (u < 1 || u > 3) {
				System.out.println("Incorrect number, please insert 1,2 or 3.");

				u = scan.nextInt();

			}
			// same as above, checks to see if game will end on number of sticks taken
			if ((result(b, u) == true) && i % 2 != 0) {
				System.out.println("The user took " + u + " sticks.");

				System.out.println("There are 0 sticks remaining.");

				System.out.println("You lost, better luck next time!");
				e = false;
				break;

			} else {

				b = b - u;

				System.out.println("The user took " + u + " sticks.");

				System.out.println("There are " + b + " sticks remaining.");

				System.out.println("");
				i++;
			}
		}

	}

}
