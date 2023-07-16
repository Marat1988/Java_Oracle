package Task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Person {
    private String fullName;
    private Calendar birthday;
    private String telNumber;
    private String city;
    private String country;
    private String homeAddress;
    public static int countPeople = 0;

    public Person(String fullName, Calendar birthday, String telNumber, String city, String country, String homeAddress) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.telNumber = telNumber;
        this.city = city;
        this.country = country;
        this.homeAddress = homeAddress;
        countPeople++;
    }

    public Person(String fullName, Calendar birthday) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.telNumber = "Не задан";
        this.city = "Не задан";
        this.country = "Не задан";
        this.homeAddress = "Не задан";
        countPeople++;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void Recruit(Calendar dateReceipt) {
        System.out.println(fullName + " принят на работу с " + new SimpleDateFormat("dd MMMM yyyy").format(dateReceipt.getTime()));
    }

    public void Recruit(Calendar dateReceipt, double salary) {
        Recruit(dateReceipt);
        System.out.println("Размер зарабатной платы - " + salary + " рублей");
    }

    @Override
    public String toString() {
        return "ФИО: " + fullName + "\n" +
                "Дата рождения: " + new SimpleDateFormat("dd MMMM yyyy").format(birthday.getTime()) + "\n" +
                "Контактный телефон: " + telNumber + "\n" +
                "Город: " + city + "\n" +
                "Страна: " + country + "\n" +
                "Домашний адрес: " + homeAddress;
    }
}
