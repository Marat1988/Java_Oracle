import HomeWork1.Builder;
import HomeWork1.Human;
import HomeWork1.Pilot;
import HomeWork1.Sailor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Human[] humans = {
                new Builder(30, "Иванов И.И.", "Плотник"),
                new Sailor(20, "Петров П.П.", 100),
                new Pilot(40, "Сидоров С.С.", 1000)
        };
        Arrays.stream(humans).forEach(System.out::println);

    }
}