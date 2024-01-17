package logic.components;

import exception.BadStatusException;

import java.util.Objects;

public class Status {
    private int hp;
    private int durability;
    private int attack;
    private int magic;

    public boolean equals(Object o){
        if(!(o instanceof Status other)){
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
        return Objects.hash(hp, durability, attack, magic);
    }

    public Status(int hp, int durability, int attack, int magic)  throws BadStatusException {
        setHp(hp);
        setDurability(durability);
        setAttack(attack);
        setMagic(magic);
    }
    public void addStatus(Status another)  {
        this.hp += another.hp;
        this.durability += another.durability;
        this.attack += another.attack;
        this.magic += another.magic;
    }
    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDurability() {
        return durability;
    }

    public int getMagic()  {
        return magic;
    }

    public void setAttack(int attack) throws BadStatusException{
        //this.attack = attack;
        if(attack < 0){
            this.attack = 0;
            throw new BadStatusException();
        }else{
            this.attack = attack;
        }
    }

    public void setDurability(int durability) throws BadStatusException{
        if(durability < 0){
            this.durability = 0;
            throw new BadStatusException();
        }else{
            this.durability = durability;
        }
    }

    public void setHp(int hp) throws BadStatusException {
        if(hp < 0){
            this.hp = 0;
            throw new BadStatusException();
        }else{
            this.hp = hp;
        }
    }

    public void setMagic(int magic)  throws BadStatusException{
        if(magic < 0){
            this.magic = 0;
            throw new BadStatusException();
        }else{
            this.magic = magic;
        }
    }
}
