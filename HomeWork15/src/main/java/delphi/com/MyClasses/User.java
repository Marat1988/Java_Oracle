package delphi.com.MyClasses;

public class User {
    private String surname;
    private String name;
    private String middleName;
    private String telNumber;
    private String email;
    private int age;
    private boolean mailing;

    public User(String surname, String name, String middleName, String telNumber, String email, int age, boolean mailing) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.telNumber = telNumber;
        this.email = email;
        this.age = age;
        this.mailing = mailing;
    }

    @Override
    public String toString() {
        return "Профиль сотрудника:\n" +
                "Фамилия: " + surname + "\n" +
                "Имя: " + name + "\n" +
                "Отчество: " + middleName + "\n" +
                "Номер телефона: " + telNumber + "\n" +
                "Электронная почта: " + email + "\n" +
                "Возраст: " + age + "\n" +
                "Подписан на рассылки: " + mailing;
    }
}
