package Task5;

public class Violin extends MusicDevice { //Скрипка

    private double weight; //Вес

    public Violin(String name, double weight) {
        super(name);
        this.weight = weight;
    }

    @Override
    public void Sound() {
        System.out.println("Скрипка издает звук");
    }

    @Override
    public void Show() {
        System.out.println("Название устройства: " + super.getName());
    }

    @Override
    public void Desc() {
        System.out.println("Материал верхней деки – массив ель, материал нижней деки и обечайки – массив клен, материал грифа – клен. Накладки на гриф, колки и подбородник – черные. Струнодержатель – металлический с 4-мя машинками. Подставка – клен. Покрытие скрипки – глянцевый лак.");
    }

    @Override
    public void History() {
        System.out.println("Создана в 2002 году");
    }

    @Override
    public String toString() {
        return "Имя устройства: " + super.getName() + "\n" +
                "Вес: " + this.weight + " кг.";
    }

}
