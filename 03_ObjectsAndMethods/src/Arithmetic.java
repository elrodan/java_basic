public class Arithmetic {
    private double a = 0;
    private double b = 0;
    public Arithmetic(double x, double y) {
        a = x;
        b = y;
    }

    public double summ() {
        return a + b;
    }

    public double razn() {
        return a - b;
    }

    public double proizv() {
        return a * b;
    }

    public double middle() {
        return (a + b) / 2;
    }

    public double max() {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }

    public double min() {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

}
