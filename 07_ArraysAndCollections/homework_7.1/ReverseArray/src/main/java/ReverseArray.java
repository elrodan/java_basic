package main.java;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        for (int i = 0; i < strings.length / 2; i++) {
            String temp = strings[i];
            strings[i] = strings[strings.length - 1 - i];
            strings[strings.length - 1 - i] = temp;
        }
        return strings;
    }

    public static String[][] rotateArray (String[][] sourceArr, int numberOfTimes) {
        int size = sourceArr.length;
        int count = 0;
        while (count < numberOfTimes) {
            String[][] rotateArr = new String[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    rotateArr[i][j] = sourceArr[size - j - 1][i];
                }
            }
            sourceArr = rotateArr;
            count++;
        }
        return sourceArr;
    }
}
