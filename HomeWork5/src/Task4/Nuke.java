package Task4;

public class Nuke extends Device { //Микроволновка

    private String countryManufacturer; //Страна производитель

    public Nuke(String name, String countryManufacturer) {
        super(name);
        this.countryManufacturer = countryManufacturer;
    }

    @Override
    public void Sound() {
        System.out.println("Микроволновка издает звук");
    }

    @Override
    public void Show() {
        System.out.println("Название устройства: " + super.getName());
    }

    @Override
    public void Desc() {
        System.out.println("Микроволно́вая печь (микроволно́вка) или СВЧ-печь — электроприбор, позволяющий совершать разогрев водосодержащих веществ благодаря электромагнитному излучению дециметрового диапазона (обычно с частотой 2450 МГц) и предназначенный для быстрого приготовления, подогрева или размораживания пищи.");
    }

    @Override
    public String toString() {
        return "Имя устройства: " + super.getName() + "\n" +
                "Страна-производитель: " + this.countryManufacturer;
    }
}
