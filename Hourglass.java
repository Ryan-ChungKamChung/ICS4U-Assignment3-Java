/*
 * This program prints the an hourglass in a recursive manner.
 *
 * @author  Ryan Chung
 * @version 1.0
 * @since   2021-12-16
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** This is the recursive hourglass printer. */
final class Hourglass {

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private Hourglass() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The recursive function that produces the hourglass.
     *
     * @param size the size of the hourglass, inclusive
     * @param offset the offset
     * */
    private static void hourglass(final int size, final int offset) {
        printHourglass(size, offset);
        if (size > 1) {
            hourglass(size - 1, offset + 1);
            printHourglass(size, offset);
        } else if (size == 1) {
            printHourglass(size, offset);
        }
    }

    /**
     * Prints out the hourglass line by line.
     *
     * @param size the size of the hourglass, inclusive
     * @param offset the offset
     * */
    private static void printHourglass(final int size, final int offset) {
        System.out.println(" ".repeat(offset) + "* ".repeat(size));
    }

    /**
     * The main function takes user input and validates it.
     *
     * @param args No args will be used.
     * */
    public static void main(final String[] args) {
        try {
            System.out.print("Please enter the size of the hourglass: ");
            final String sizeString = new BufferedReader(
                    new InputStreamReader(System.in)
            ).readLine();

            final int size = Integer.parseInt(sizeString);

            if (size >= 1) {
                System.out.println("");
                hourglass(size, 0);
            } else {
                System.out.println(
                    "Please enter an integer greater than one.");
            }
        } catch (IOException | NumberFormatException exception) {
            System.out.println("Please enter an integer.");
        } finally {
            System.out.println("\nDone.");
        }
    }
}
