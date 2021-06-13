package ru.skillbox;

public class ArithmeticCalculator {
    public int a = 0;
    public int b = 0;

    public ArithmeticCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calculate(Operation operation) {
        switch (operation) {
            case ADD: return a + b;
            case SUBTRACT: return a - b;
            case MULTIPLY: return a * b;
        }
        return 0;
    }

}
