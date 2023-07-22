package Task3;

import java.util.Currency;

public class Money {
    private int wholePatMoney; //Целая часть
    private int fractionalPatMoney; //Дробная часть (от 0 до 99)
    private double currency; //Итоговая сумма

    public Money(int wholePatMoney, int fractionalPatMoney) throws Exception {
        if (wholePatMoney < 0) {
            throw new Exception("Целая часть не может был меньше нуля");
        }
        if (fractionalPatMoney < 1 || fractionalPatMoney > 99) {
            throw new Exception("Дробная часть должна быть от 1 до 99 включительно");
        }
        this.wholePatMoney = wholePatMoney;
        this.fractionalPatMoney = fractionalPatMoney;
        this.currency = (wholePatMoney + (fractionalPatMoney / 100.0));
    }

    /*Целая часть*/
    public int getWholePatMoney() {
        return wholePatMoney;
    }

    public void setWholePatMoney(int wholePatMoney) throws Exception {
        if (wholePatMoney < 0) {
            throw new Exception("Целая часть не может был меньше нуля");
        }
        this.wholePatMoney = wholePatMoney;
        this.currency = (wholePatMoney + (this.fractionalPatMoney / 100.0));

    }

    /*Дробная часть */
    public int getFractionalPatMoney() {
        return fractionalPatMoney;
    }

    public void setFractionalPatMoney(int fractionalPatMoney) throws Exception {
        if (fractionalPatMoney < 0 || fractionalPatMoney > 99) {
            throw new Exception("Дробная часть должна быть от 0 до 99 включительно");
        }
        this.fractionalPatMoney = fractionalPatMoney;
        this.currency = (this.wholePatMoney + (fractionalPatMoney / 100.0));
    }

    /*Итоговая сумма*/
    public double getCurrency() {
        return currency;
    }

    public void reduce(int wholePatMoney, int fractionalPatMoney) { //Уменьшение
        try {
            double currencyNew = this.currency - (wholePatMoney + (fractionalPatMoney / 100.0));
            int integralPart = (int) currencyNew;
            int fractionalPart = (int) (currencyNew * 100) - (integralPart * 100);
            this.setWholePatMoney(integralPart);
            this.setFractionalPatMoney(fractionalPart);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
