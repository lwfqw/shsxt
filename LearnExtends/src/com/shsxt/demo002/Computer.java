package com.shsxt.demo002;

import java.util.Objects;

/*
重量
价格
品牌
 */
public class Computer {
    private double weight;
    private double price;
    private String brand;

    public Computer(double weight, double price, String brand) {
        this.weight = weight;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Double.compare(computer.weight, weight) == 0 &&
                Double.compare(computer.price, price) == 0 &&
                Objects.equals(brand, computer.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, price, brand);
    }
}
