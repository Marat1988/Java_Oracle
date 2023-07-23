package Task4;

public class Car extends Device { //Автомобиль
    private String brand; //Брэнд

    public Car(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public void Sound() {
        System.out.println("Автомобиль издает звук");
    }

    @Override
    public void Show() {
        System.out.println("Название устройства: " + super.getName());
    }

    @Override
    public void Desc() {
        System.out.println("Автомобиль (от древнегреческого «сам» и латинского «подвижной, скорый») — моторное дорожное транспортное средство, используемое для перевозки людей или грузов. Современный тип автомобиля, передвигающегося при помощи двигателя внутреннего сгорания, сконструировал Карл Фридрих Бенц в 1886 г.");
    }

    @Override
    public String toString() {
        return "Имя устройства: " + super.getName() + "\n" +
                "Брэнд: " + this.brand;
    }
}
