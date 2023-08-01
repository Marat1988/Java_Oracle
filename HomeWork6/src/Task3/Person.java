package Task3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Person {
    private int personalCode; //Персональный код
    private String fullName; //Полное ФИО
    private String city; //Город
    private List<Fine> fines; //Штрафы

    public Person(int personalCode, String fullName, String city) {
        this.personalCode = personalCode;
        this.fullName = fullName;
        this.city = city;
        fines = new ArrayList<>();
    }

    public void addFine(Fine fine) {
        fines.add(fine);
    }

    public void removeFine(Fine fine) {
        fines.remove(fine);
    }

    public void removeFine(int index) {
        fines.remove(index);
    }

    public List<Fine> getFines(){
        return fines;
    }

    public int getPersonalCode() {
        return personalCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personalCode == person.personalCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalCode);
    }

    public String toString() {
        return "{\"personalCode\": " + personalCode + "," +
                "\"fullName\": \"" + fullName + "\"," +
                "\"city\": \"" + city + "\"," +
                "\"fines\": " + fines +
                "}";
    }

}
