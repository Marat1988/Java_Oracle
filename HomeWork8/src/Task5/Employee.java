package Task5;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private int personalCode; //id (персональный код) сотрудника
    private String firstName;
    private String lastName;
    private int age;

    public Employee(int personalCode, String firstName, String lastName, int age) {
        this.personalCode = personalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getPersonalCode() {
        return personalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this==o) return  true;
        if (o==null || getClass()!=o.getClass()) return false;
        Employee employee = (Employee) o;
        return personalCode == employee.personalCode;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personalCode);
    }


    @Override
    public String toString() {
        return "{\"personalCode\": " + personalCode + "," +
                "\"firstName\": \"" + firstName + "\"," +
                "\"lastName\": \"" + lastName + "\"," +
                "\"age\": " + age +
                "}";
    }
}
