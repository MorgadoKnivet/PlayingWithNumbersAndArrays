package com.morgs.playingwithnum;

import java.util.Scanner;

public class BiggestDifferenceOfNumbersInArray {

    private BiggestDifferenceOfNumbersInArray() {
        super();
    }

    private int numberOfPositions = 0;
    private int[] arrayOfNumbers;

    public static void main(String[] args) {
        new BiggestDifferenceOfNumbersInArray().init();
    }

    void init() {
        readSizeOfArrayFromConsole();
        createArray();
        populateArrayFromConsole();

        // PTI question A
        int biggestDifference = getTheBiggestDifferenceBetweenNumbers();

        // PTI question B
        boolean isAscending = isArrayAscending();

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
        try {
            System.out.print("Enter the size of array - ");
            Scanner myInput = new Scanner(System.in);
            numberOfPositions = myInput.nextInt();
            if (numberOfPositions == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.print("Something wrong happened - you have to write a number bigger than 0");
            System.exit(400);
        }
    }

    private void createArray() {
        arrayOfNumbers = new int[numberOfPositions];
    }

    private int getTheBiggestDifferenceBetweenNumbers() {
        // In the real world, for example, a software to a bank, we will use libs like java.util.Array.
        // int[] sortedArray = Arrays.stream(arrayOfNumbers).sorted().toArray();
        int[] sortedArray = bubbleSort(arrayOfNumbers);
        int firstNumber = sortedArray[0];
        int lastNumber = sortedArray[sortedArray.length - 1];
        return parseToPositiveNumber(firstNumber - lastNumber);
    }

    private boolean isArrayAscending() {
        for (int index = 0; index < arrayOfNumbers.length; index++) {
            if (handleIndexOutBoundException(arrayOfNumbers, index)) {
                return true;
            }
            int nextNumber = arrayOfNumbers[nextNumber(index)];
            int currentNumber = arrayOfNumbers[index];
            if (currentNumberBiggerThanNext(currentNumber, nextNumber)) {
                return false;
            }
        }
        return true;
    }

    private boolean currentNumberBiggerThanNext(int currentNumber, int nextNumber) {
        return currentNumber > nextNumber;
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

    int[] bubbleSort(int[] arrayOfNumbers) {
        int[] arr = arrayOfNumbers.clone();
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}