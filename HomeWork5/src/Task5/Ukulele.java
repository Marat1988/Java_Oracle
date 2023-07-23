package Task5;

public class Ukulele extends MusicDevice { //Укулеле

    private String color;

    public Ukulele(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public void Sound() {
        System.out.println("Укулеле издает звук");
    }

    @Override
    public void Show() {
        System.out.println("Название устройства: " + super.getName());
    }

    @Override
    public void Desc() {
        System.out.println("TUTTI  JR-20 SCH MUSIC - Укулеле концерт");
    }

    @Override
    public void History() {
        System.out.println("Создана в 2001 году.");
    }

    @Override
    public String toString() {
        return "Имя устройства: " + super.getName() + "\n" +
                "Цвет: " + this.color;
    }
}
