package Task5;

public class Trombone extends MusicDevice { //Тромбон
    private String brand;

    public Trombone(String name, String brand) {
        super(name);
        this.brand = brand;
    }

    @Override
    public void Sound() {
        System.out.println("Тромбон издает звук");
    }

    @Override
    public void Show() {
        System.out.println("Название устройства: " + super.getName());
    }

    @Override
    public void Desc() {
        System.out.println("Высококачественные материалы - Тромбон LADE изготовлен из высококачественной латуни и обладает прекрасной интонацией. Точное интонирование пронизывает звук, что делает его идеальным тромбоном для детей, студентов и начинающих.");
    }

    @Override
    public void History() {
        System.out.println("Создан в 2000 году");

    }

    @Override
    public String toString() {
        return "Имя устройства: " + super.getName() + "\n" +
                "Бренд: " + this.brand;
    }
}
