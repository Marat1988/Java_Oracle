import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите номер задания (от 1 до 12): ");
            int numberTask = scanner.nextInt();
            switch (numberTask) {
                case 1 -> Task1();
                case 2 -> Task2();
                case 3 -> Task3();
                case 4 -> Task4();
                case 5 -> Task5();
                case 6 -> Task6();
                case 7 -> Task7();
                case 8 -> Task8();
                case 9 -> Task9();
                case 10 -> Task10();
                case 11 -> Task11();
                case 12 -> Task12();
                default -> System.out.println("Введен не правильный номер задания");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static void Task1() {
        System.out.println("You time is limited,");
        System.out.println("\tso don't waste it");
        System.out.println("\t\tliving someone else's life");
        System.out.println("\t\t\tSteve Jobs");
    }

    public static void Task2() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите число: ");
            double number = scanner.nextDouble();
            System.out.print("Введите процент: ");
            double percent = scanner.nextDouble();
            double result = number * percent / 100;
            System.out.println(String.format("%f  процентов от числа %f равно %f", percent, number, result));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static void Task3() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите " + (i + 1) + " число: ");
            String userInputNumber = scanner.next();
            result.append(userInputNumber);
        }
        try {
            int number = Integer.parseInt(result.toString());
            System.out.println("Получившееся число: " + number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static void Task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите шестизначное число: ");
        try {
            int number = scanner.nextInt();
            if (number < 100000 || number > 999999) {
                System.out.println("Вы ввели не шестизначное число");
            } else {
                StringBuilder stringBuilder = new StringBuilder(Integer.toString(number));
                char temp = stringBuilder.charAt(0);
                stringBuilder.setCharAt(0, stringBuilder.charAt(5));
                stringBuilder.setCharAt(5, temp);

                temp = stringBuilder.charAt(1);
                stringBuilder.setCharAt(1, stringBuilder.charAt(4));
                stringBuilder.setCharAt(4, temp);

                System.out.println("Получившееся число: " + stringBuilder.toString());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static void Task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число от 1 до 12: ");
        try {
            int number = scanner.nextInt();
            switch (number) {
                case 1, 2, 12 -> System.out.println("Winter");
                case 3, 4, 5 -> System.out.println("Spring");
                case 6, 7, 8 -> System.out.println("Summer");
                case 9, 10, 11 -> System.out.println("Autumn");
                default -> System.out.println("Не верный ввод");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static void Task6() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите количество метров: ");
            int meters = scanner.nextInt();
            System.out.println("Введите:\n1 для перевода в мили;\n2 для перевода в дюймы;\n3 для перевода в ярды;");
            int chooseUser = scanner.nextInt();
            switch (chooseUser) {
                case 1 -> System.out.println(meters * 0.00062);
                case 2 -> System.out.println(meters * 39.37);
                case 3 -> System.out.println(meters * 1.09);
                default -> System.out.println("Не верный ввод");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static void Task7() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите начало диапазона: ");
            int beginRange = scanner.nextInt();
            System.out.print("Введиет конец диапазона: ");
            int endRange = scanner.nextInt();
            int[] arr = IntStream.range(Math.min(beginRange, endRange), Math.max(beginRange, endRange) + 1).toArray();
            int[] notEven = Arrays.stream(arr).filter(i -> i % 2 != 0).toArray();
            System.out.println("Не четные числа: " + Arrays.toString(notEven));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static void Task8() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите начало диапазона: ");
            int beginRange = scanner.nextInt();
            System.out.print("Введите конец диапазона: ");
            int endRange = scanner.nextInt();
            for (int i = Math.min(beginRange, endRange); i <= Math.max(beginRange, endRange); i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.print(i + "*" + j + "=" + (i * j) + "\t");
                }
                System.out.print("\n");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        scanner.close();
    }

    public static void Task9() {
        int[] arr = IntStream.range(0, 20).map(i -> (int) ((Math.random() * 40) - 20)).toArray();
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Максимальный элемент массива равен: " + Arrays.stream(arr).min().getAsInt());
        System.out.println("Минимальный элемент массива равен: " + Arrays.stream(arr).min().getAsInt());
        System.out.println("Количество отрицательных элементов массива равно: " + Arrays.stream(arr).filter(i -> i < 0).count());
        System.out.println("Количество положительных элементов массива равно: " + Arrays.stream(arr).filter(i -> i > 0).count());
        System.out.println("Количество нулей равно: " + Arrays.stream(arr).filter(i -> i == 0).count());
    }

    public static void Task10() {
        int[] arr = IntStream.range(0, 20).map(i -> (int) ((Math.random() * 40) - 20)).toArray();
        int[] evenArr = Arrays.stream(arr).filter(i -> i % 2 == 0).toArray();
        int[] notEvenArr = Arrays.stream(arr).filter(i -> i % 2 != 0).toArray();
        int[] negativeArr = Arrays.stream(arr).filter(i -> i < 0).toArray();
        int[] positiveArr = Arrays.stream(arr).filter(i -> i > 0).toArray();
        System.out.println("Исходные массив: " + Arrays.toString(arr));
        System.out.println("Четные числа: " + Arrays.toString(evenArr));
        System.out.println("Не четные числа: " + Arrays.toString(notEvenArr));
        System.out.println("Отрицательные числа: " + Arrays.toString(negativeArr));
        System.out.println("Положительные числа: " + Arrays.toString(positiveArr));
    }

    public static void Task11() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите длину линии: ");
            int characterLength = scanner.nextInt();
            System.out.print("Введите символ: ");
            char symbol = scanner.next().charAt(0);
            System.out.println("Введите направление:\n1 - горизонтальная линия;\n2 - вертикальная линия");
            int direction = scanner.nextInt();

            for (int i = 0; i < characterLength; i++) {
                if (direction == 2) {
                    System.out.println(symbol);
                } else {
                    System.out.print(symbol); //По-умолчанию считаю, что линия горизонтальная
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        scanner.close();
    }

    public static void Task12() {
        Scanner scanner = new Scanner(System.in);
        int[] arr = IntStream.range(0, 20).map(i -> (int) ((Math.random() * 40) - 20)).toArray();
        System.out.println("Исходные массив: " + Arrays.toString(arr));
        System.out.println("Введите:\n1 - для сортировки по возрастанию;\n2 - для сортировки по убыванию");
        int chooseUser = scanner.nextInt();
        if (chooseUser == 1) {
            Arrays.sort(arr);
            System.out.println("Отсортированный массив по возрастанию: " + Arrays.toString(arr));
        } else {
            Integer[] newArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(newArray, Collections.reverseOrder());
            System.out.println("Отсортированный массив по убыванию: " + Arrays.toString(newArray));
        }
        scanner.close();
    }
}