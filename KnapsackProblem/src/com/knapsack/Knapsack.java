package com.knapsack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Knapsack {

    private int numberOfItems;
    private int knapsackCapacity;
    private int maxWeight;
    private int maxValue;

    private ArrayList<Double> valuesOfItems;
    private ArrayList<Double> weightOfItems;

    public Knapsack() {
        this.numberOfItems = 0;
        this.knapsackCapacity = 0;
        this.maxValue = 0;
        this.maxWeight = 0;
        this.valuesOfItems = new ArrayList<>();
        this.weightOfItems = new ArrayList<>();
    }

    public void fillData() {

        Scanner c = new Scanner(System.in);

        System.out.println("Enter the knapsack capacity: ");
        knapsackCapacity = (int) inputNumber();

        System.out.println("Enter the number of items: ");
        numberOfItems = (int) inputNumber();

        System.out.println("Enter the max-weight for items: ");
        maxWeight = (int) inputNumber();

        System.out.println("Enter the max-values for items: ");
        maxValue = (int) inputNumber();

        Random randomValue = new Random(10);
        Random randomWeight = new Random(5);

        // Randomly generate weight and value
        for (int i = 0; i < numberOfItems; i++) {
            valuesOfItems.add((double) randomValue.nextInt(maxValue) + 1);
            weightOfItems.add((double) randomWeight.nextInt(maxWeight) + 1);
        }

    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // Function to take input as a number
    public static Number inputNumber() {

        String input;
        Scanner c = new Scanner(System.in);

        char ch;
        do {
            input = c.nextLine();
            if (isInteger(input)) {
                return Integer.parseInt(input);
            } else if (isDouble(input)) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Not a number. Would you like to try again?(Y/n)");
                ch = c.next().charAt(0);
            }
            if (ch == 'n' || ch == 'N')
                System.exit(1);
        } while (true);
    }

}
