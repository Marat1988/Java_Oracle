package Task2;

public class City {
    private String nameCity;
    private String nameRegion;
    private String nameCountry;
    private int countPeople;
    private int postalCode;
    private int telCodeCity;

    public City(String nameCity, String nameRegion, String nameCountry, int countPeople, int postalCode, int telCodeCity) {
        this.nameCity = nameCity;
        this.nameRegion = nameRegion;
        this.nameCountry = nameCountry;
        this.countPeople = countPeople;
        this.postalCode = postalCode;
        this.telCodeCity = telCodeCity;
    }
    public City(String nameCity, String nameRegion, String nameCountry, int countPeople) {
        this.nameCity = nameCity;
        this.nameRegion = nameRegion;
        this.nameCountry = nameCountry;
        this.countPeople = countPeople;
    }
    public String getNameCity() {
        return nameCity;
    }
    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
    public String getNameRegion() {
        return nameRegion;
    }
    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }
    public String getNameCountry() {
        return nameCountry;
    }
    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
    public int getCountPeople() {
        return countPeople;
    }
    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public int getTelCodeCity() {
        return telCodeCity;
    }
    public void setTelCodeCity(int telCodeCity) {
        this.telCodeCity = telCodeCity;
    }
    public void setMayor(String fullname){
        System.out.println("Новый мэр города: " + fullname);
    }
    public void setMayor(String fullname, int term){
        setMayor(fullname);
        System.out.println("Избран на срок: " + term + " лет");
    }
    @Override
    public String toString() {
        return "Город: " + nameCity + "\n" +
                "Регион: " + nameRegion + "\n" +
                "Страна: " + nameCountry + "\n" +
                "Количество жителей: " + countPeople + "\n" +
                "Почтовый индекс города: " + postalCode + "\n" +
                "Телефонный код города: " + telCodeCity;
    }
}
