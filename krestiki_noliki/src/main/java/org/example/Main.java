package org.example;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int DOT_TO_WIN = 3;
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_FIELD = '☼';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static char[][] field;
    private static final Random rnd = new Random();
    private static int fieldSizeX;
    private static int fieldSizeY;

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();

            }
        }
    }

    private static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 10;

        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = EMPTY_FIELD;
            }
        }
    }

    private static void printField() {
        for (int i = 0; i < fieldSizeY * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.print("+");
        for (int i = 0; i < fieldSizeY * 2; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            if (i == 0) {
                System.out.print(i + 1 + "⌈");
            } else if (i == fieldSizeX - 1) {
                System.out.print(i + 1 + "⌊");
            } else System.out.print(i + 1 + "⎮");

            for (int j = 0; j < fieldSizeY; j++) {
                if (i == 0 && j == fieldSizeY - 1)
                    System.out.print(field[i][j] + "⌉");
                else if (i == fieldSizeX - 1 && j == fieldSizeY - 1)
                    System.out.print(field[i][j] + "⌋");
                else System.out.print(field[i][j] + "⎮");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeY * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static boolean isFieldValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    static boolean isFieldEmpty(int x, int y) {
        return field[x][y] == EMPTY_FIELD;
    }

    private static void humanTurn() {

        int x, y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isFieldValid(x, y) || !isFieldEmpty(x, y));
        field[x][y] = HUMAN_DOT;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = rnd.nextInt(fieldSizeX);
            y = rnd.nextInt(fieldSizeY);
        }
        while (!isFieldEmpty(x, y));
        field[x][y] = AI_DOT;
    }

    static boolean checkWin(int[] turn) {
        int x = turn[0];
        int y = turn[1];
        return straightLine(fieldSizeX,HUMAN_DOT,x,y);
    }

    static boolean straightLine(int fieldDirection, char c, int x, int y) {
        int dotsCount = 0;
        for (int i = x; i < fieldDirection; i++) {
            if(field[i][y]==c)
                dotsCount++;
        }
        if(dotsCount == DOT_TO_WIN)
            return true;
        for (int i = x; i >= 0; i--) {
            if(field[i][y]==c)
                dotsCount++;
        }
        if(dotsCount == DOT_TO_WIN)
            return true;
        return false;
    }


}