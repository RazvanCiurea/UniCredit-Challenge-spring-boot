package com.ciurea.andrei.entity;

/**
 * Created by Andrei on 5/27/2017.
 */
public class Ticket {
    private int id;
    private double price;
    private String owner;
    private String event;

    public Ticket(int id, double price, String owner, String event) {
        this.id = id;
        this.price = price;
        this.owner = owner;
        this.event = event;
    }

    public Ticket() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
