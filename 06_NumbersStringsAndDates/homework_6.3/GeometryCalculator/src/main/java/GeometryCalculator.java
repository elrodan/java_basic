package main.java;

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double square = Math.PI * Math.pow(radius, 2);
        return square;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double sphereVolume = (double) 4 / 3 * Math.PI * Math.pow(Math.abs(radius), 3);
        return sphereVolume;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if ((a + b) > c && (b + c) > a && (a + c) > b) {
            return true;
        } else {
            return false;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double semiPerimeter = (a + b + c) / 2;
        if (isTrianglePossible(a, b, c) == true) {
            double square = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
            return square;
        }
        return -1.0;
    }
}
