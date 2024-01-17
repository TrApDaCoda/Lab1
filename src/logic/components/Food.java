package logic.components;

import java.util.Objects;

public class Food {
    private String name;
    private int price;
    private int energy;

    public Food(String name,int price,int energy){
        this.name = name;
        this.price = price < 1 ? 1:price;
        this.energy = energy < 1 ? 1:energy;
    }

    public boolean equals(Object o){
        //Food other = (Food) o;
        if(!(o instanceof Food other)){
            return false;
        }
        return true;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getEnergy(){
        return energy;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = Math.max(1,price);
    }

    public void setEnergy(int energy){
        this.energy = Math.max(1,energy);
    }
}
