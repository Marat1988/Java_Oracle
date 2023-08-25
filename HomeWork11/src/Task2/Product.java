package Task2;

public class Product {
    private String name;
    private CATEGORY_PRODUCT categoryProduct;
    private double price;

    public Product(String name, CATEGORY_PRODUCT categoryProduct, double price) {
        this.name = name;
        this.categoryProduct = categoryProduct;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CATEGORY_PRODUCT getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CATEGORY_PRODUCT categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{\"name: \"" + name +
                "\"category: \"" + categoryProduct +
                "\"price: \"" + price + "}";
    }
}
