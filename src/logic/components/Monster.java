package logic.component;

import exception.BadStatusException;

public class Monster {
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    public Monster (String name,Status status) throws BadStatusException  {
        this.status.setHp(Math.max(1,status.getHp()));
        this.name = name;
        this.food = null;
        this.potion = null;

    }
    public void attack(Player player) throws BadStatusException{
        if(this.status.getAttack()-player.getStatus().getDurability()>0)
        player.getStatus().setHp(Math.max(0,player.getStatus().getHp()-this.status.getAttack()+player.getStatus().getDurability()));
    }
    public void magicAttack(Player player)throws BadStatusException{
        player.getStatus().setHp(Math.max(0,player.getStatus().getHp()-this.status.getMagic()));
    }
    public String getName() throws BadStatusException{
        return name;
    }

    public void setName(String name) throws BadStatusException{
        this.name = name;
    }

    public Status getStatus() throws BadStatusException{
        return status;
    }

    public void setStatus(Status status) throws BadStatusException{
        this.status = status;
    }

    public Food getFood() throws BadStatusException{
        return food;
    }

    public void setFood(Food food) throws BadStatusException{
        this.food = food;
    }

    public Potion getPotion() throws BadStatusException{
        return potion;
    }

    public void setPotion(Potion potion) throws BadStatusException{
        this.potion = potion;
    }
}
