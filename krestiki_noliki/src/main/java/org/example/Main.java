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
    private static int HUMAN_TURN_X;
    private static int HUMAN_TURN_Y;

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkWin(HUMAN_TURN_X, HUMAN_TURN_Y, "!!!!!")) break;
                aiTurn();
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
                if (i == 0 && j == fieldSizeY - 1) System.out.print(field[i][j] + "⌉");
                else if (i == fieldSizeX - 1 && j == fieldSizeY - 1) System.out.print(field[i][j] + "⌋");
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


        do {
            System.out.print("Введите координаты хода X и Y (от 1 до 3) через пробел >>> \n");
            HUMAN_TURN_X = SCANNER.nextInt() - 1;
            HUMAN_TURN_Y = SCANNER.nextInt() - 1;
        } while (!isFieldValid(HUMAN_TURN_X, HUMAN_TURN_Y) || !isFieldEmpty(HUMAN_TURN_X, HUMAN_TURN_Y));
        field[HUMAN_TURN_X][HUMAN_TURN_Y] = HUMAN_DOT;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = rnd.nextInt(fieldSizeX);
            y = rnd.nextInt(fieldSizeY);
        } while (!isFieldEmpty(x, y));
        field[x][y] = AI_DOT;
    }

    static boolean checkWin(int x, int y, String msg) {
        if (straightLine(fieldSizeX, HUMAN_DOT, x, y)) {
            System.out.println(msg);
            return true;
        }
        if (diagonalLine(fieldSizeX, HUMAN_DOT, x, y)) {
            System.out.println(msg);
            return true;
        }
        return false;
    }

    static boolean straightLine(int fieldDirection, char c, int x, int y) {
        int dotsCount = 0;
        for (int i = x; i < fieldDirection; i++) {
            if (field[i][y] != c) break;
            dotsCount++;
        }

        if (dotsCount == DOT_TO_WIN) return true;

        for (int i = x - 1; i >= 0; i--) {
            if (field[i][y] != c) break;
            dotsCount++;
        }

        if (dotsCount == DOT_TO_WIN) return true;
        return false;
    }

    static boolean diagonalLine(int fieldDirection, char c, int x, int y) {
        int dotsCount = 0;
        System.out.println(dotsCount + "dots");
        for (; x > 0; x--) {
            System.out.println(x + 1 + "x");
            for (; y < fieldSizeY; y++) {
                System.out.println(y + 1 + "y");
                if (field[x-1][y+1] != c) {
                    break;
                }
                dotsCount++;
            }
        }


        if (dotsCount == DOT_TO_WIN) return true;


        for (int i = x + 1; i < fieldDirection; i++) {
            System.out.println(i + 1 + "x");

            for (int j = y - 1; j > 0; j--) {

                System.out.println(j + 1 + "y");
                if (field[i][j] == c) dotsCount++;
                else break;

            }
        }


        System.out.println(dotsCount + "dots");


        if (dotsCount == DOT_TO_WIN) return true;
        return false;
    }


}