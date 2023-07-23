package Task4;

public class Parahod extends Device { //Параход

    private double displacement;

    public Parahod(String name, double displacement) {
        super(name);
        this.displacement = displacement;
    }

    @Override
    public void Sound() {
        System.out.println("Параход издает звук");

    }

    @Override
    public void Show() {
        System.out.println("Название устройства: " + super.getName());
    }

    @Override
    public void Desc() {
        System.out.println("Парохо́д — судно, оснащённое поршневой паровой машиной или паровой турбиной в качестве тягового двигателя.");
    }

    @Override
    public String toString() {
        return "Имя устройства: " + super.getName() + "\n" +
                "Водоизмещение: " + this.displacement + " тонн.";
    }
}
