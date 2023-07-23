package Task3;

public class Product {
    private String name;
    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public void reducePrice(int wholePatMoney, int fractionalPatMoney) {
        System.out.println("Уменьшаем цену товара. Целая часть: " + wholePatMoney + ". Дробная часть: " + fractionalPatMoney);
        try {
            price.reduce(wholePatMoney, fractionalPatMoney);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Наименование товара: " + name + "\n" +
                "Цена товара: " + price.getCurrency() + "\n";
    }


}
