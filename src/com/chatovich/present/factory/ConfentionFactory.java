package com.chatovich.present.factory;

import com.chatovich.present.entity.Confection;
import com.chatovich.present.exception.WrongDataException;

import java.util.List;

/**
 * Created by Yultos_ on 08.10.2016
 */
public abstract class ConfentionFactory {

    public abstract Confection createConfention(String name, int weight, int kcal, int sugar) throws WrongDataException;

    public void setFields (Confection confention, int weight, int kcal, int sugar){
        confention.setWeight(weight);
        confention.setKcal(kcal);
        confention.setSugar(sugar);
    }
}
