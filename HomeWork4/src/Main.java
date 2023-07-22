import Task1.Builder;
import Task1.Human;
import Task1.Pilot;
import Task1.Sailor;
import Task2.Animal;
import Task2.Crocodile;
import Task2.Kangaroo;
import Task2.Tiger;

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

    }
}