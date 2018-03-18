package entity;

import java.io.Serializable;

public class Car implements Serializable{

    private int year;
    private int engineCapacity;
    private double pricePurchasing;
    private double priceSelling;


    public Car() {
    }

    public Car(int year, int engineCapacity, double pricePurchasing) {
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.pricePurchasing = pricePurchasing;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double getPricePurchasing() {
        return pricePurchasing;
    }

    public void setPricePurchasing(double pricePurchasing) {
        this.pricePurchasing = pricePurchasing;
    }

    public double getPriceSelling() {
        return priceSelling;
    }

    public void setPriceSelling(double priceSelling) {
        this.priceSelling = priceSelling;
    }
}
