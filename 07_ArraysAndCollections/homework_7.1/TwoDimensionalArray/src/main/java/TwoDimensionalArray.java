package main.java;

public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] twoDimArr = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                twoDimArr[i][j] = ' ';
                if (i == j || i + j == size - 1) {
                    twoDimArr[i][j] = symbol;
                }
            }
        }
        return twoDimArr;
    }
}
