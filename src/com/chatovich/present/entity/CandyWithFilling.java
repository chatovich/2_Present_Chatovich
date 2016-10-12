package com.chatovich.present.entity;

import com.chatovich.present.type.FillingType;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class CandyWithFilling extends Candy {

    private FillingType type;

    public CandyWithFilling() {
        super();
    }

    public FillingType getType() {
        return type;
    }

    public void setType(FillingType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" "+type.toString().toLowerCase()+" - "+this.getWeight()+"g. (ccal = "+this.getKcal()+
                ", sugar = "+this.getSugar()+"%)";
    }
}
