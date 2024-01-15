package logic.component;

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
    public void addStatus(Status another)  throws BadStatusException {
        this.hp += another.hp;
        this.durability += another.durability;
        this.attack += another.attack;
        this.magic += another.magic;
    }
    public int getHp()  throws BadStatusException{
        return hp;
    }

    public int getAttack() throws BadStatusException {
        return attack;
    }

    public int getDurability() throws BadStatusException {
        return durability;
    }

    public int getMagic()  throws BadStatusException{
        return magic;
    }

    public void setAttack(int attack)  throws BadStatusException{
        this.attack = attack;
    }

    public void setDurability(int durability) throws BadStatusException {
        this.durability = durability;
    }

    public void setHp(int hp)  throws BadStatusException{
        this.hp = hp;
    }

    public void setMagic(int magic)  throws BadStatusException{
        this.magic = magic;
    }
}
