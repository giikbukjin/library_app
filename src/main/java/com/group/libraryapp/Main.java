package com.group.libraryapp;

import java.util.Scanner;

public class Main {
    private static final int MAX_DICE_NUM = 6;

    public static void main(String[] args) throws Exception {
        int input = getUserInput();
        int[] diceNum = rollDice(input);
        printResult(diceNum);
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");
        return scanner.nextInt();
    }

    private static int[] rollDice(int rolls) {
        int[] diceNum = new int[MAX_DICE_NUM + 1];

        for (int i = 0; i < rolls; i++) {
            int rollResult = (int)(Math.random() * MAX_DICE_NUM) + 1;
            diceNum[rollResult]++;
        }
        return diceNum;
    }

    private static void printResult(int[] diceNum) {
        for (int i = 1; i < diceNum.length; i++) {
            System.out.printf("%d은(는) %d번 나왔습니다.\n", i, diceNum[i]);
        }
    }
}
