package com.chatovich.present.factory;

import com.chatovich.present.creator.PresentParser;
import com.chatovich.present.entity.Chocolate;
import com.chatovich.present.type.ChocolateType;
import com.chatovich.present.exception.WrongDataException;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class ChocolateFactory extends ConfentionFactory{

    @Override
    public Chocolate createConfention(String name, int weight, int kcal, int sugar) throws WrongDataException {
        Chocolate chocolate = new Chocolate();
        PresentParser presentParser = new PresentParser();
        setFields(chocolate, weight, kcal, sugar);
        String type = presentParser.parseConfentionType(name);
        switch (type){
            case "milk": chocolate.setType(ChocolateType.MILK);break;
            case "dark": chocolate.setType(ChocolateType.DARK);break;
            case "white": chocolate.setType(ChocolateType.WHITE);break;
                default: throw new WrongDataException("There is no "+type+" chocolate in the shop.");
        }
        return chocolate;
    }
}
