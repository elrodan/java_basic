package main.java;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Hospital {
    private static final float MIN_TEMP = 32;
    private static final float MAX_TEMP = 40;

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] arrayPatients = new float[patientsCount];
        for (int i = 0; i < arrayPatients.length; i++) {
            arrayPatients[i] += ((Math.random() * ((MAX_TEMP - MIN_TEMP))) + MIN_TEMP);
        }
        return arrayPatients;
    }

    public static String getReport(float[] temperatureData) {

        float sumTemp = 0;
        int healthyPatientsCount = 0;
        String allTemp = "";

        for(int i=0; i < temperatureData.length; i++) {
            if ((temperatureData[i] >= 36.2F) && (temperatureData[i] <= 36.9F)) {
                ++healthyPatientsCount;
            }
            allTemp += String.format("%.1f",temperatureData[i]) + " ";
            sumTemp += temperatureData[i];
        }
        sumTemp = Float.parseFloat(String.format("%.2f", (sumTemp / temperatureData.length)));
        System.out.println(allTemp);
        String report =
                "Температуры пациентов: " + allTemp.trim() +
                        "\nСредняя температура: " + sumTemp +
                        "\nКоличество здоровых: " + healthyPatientsCount;

        return report;
    }
}
