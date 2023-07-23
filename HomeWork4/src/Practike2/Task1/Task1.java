package Practike2.Task1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task1 {
    public static void main(String[] args) {
        Calc sum = (a, b, c) -> a + b + c;
        System.out.println(sum.MyCalc(5, 4, 6));
        Calc composition = (a, b, c) -> a * b * c;
        System.out.println(composition.MyCalc(5, 4, 6));

        MyDateTime time = () -> System.out.println(LocalTime.now());
        time.getTimeDate();

        MyDateTime date = () -> System.out.println(LocalDate.now());
        date.getTimeDate();


    }


}
