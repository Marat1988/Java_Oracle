import Task1.Builder;
import Task1.Human;
import Task1.Pilot;
import Task1.Sailor;
import Task2.Animal;
import Task2.Crocodile;
import Task2.Kangaroo;
import Task2.Tiger;
import Task3.Money;
import Task3.Product;
import Task4.*;
import Task5.*;
import Task7_8.MyArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human[] humans = {
                new Builder(30, "Иванов И.И.", "Плотник"),
                new Sailor(20, "Петров П.П.", 100),
                new Pilot(40, "Сидоров С.С.", 1000)
        };
        Arrays.stream(humans).forEach(System.out::println);
        System.out.println("======================================================================");
        Animal[] animals = {
                new Crocodile("Гена", "Пресмыкающиеся", 5),
                new Kangaroo("Степан", "Млекопитающие", 70),
                new Tiger("Тигрюля", "Кошачьих", 60)
        };
        Arrays.stream(animals).forEach(System.out::println);
        System.out.println("======================================================================");
        try {
            Product product = new Product("Мышь компьютерная", new Money(1450, 34));
            System.out.println(product);
            product.reducePrice(20, 57);
            System.out.println(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("======================================================================");

        Device[] devices = {
                new Car("Z4 30i, 2018", "BMW"),
                new Nuke("Tuvio MG7T20SM1", "Россия"),
                new Parahod("Елизавета", 300),
                new Teapot("EK-1702", "Черный")

        };
        Arrays.stream(devices).forEach(item -> {
            System.out.println(item);
            System.out.println("*********************Методы*********************");
            item.Sound();
            item.Show();
            item.Desc();
            System.out.println();
        });
        System.out.println("======================================================================");

        MusicDevice[] musicDevice = {
                new Trombone("LD-T800/LD-T820", "LADE"),
                new Ukulele("TUTTI  JR-20 SCH MUSIC ", "Белый"),
                new Violin("Скрипка Antonio Lavazza VL-32 1/2", 1),
                new Violoncello("Beginer Genial 2 Nitro Виолончель 1/2, Gliga B-C012", 91265)
        };
        Arrays.stream(musicDevice).forEach(item -> {
            System.out.println(item);
            System.out.println("*********************Методы*********************");
            item.Sound();
            item.Show();
            item.Desc();
            item.History();
            System.out.println();
        });
        System.out.println("======================================================================");

        MyArray arr = new MyArray(new int[]{1, 3, 7, 8, 2, 4, 7, 8, 5, 4});
        System.out.println("Исходный массив: ");
        arr.Print();
        System.out.println("Максимальное значение массива равно: " + arr.Max());
        System.out.println("Минимальное значение массива равно: " + arr.Min());
        System.out.println("Среднее арифметическое знаначение массива равно: " + arr.Avg());

    }
}