package logic.component;

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

    public Player(String name,Status status) throws BadStatusException {
        this.status.setHp(Math.max(1, status.getHp()));
        this.energy = 10;
        this.money = 100;
        this.foods = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.ores = new ArrayList<>();
    }
    public Player(String name,Status status,int energy,int money)throws BadStatusException{
        this.status.setHp(Math.max(1, status.getHp()));
        this.energy = energy;
        this.money = money;
        this.foods = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.ores = new ArrayList<>();
    }
    public boolean buyOre(Ore ore){
        if(this.money >= ore.getCost()){
            this.money -= ore.getCost();
            ores.add(ore);
            return true;
        }else{
            return false;
        }
    }
    public void drinkPotion(int index)throws BadStatusException{
        if(this.potions.size() >= index){
        this.status.setHp(this.status.getHp()+potions.get(index).getIncreasingStatus().getHp());
        this.status.setDurability(this.status.getDurability()+potions.get(index).getIncreasingStatus().getDurability());
        this.status.setAttack(this.status.getAttack()+potions.get(index).getIncreasingStatus().getAttack());
        this.status.setMagic(this.status.getMagic()+potions.get(index).getIncreasingStatus().getMagic());
        this.potions.remove(index);
        }
    }
    public void eatFood(int index){
        if (this.foods.size() >= index){
            this.energy += foods.get(index).getEnergy();
            this.foods.remove(index);
        }
    }
    public void sellPotion (int index){
        if(this.potions.size() >= index){
            this.money += potions.get(index).getPrice();
            this.potions.remove(index);
        }
    }
    public void sellFood (int index){
        if(this.foods.size() >= index){
            this.money += foods.get(index).getPrice();
            this.foods.remove(index);
        }
    }
    public void attack(Monster monster)throws BadStatusException{
        if(monster.getStatus().getAttack()-this.getStatus().getDurability()>0){
            monster.getStatus().setHp(Math.max(0,monster.getStatus().getHp()-(monster.getStatus().getAttack()-this.getStatus().getDurability())));

        }
    }
    public void magicAttack(Monster monster)throws BadStatusException{
        monster.getStatus().setHp(Math.max(0,monster.getStatus().getHp()-this.getStatus().getMagic()));
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

    public int getEnergy() throws BadStatusException{
        return energy;
    }

    public void setEnergy(int energy) throws BadStatusException{
        this.energy = energy;
    }

    public int getMoney() throws BadStatusException{
        return money;
    }

    public void setMoney(int money) throws BadStatusException{
        this.money = money;
    }

    public void setFoods(ArrayList<Food> foods) throws BadStatusException{
        this.foods = foods;
    }

    public ArrayList<Food> getFoods() throws BadStatusException{
        return foods;
    }

    public void setPotions(ArrayList<Potion> potions) throws BadStatusException{
        this.potions = potions;
    }

    public ArrayList<Potion> getPotions() throws BadStatusException{
        return potions;
    }

    public ArrayList<Ore> getOres() throws BadStatusException{
        return ores;
    }

    public void setOres(ArrayList<Ore> ores) throws BadStatusException{
        this.ores = ores;
    }

}
