package com.chatovich.present.entity;

/**
 * abstract class, top of the hierarchy
 */
public abstract class Confection {

    private int weight;
    private int kcal;
    private int sugar;

    public Confection() {
    }

    public Confection(int weight, int kcal, int sugar) {
        this.weight = weight;
        this.kcal = kcal;
        this.sugar = sugar;
    }

    public int getWeight() {
        return weight;
    }

    public int getKcal() {
        return kcal;
    }

    public int getSugar() {
        return sugar;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" - "+weight+"g. (kcal = "+ kcal +", sugar = "+ sugar +"%)";
    }
}
