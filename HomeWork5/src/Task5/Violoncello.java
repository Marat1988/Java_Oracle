package Task5;

public class Violoncello extends MusicDevice {  //Виолончель
    public double price;

    public Violoncello(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public void Sound() {
        System.out.println("Виолончель издает звук");
    }

    @Override
    public void Show() {
        System.out.println("Название устройства: " + super.getName());
    }

    @Override
    public void Desc() {
        System.out.println("Виолончели для начинающих музыкантов серии Beginer Genial 2 изготавливаются вручную. Верхняя дека выполнена из Карпатской ели, задняя дека и обечайка из слегка волнистого клена, принадлежности из черного дерева. Инструмент покрыт нитролаком. Замечательное качество по доступной цене!");
    }

    @Override
    public void History() {
        System.out.println("Создана в 2003 году");
    }

    @Override
    public String toString() {
        return "Имя устройства: " + super.getName() + "\n" +
                "Цена: " + this.price + " руб.";
    }

}
