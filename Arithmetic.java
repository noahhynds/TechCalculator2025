package Calculator;

public class Arithmetic {
    private double x;
    private double y;

    public Arithmetic() {
    }

    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Can't divide by 0");
        }
        return x / y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

}
