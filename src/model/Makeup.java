package model;

import java.io.Serializable;

public class Makeup extends Cosmetic implements Serializable {
    public Makeup(int id, String name, double price) {
    }

    public Makeup(int id, String name, String price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "Makeup{}"+
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
