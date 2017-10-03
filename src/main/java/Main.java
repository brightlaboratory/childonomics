/**
 * The Main class serves as the main function to generate a payoff table.
 *
 * @author Sidarth Shahri
 */

import java.util.*;

public class Main {
    // Scanner object used to take input from console
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        // Variable declarations
        int numOfStrategies = 0;
        int numOfCategories = 0;
        String catName;

        // Loop to prompt user for num of strategies. Checks if input < 1
        while (numOfStrategies < 1) {
            System.out.print("Please enter how many strategies you would like: ");
            numOfStrategies = console.nextInt();
            if (numOfStrategies < 1) {
                System.out.println("Input must be greater than 0. Please try again.");
            }
        }
        Strategy stratArray[] = new Strategy[numOfStrategies];

        // Loop to prompt user for num of categories. Checks if input < 1
        while (numOfCategories < 1) {
            System.out.print("Please enter how many categories you would like: ");
            numOfCategories = console.nextInt();
            if (numOfCategories < 1) {
                System.out.println("Input must be greater than 0. Please try again.");
            }
        }
        System.out.println();               // For spacing purposes

        // Initialize Arrays
        for (int i = 0; i < numOfStrategies; i++) {
            stratArray[i] = new Strategy(numOfCategories);
            for (int j = 0; j < numOfCategories; j++) {
                stratArray[i].catArray[j] = new Category();
            }
        }

        // Loop to get names of all categories
        for (int i = 0; i < numOfCategories; i++) {
            System.out.printf("Please enter the name of Category %d: ", i+1);
            catName = console.next();
            for (int j = 0; j < numOfStrategies; j++) {
                stratArray[j].catArray[i].setCategoryName(catName);
            }
        }
        System.out.println();

        // Loop to get fraction of spend, parent value, and child value for each category of each strategy
        for (int i = 0; i < numOfStrategies; i++) {
            System.out.printf("Strategy: %d\n", i+1);
            for (int j = 0; j < numOfCategories; j++) {
                System.out.printf("    Category: %s\n", stratArray[i].catArray[j].getCategoryName());
                System.out.print("          Please enter the fraction of spend: ");
                stratArray[i].catArray[j].setFracOfSpend(console.nextDouble());
                System.out.print("          Please enter a parent value: ");
                stratArray[i].catArray[j].setParentValue(console.nextInt());
                System.out.print("          Please enter a child value: ");
                stratArray[i].catArray[j].setChildValue(console.nextInt());
            }
            System.out.println();
        }

        // Generates payoff values for each strategy in stratArray
        for (int i = 0; i < numOfStrategies; i++) {
            stratArray[i].generatePayoffValues(numOfCategories);
        }

        // Loop to print all categories
        for (int i = 0; i < numOfStrategies; i++) {
            System.out.printf("Strategy %d: \n", i+1);
            System.out.printf("     Parent Payoff Value: %.2f\n", stratArray[i].getParentPayoff());
            System.out.printf("     Child Payoff Value: %.2f\n", stratArray[i].getChildPayoff());
            for (int j = 0; j < numOfCategories; j++) {
                System.out.printf("     Category: %s\n", stratArray[i].catArray[j].getCategoryName());
                System.out.printf("         Fraction of Spend: %.2f\n", stratArray[i].catArray[j].getFracOfSpend());
                System.out.printf("         Parent Value: %d\n", stratArray[i].catArray[j].getParentValue());
                System.out.printf("         Child Value: %s\n", stratArray[i].catArray[j].getChildValue());
            }
            System.out.println();
        }

        // Making a payoff table
        for(int i = 0; i < numOfStrategies; i++) {
            for(int j = 0; j < numOfStrategies; j++) {
                System.out.printf("Parent Payoff %d: %6.2f  |  ", j, stratArray[j].getParentPayoff());
            }
            System.out.println();
            for(int j = 0; j < numOfStrategies; j++) {
                System.out.printf("Child Payoff %d:  %6.2f  |  ", i, stratArray[i].getChildPayoff());
            }
            System.out.println();
            for(int j = 0; j < 27 * numOfStrategies; j++) {
                System.out.printf("-");
            }
            System.out.println();
        }
    }
}