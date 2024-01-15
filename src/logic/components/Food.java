package logic.components;

public class Food {
    private String name;
    private int price;
    private int energy;

    public Food(String name, int price, int energy) {
        this.name = name;
        this.price = Math.max(price, 1);
        this.energy = Math.max(energy, 1);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food obj = (Food) o;
        return (this.name.equals(obj.name)) && (this.price == obj.price) && (this.energy == obj.energy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = Math.max(price, 1);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(energy, 1);
    }
}
