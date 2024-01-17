package logic.components;

import exception.BadStatusException;

public class Monster {
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    public Monster (String name,Status status) {
        try {
            this.status = new Status(Math.max(1, status.getHp()), status.getDurability(), status.getAttack(), status.getMagic());
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }
        this.name = name;
        this.food = null;
        this.potion = null;

    }
    public void attack(Player player) {
        if(this.status.getAttack()-player.getStatus().getDurability()>0) {
            try {
                player.getStatus().setHp(Math.max(0,player.getStatus().getHp()-this.status.getAttack()+player.getStatus().getDurability()));
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void magicAttack(Player player){
        try {
            player.getStatus().setHp(Math.max(0,player.getStatus().getHp()-this.status.getMagic()));
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
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

    public void setPotion(Potion potion){
        this.potion = potion;
    }
}
