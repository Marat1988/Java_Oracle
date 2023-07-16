import PartOne_Task4_Fraction.Fraction;
import PartOne_Task1_UNION_PartTwo_Task1_Person.Person;
import PartOne_Task2_City.City;
import PartOne_Task3_Country.Country;
import PartTwo_Task2_Figure.Figure;
import PartTwo_Task3_Calc.Calc;
import PartTwo_Task4_Human.Builder;
import PartTwo_Task4_Human.Pilot;
import PartTwo_Task4_Human.Sailor;
import PartTwo_Task5_Passport.OverseasPassport;
import PartTwo_Task6_Worker.*;
import PartTwo_Task7_Figure.*;
import PartTwo_Task7_Figure.Rectangle;
import PartTwo_Task8_IShow.MyArray;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person human1 = new Person("Тухтаров М.Р.", new GregorianCalendar(1988, Calendar.JULY, 3), "+7988678657", "Калининград", "Россия", "Куйбышева 11");
        System.out.println(human1);
        System.out.println("***********************************************");
        Person human2 = new Person("Пономарев М.Б.", new GregorianCalendar(1980, Calendar.JANUARY, 1), "+79115678904", "Калининград", "Россия", "Академия ТОП");
        System.out.println(human2);
        System.out.println("Количество созданных объектов класса человек равно " + Person.countPeople);
        System.out.println("===============================================");

        City city = new City("Калининград", "Калининградская область", "Россия", 489735, 236001, 4012);
        System.out.println(city);
        System.out.println("===============================================");

        Country country = new Country("Россия", "Евразия", 14698061, "+7", "Москва", new HashSet<>());
        country.addCity("Калининград");
        country.addCity("Казань");
        country.addCity("Сызрань");
        System.out.println(country);
        System.out.println("===============================================");

        Fraction fraction1 = new Fraction(3, 5);
        Fraction fraction2 = new Fraction(1, 2);
        System.out.println(fraction1 + " + " + fraction2 + " = " + Fraction.plus(fraction1, fraction2));
        System.out.println(fraction1 + " - " + fraction2 + " = " + Fraction.minus(fraction1, fraction2));
        System.out.println(fraction1 + " * " + fraction2 + " = " + Fraction.multiplication(fraction1, fraction2));
        System.out.println(fraction1 + " % " + fraction2 + " = " + Fraction.division(fraction1, fraction2));
        System.out.println("===============================================");

        System.out.println("Площадь квадрата со сторонами равное 5см равно: " + Figure.squareArea(5));
        System.out.println("Площадь квадрата с длиной 5см и шириной 10см равно: " + Figure.rectangleArea(5, 10));
        System.out.println("Количество подсчетов площадей равно: " + Figure.getNumberCountingAreas());
        System.out.println("===============================================");

        System.out.println("Факториал числа 5 равно " + Calc.Factorial(5));
        System.out.println("Среднее арифметическое чисел 6, 8, 9, 2 равно " + Calc.avgFourArguments(6, 8, 9, 2));
        System.out.println("Минимальное четырех числе 6, 8, 9, 2 равно " + Calc.minFourArguments(6, 8, 9, 2));
        System.out.println("Максимальное четырех числе 6, 8, 9, 2 равно " + Calc.maxFourArguments(6, 8, 9, 2));
        System.out.println("===============================================");

        Builder builder = new Builder("Пономарев Максим", 45, "Прораб");
        System.out.println(builder);
        System.out.println("***********************************************");
        Sailor sailor = new Sailor("Зорин Иван", 43, 100);
        System.out.println(sailor);
        System.out.println("***********************************************");
        Pilot pilot = new Pilot("Иван Кожедуб", 30, 1000);
        System.out.println(pilot);
        System.out.println("===============================================");

        OverseasPassport overseasPassport = new OverseasPassport(2233, 5678, new GregorianCalendar(1988, Calendar.JULY, 3), 6788, "Какая-то инфо и визах");
        System.out.println(overseasPassport);
        System.out.println("===============================================");

        Worker president = new President();
        president.Print();
        System.out.println("***********************************************");
        Worker security = new Security();
        security.Print();
        System.out.println("***********************************************");
        Worker manager = new Manager();
        manager.Print();
        System.out.println("***********************************************");
        Worker engineer = new Engineer();
        engineer.Print();
        System.out.println("===============================================");

        Figure_New[] figures = {new Circle(5), new Rectangle(5, 10), new RightTriangle(7, 8), new Trapezoid(8, 10, 60)};
        for (Figure_New figure : figures) {
            System.out.println("Ппощадь равна " + figure.getArea());
        }
        System.out.println("===============================================");

        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4, 5});
        myArray.Print();
        myArray.Print("Пономарев");

        System.out.println("===============================================");

        /*Дополнительные задания*/
        Additional_Task1();
        Additional_Task2();
        Additional_Task3();

    }

    public static void Additional_Task1() { //Дополнительное задание 1
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите число: ");
            int userNumber = scanner.nextInt();
            if (userNumber < 100000 || userNumber > 999999) {
                System.out.println("Вы ввели не шестизначное число");
            } else {
                char[] arr = Integer.toString(userNumber).toCharArray();
                int leftNumber = Integer.parseInt(Character.toString(arr[0])) + Integer.parseInt(Character.toString(arr[1])) + Integer.parseInt(Character.toString(arr[2]));
                int rightNumber = Integer.parseInt(Character.toString(arr[3])) + Integer.parseInt(Character.toString(arr[4])) + Integer.parseInt(Character.toString(arr[5]));
                System.out.println((leftNumber == rightNumber) ? "Число счастливое" : "Число не счастливое");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("===============================================");
    }

    public static void Additional_Task2() { //Дополнительное задание 2
        System.out.println("Числа Армстронга");
        for (int i = 1; i < 10000000; i++) {
            char[] arrChar = Integer.toString(i).toCharArray();
            int sum = 0;
            for (char c : arrChar) {
                sum += (int) Math.pow(Integer.parseInt(Character.toString(c)), arrChar.length);
            }
            if (sum == i) {
                System.out.println(sum);
            }
        }
        System.out.println("===============================================");
    }

    public static void Additional_Task3() { //Дополнительное задание 3
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите число ярусов: ");
            int numberTiers = scanner.nextInt(); //Число ярусов
            System.out.print("Введите высоту первого яруса: ");
            int heightFirstTier = scanner.nextInt(); //Высота первого яруса
            int sizeLine = 1;
            for (int i = 0; i < ((heightFirstTier - 1) + (numberTiers - 1)); i++) {
                sizeLine += 2;
            }

            int heightTier = heightFirstTier;
            for (int i = 0; i < numberTiers; i++) {
                paintTier(heightTier, sizeLine);
                heightTier++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void paintTier(int rowCount, int sizeLine) { //Вспомогательный метод для прорисовки яруса
        int step = 0;
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < sizeLine; col++) {
                int beginRange = sizeLine / 2 - step;
                int endRange = sizeLine / 2 + step;
                if (col >= beginRange && col <= endRange) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            step += 1;
        }
    }
}