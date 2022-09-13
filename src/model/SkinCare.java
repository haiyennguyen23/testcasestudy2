package model;

import java.io.Serializable;

public class SkinCare extends Cosmetic implements Serializable {
    public SkinCare(int id, String name, double price) {
    }

    public SkinCare(int id, String name, String price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "SkinCare{}"+
        "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
