package Practice2.Task3;

public class Task3 {
    public static void main(String[] args) {
        Calc<Integer> max = (a, b, c) -> Math.max(a, Math.max(b, c));
        System.out.println("Максимальное из трех числе 5, 6, 7 равна: " + max.comparingNumbers(5, 6, 7));
        Calc<Integer> min = (a, b, c) -> Math.min(a, Math.min(b, c));
        System.out.println("Минимальное из трех числе 5, 6, 7 равна: " + min.comparingNumbers(5, 6, 7));
    }
}
