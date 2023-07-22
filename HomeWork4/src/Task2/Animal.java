package Task2;

public class Animal {
    private String name; //Имя животного
    private String familyAnimal; //Семейство

    public Animal(String name, String familyAnimal) {
        this.name = name;
        this.familyAnimal = familyAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyAnimal() {
        return familyAnimal;
    }

    public void setFamilyAnimal(String familyAnimal) {
        this.familyAnimal = familyAnimal;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n" +
                "Семейство: " + familyAnimal;
    }
}
