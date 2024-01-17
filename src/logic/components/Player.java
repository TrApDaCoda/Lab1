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

    public Player(String name,Status status)  {
        //this.status.setHp(Math.max(1, status.getHp()));
        try {
            this.name = name;
            this.status = new Status(Math.max(1, status.getHp()), status.getDurability(), status.getAttack(), status.getMagic());
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }
        this.energy = 10;
        this.money = 100;
        this.foods = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.ores = new ArrayList<>();
    }
    public Player(String name,Status status,int energy,int money){
        try {
            this.name = name;
            this.status = new Status(Math.max(1, status.getHp()), status.getDurability(), status.getAttack(), status.getMagic());
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }
        this.energy = Math.max(0,energy);
        this.money = Math.max(0,money);
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
    public void drinkPotion(int index){
        if(this.potions.size() > index && index >=0){
            try {
                this.status.setHp(this.status.getHp()+potions.get(index).getIncreasingStatus().getHp());
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
            try {
                this.status.setDurability(this.status.getDurability()+potions.get(index).getIncreasingStatus().getDurability());
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
            try {
                this.status.setAttack(this.status.getAttack()+potions.get(index).getIncreasingStatus().getAttack());
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
            try {
                this.status.setMagic(this.status.getMagic()+potions.get(index).getIncreasingStatus().getMagic());
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
            this.potions.remove(index);
        }
    }
    public void eatFood(int index){
        if (this.foods.size() > index && index >=0){
            this.energy += foods.get(index).getEnergy();
            this.foods.remove(index);
        }
    }
    public void sellPotion (int index){
        if(this.potions.size() > index && index >=0){
            this.money += potions.get(index).getPrice();
            this.potions.remove(index);
        }
    }
    public void sellFood (int index){
        if(this.foods.size() > index&& index >=0){
            this.money += foods.get(index).getPrice();
            this.foods.remove(index);
        }
    }
    public void attack(Monster monster){
        if(this.getStatus().getAttack()-monster.getStatus().getDurability()>0){
            try {
                monster.getStatus().setHp(Math.max(0,monster.getStatus().getHp()-(this.getStatus().getAttack()-monster.getStatus().getDurability())));
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void magicAttack(Monster monster){
        try {
            monster.getStatus().setHp(Math.max(0,monster.getStatus().getHp()-this.getStatus().getMagic()));
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0,energy);
        //this.energy = energy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = Math.max(0,money);
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Food> getFoods(){
        return foods;
    }

    public void setPotions(ArrayList<Potion> potions){
        this.potions = potions;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public void setOres(ArrayList<Ore> ores){
        this.ores = ores;
    }

}
