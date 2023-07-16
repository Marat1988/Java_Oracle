import Task1.Person;
import Task2.City;
import Task3.Country;
import Task4.Fraction;
import Task5.Book;
import Task6.Car;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Иванов И.И.", new GregorianCalendar(1980, Calendar.FEBRUARY, 1));
        person.Recruit(new GregorianCalendar(2023, Calendar.JULY, 16), 100000);
        System.out.println("===============================================================");
        City city = new City("Калининград", "Калининградская область", "Россия", 489735);
        city.setMayor("Пономарев Максим", 10);
        System.out.println("===============================================================");
        Country country = new Country("Россия", "Евразия", 146980061);
        country.setPresident("Помонарев Максим", 20);
        System.out.println("===============================================================");
        Fraction fraction = new Fraction(2, 5);
        fraction.multiplyNumber(2, "Умножаю дробь на число");
        System.out.println(fraction);
        System.out.println("===============================================================");
        Book book = new Book("Основы программирования в Delphi 7", "Культин Н.Б.", 2009, "БХВ-Петербург", "Научная", 630);
        System.out.println(book);
        book.sellBook("Пономарев Максим", 1000);
        System.out.println("===============================================================");
        Car car = new Car("Audi A4 8V", "Audi AG", 2006, 140);
        System.out.println(car);
        car.sellCar("Петров П.П.", 480000);
    }
}