package logic.component;

import java.util.ArrayList;
import java.util.Objects;

public class Ore {
    private String name;
    private int cost;

    public Ore(String name,int cost){
        this.name = name;
        this.cost = cost < 1 ? 1:cost;
    }
    public boolean equals(Object o){
        if(!(o instanceof Ore Other)){
            return false;
        }
        if(Objects.equals(this,o)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    public String getName(){
        return  this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
