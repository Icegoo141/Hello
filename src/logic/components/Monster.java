package logic.components;

import exception.BadStatusException;

public class Monster {
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    public Monster(String name, Status status) {
        this.name = name;
        this.status = status;
        if (this.status.getHp() < 1) {
            try {
                this.status.setHp(1);
            } catch (BadStatusException ignored) {
            }
        }
        food = null;
        potion = null;
    }

    public void attack(Player player) {
        int newHp = player.getStatus().getHp();
        newHp -= Math.max((status.getAttack() - player.getStatus().getDurability()), 0);
        try {
            player.getStatus().setHp(Math.max(newHp, 0));
        } catch (BadStatusException ignored) {
        }
    }

    public void magicAttack(Player player) {
        try {
            player.getStatus().setHp(Math.max((player.getStatus().getHp() - status.getMagic()), 0));
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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}
