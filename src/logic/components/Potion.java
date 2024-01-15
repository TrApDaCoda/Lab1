package logic.component;

import java.util.Objects;

public class Potion {
    private String name;
    private int price;
    private Status increasingStatus;

    public boolean equals(Object o){
        if(!(o instanceof Potion other)){
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
        return Objects.hash(name, price, increasingStatus);
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Status getIncreasingStatus() {
        return increasingStatus;
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }
}
