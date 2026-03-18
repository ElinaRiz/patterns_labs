import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Proxy proxy = new Proxy(5000);
            double num1 = 6.2;
            double num2 = 3;
            System.out.println("Результат умножения двух вещественных чисел " + num1 + " и " + num2 + ": " + proxy.multiply(num1, num2));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}