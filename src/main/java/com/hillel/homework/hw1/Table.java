package com.hillel.homework.hw1;

public class Table {
    private int number;
    private boolean isReserved;

    public Table(int number) {
        this.isReserved = isReserved;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        this.isReserved = true;
    }

    @Override
    public String toString() {
        return "Table" + number + " - " + (isReserved ? "Reserved" : "Available");

    }

    public void cancelReservation() {
        this.isReserved = false;
    }
}
