package logic.components;

public class Ore {
    private String name;
    private int cost;

    public Ore(String name, int cost) {
        this.name = name;
        this.cost = Math.max(cost, 1);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ore obj = (Ore) o;
        return ((name.equals(obj.name)) && (cost == obj.cost));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = Math.max(cost, 1);
    }
}
