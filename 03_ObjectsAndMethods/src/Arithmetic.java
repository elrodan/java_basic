public class Arithmetic {
    private String title = "";
    private double result = 0;
    private double a = 0;
    private double b = 0;
    public Arithmetic(double x, double y) {
        a = x;
        b = y;
    }

    public void summ() {
        result = a + b;
        title = "Сумма чисел: " + result;
    }

    public void razn() {
        result = a - b;
        title = "Разность чисел: " + result;
    }

    public void proizv() {
        result = a * b;
        title = "Произведение чисел: " + result;
    }

    public void middle() {
        result = (a + b) / 2;
        title = "Среднее значение чисел: " + result;
    }

    public void max() {
        if (a < b) {
            result = b;
        } else {
            result = a;
        }
        title = "Максимальное из чисел: " + result;
    }

    public void min() {
        if (a < b) {
            result = a;
        } else {
            result = b;
        }
        title = "Минимальное из чисел: " + result;
    }

    public void print() {
        System.out.println(title);
    }

}
