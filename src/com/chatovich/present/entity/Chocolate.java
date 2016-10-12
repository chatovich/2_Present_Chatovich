package com.chatovich.present.entity;

import com.chatovich.present.type.ChocolateType;

public class Chocolate extends Confection {

    private ChocolateType type;

    public Chocolate() {
        super();
    }

    public ChocolateType getType() {
        return type;
    }

    public void setType(ChocolateType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" "+type.toString().toLowerCase()+" - "+this.getWeight()+"g. (ccal = "+this.getKcal()+
                ", sugar = "+this.getSugar()+"%)";
    }
}
