package com.chatovich.present.factory;

import com.chatovich.present.entity.Biscuit;
import com.chatovich.present.entity.Confection;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class BiscuitFactory extends ConfentionFactory {

    @Override
    public Confection createConfention(String name, int weight, int kcal, int sugar) {
        Biscuit biscuit = new Biscuit();
        setFields(biscuit, weight, kcal, sugar);
        return biscuit;
    }
}
