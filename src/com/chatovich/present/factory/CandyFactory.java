package com.chatovich.present.factory;

import com.chatovich.present.entity.Candy;
import com.chatovich.present.exception.WrongDataException;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class CandyFactory extends ConfentionFactory {

    @Override
    public Candy createConfention(String name, int weight, int kcal, int sugar) throws WrongDataException{
        Candy candy = new Candy();
        setFields(candy, weight, kcal, sugar);
        return candy;
    }
}
