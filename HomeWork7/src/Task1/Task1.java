package Task1;

import java.time.Duration;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task1 {
    public static void main(String[] args) {
        Predicate<Integer> isLeapYear = (year) -> {
            GregorianCalendar calendar = new GregorianCalendar();
            return calendar.isLeapYear(year);
        };
        System.out.println("2004 год является високосным (true) или не является високосным (false): " + isLeapYear.test(2004));
        System.out.println("===================================================================");

        MyBinaryOperator countDays = (userDate1, userDate2) -> {
            LocalDate dateBegin = LocalDate.of(userDate1.getYear(), userDate1.getMonth(), userDate1.getDay());
            LocalDate dateEnd = LocalDate.of(userDate2.getYear(), userDate2.getMonth(), userDate2.getDay());
            return Duration.between(dateBegin.atStartOfDay(), dateEnd.atStartOfDay()).toDays();
        };

        MyBinaryOperator countFullWeek = (userDate1, userDate2) -> {
            LocalDate dateBegin = LocalDate.of(userDate1.getYear(), userDate1.getMonth(), userDate1.getDay());
            LocalDate dateEnd = LocalDate.of(userDate2.getYear(), userDate2.getMonth(), userDate2.getDay());
            final int countDaysOfWeek = 7;
            if (dateBegin.getDayOfWeek().getValue() != 1) { //Если не понедельник, то неделя не полная и дату предвигаю
                dateBegin = dateBegin.plusDays(7 - dateBegin.getDayOfWeek().getValue() + 1);
            }
            if (dateEnd.getDayOfWeek().getValue() != 7) { //Если не воскресенье, то неделя не полная и дату предвигаю
                dateEnd = dateEnd.minusDays(dateEnd.getDayOfWeek().getValue());
            }
            return (Duration.between(dateBegin.atStartOfDay(), dateEnd.atStartOfDay()).toDays() + 1) / countDaysOfWeek;
        };

        UserDate userDate1 = new UserDate(1, 7, 2023);
        UserDate userDate2 = new UserDate(3, 8, 2023);
        System.out.println("Количество дней между двумя датами равно " + userDate1 + " и " + userDate2 + " равно " + countDays.apply(userDate1, userDate2));
        System.out.println("===================================================================");
        System.out.println("Количество полных недель между двумя датами " + userDate1 + " и " + userDate2 + " равно " + countFullWeek.apply(userDate1, userDate2));

        Function<UserDate, String> dayWeek = (userDate)-> {
            LocalDate localDate = LocalDate.of(userDate.getYear(),userDate.getMonth(), userDate.getDay());
                return localDate.getDayOfWeek().name();
        };

        System.out.println("===================================================================");

        System.out.println("День недели в дате " + userDate1 + " " + dayWeek.apply(userDate1));
    }
}
