package org.example;

public class Smartphone extends Product {
    private String producer;

    public Smartphone(int ID, String name, int price, String producer) {
        super(ID, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
