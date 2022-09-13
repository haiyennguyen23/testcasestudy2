package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bill implements Serializable {
    private String name;
    private double total;
    private ArrayList<Cosmetic> cosmetics;
    private LocalDate localDate;

    public Bill(String name, double total, ArrayList<Cosmetic> cosmetics, LocalDate localDate) {
        this.name = name;
        this.total = total;
        this.cosmetics = cosmetics;
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Cosmetic> getCosmetics() {
        return cosmetics;
    }

    public void setCosmetics(ArrayList<Cosmetic> cosmetics) {
        this.cosmetics = cosmetics;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    @Override
    public String toString() {
        return "Bill{" +
                "name='" + name + '\'' +
                ", total=" + total +
                ", cosmetics=" + cosmetics +
                ", localDate=" + localDate +
                '}';
    }
}
