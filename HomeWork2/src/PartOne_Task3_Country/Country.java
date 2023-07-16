package PartOne_Task3_Country;

import java.util.HashSet;

public class Country {
    private String name;
    private String nameContinent;
    private int countPeople;
    private String telCode;
    private String capital;
    private HashSet<String> arrCity;

    public Country(String name, String nameContinent, int countPeople, String telCode, String capital, HashSet<String> arrCity) {
        this.name = name;
        this.nameContinent = nameContinent;
        this.countPeople = countPeople;
        this.telCode = telCode;
        this.capital = capital;
        this.arrCity = arrCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameContinent() {
        return nameContinent;
    }

    public void setNameContinent(String nameContinent) {
        this.nameContinent = nameContinent;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public String getTelCode() {
        return telCode;
    }

    public void setTelCode(String telCode) {
        this.telCode = telCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArrCity() {
        return arrCity.toString();
    }

    public void setArrCity(HashSet<String> arrCity) {
        this.arrCity = arrCity;
    }

    public void addCity(String nameCity) {
        arrCity.add(nameCity);
    }

    @Override
    public String toString() {
        return "Название страны: " + name + "\n" +
                "Название континента: " + nameContinent + "\n" +
                "Количество жителей: " + countPeople + "\n" +
                "Телефонный код страны: " + telCode + "\n" +
                "Столица: " + capital + "\n" +
                "Города: " + arrCity;
    }
}
