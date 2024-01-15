package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    private String name;
    private Status status;
    private int energy;
    private int money;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private ArrayList<Ore> ores;

    public Player(String name, Status status) {
        this.name = name;
        this.status = status;
        if (this.status.getHp() < 1) {
            try {
                this.status.setHp(1);
            } catch (BadStatusException ignored) {
            }
        }
        energy = 10;
        money = 100;
        foods = new ArrayList<>();
        potions = new ArrayList<>();
        ores = new ArrayList<>();
    }

    public Player(String name, Status status, int energy, int money) {
        this.name = name;
        this.status = status;
        if (this.status.getHp() < 1) {
            try {
                this.status.setHp(1);
            } catch (BadStatusException ignored) {
            }
        }
        this.energy = Math.max(energy, 0);
        this.money = Math.max(money, 0);
        foods = new ArrayList<>();
        potions = new ArrayList<>();
        ores = new ArrayList<>();
    }

    public boolean buyOre(Ore ore) {
        if (money > ore.getCost()) {
            money -= ore.getCost();
            ores.add(ore);
            return true;
        }
        return false;
    }

    public void drinkPotion(int index) {
        try {
            status.addStatus(potions.get(index).getIncreasingStatus());
            potions.remove(index);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void eatFood(int index) {
        try {
            energy += foods.get(index).getEnergy();
            foods.remove(index);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void sellPotion(int index) {
        try {
            money += potions.get(index).getPrice();
            potions.remove(index);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void sellFood(int index) {
        try {
            money += foods.get(index).getPrice();
            foods.remove(index);
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    public void attack(Monster monster) {
        int newHp = monster.getStatus().getHp();
        newHp -= Math.max((status.getAttack() - monster.getStatus().getDurability()), 0);
        try {
            monster.getStatus().setHp(Math.max(newHp, 0));
        } catch (BadStatusException ignored) {
        }
    }

    public void magicAttack(Monster monster) {
        try {
            monster.getStatus().setHp(Math.max((monster.getStatus().getHp() - status.getMagic()), 0));
        } catch (BadStatusException ignored) {
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(energy, 0);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = Math.max(money, 0);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }
}
