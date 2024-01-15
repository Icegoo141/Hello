package logic.components;

public class Potion {
    private String name;
    private int price;
    private Status increasingStatus;

    public Potion(String name, int price, Status increasingStatus) {
        setName(name);
        setPrice(price);
        setIncreasingStatus(increasingStatus);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Potion obj = (Potion) o;
        return ((name.equals(obj.name)) && (price == obj.price) && (increasingStatus == obj.increasingStatus));
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

    public Status getIncreasingStatus() {
        return increasingStatus;
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }
}
