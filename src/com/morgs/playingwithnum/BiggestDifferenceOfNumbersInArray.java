package com.morgs.playingwithnum;

import java.util.Scanner;

public class BiggestDifferenceOfNumbersInArray {

    private static int numberOfPositions = 0;
    private static int[] arrayOfNumbers;
    private static int biggestDifference = 0;
    private static boolean isAscending = true;

    public static void main(String[] args) {
        new BiggestDifferenceOfNumbersInArray().init();
    }

    void init(){
        readSizeOfArrayFromConsole();
        createArray();
        populateArrayFromConsole();
        getTheBiggestDifferenceBetweenNumbers(arrayOfNumbers);

        System.out.println("The biggest difference between number in array is : " + biggestDifference);
        System.out.print("the array is is ascending order ? " + isAscending);
    }

    private void populateArrayFromConsole() {
        for (int index = 0; index < arrayOfNumbers.length; index++) {
            readNumberFromConsole(index);
        }
    }

    private void readNumberFromConsole(int index) {
        System.out.print("Enter your number in the position " + index + " - ");
        Scanner myInput = new Scanner(System.in);
        arrayOfNumbers[index] = myInput.nextInt();
    }

    private void readSizeOfArrayFromConsole() {
        System.out.print("Enter the size of array ");
        Scanner myInput = new Scanner(System.in);
        numberOfPositions = myInput.nextInt();
    }

    private void createArray() {
        arrayOfNumbers = new int[numberOfPositions];
    }

    private int getTheBiggestDifferenceBetweenNumbers(int[] arrayOfNumbers) {
        for (int index = 0; index < arrayOfNumbers.length; index++) {
            if (handleIndexOutBoundException(arrayOfNumbers, index)) {
                break;
            }
            compareCurrentAndNextNumber(arrayOfNumbers, index);
        }
        return biggestDifference;
    }

    private void compareCurrentAndNextNumber(int[] arrayOfNumbers, int index) {
        int nextNumber = arrayOfNumbers[nextNumber(index)];
        int currentNumber = arrayOfNumbers[index];

        getBiggestDifference(nextNumber, currentNumber);
        checkIfArrayIsAscending(nextNumber, currentNumber);
    }

    private void checkIfArrayIsAscending(int nextNumber, int currentNumber) {
        if (currentNumber > nextNumber && isAscending) {
            isAscending = false;
        }
    }

    private void getBiggestDifference(int nextNumber, int currentNumber) {
        int result = currentNumber - nextNumber;
        result = parseToPositiveNumber(result);
        if (result > biggestDifference) {
            biggestDifference = result;
        }
    }

    private int parseToPositiveNumber(int result) {
        if (result < 0) {
            result = result * -1;
        }
        return result;
    }

    private boolean handleIndexOutBoundException(int[] arrayOfNumbers, int index) {
        return nextNumber(index) >= arrayOfNumbers.length;
    }

    private int nextNumber(int index) {
        return index + 1;
    }
}
