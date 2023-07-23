package Task1;

public class Human {
    private int age;
    private String fullName;

    public Human(int age, String fullName) {
        this.age = age;
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "ФИО: " + fullName + "\n" +
                "Возраст: " + age;

    }
}
