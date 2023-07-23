package Task4;

public class Teapot extends Device { //Чайник
    private String color;

    public Teapot(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public void Sound() {
        System.out.println("Чайник издает звук");
    }

    @Override
    public void Show() {
        System.out.println("Название устройства: " + super.getName());
    }

    @Override
    public void Desc() {
        System.out.println("Электрический чайник il Monte EK-1702 в деревенском ретро стиле \"Rustico\" станет незаменимым помощником на Вашей кухне! Корпус цельнометаллический.");
    }

    @Override
    public String toString() {
        return "Имя устройства: " + super.getName() + "\n" +
                "Цвет: " + this.color;
    }
}
