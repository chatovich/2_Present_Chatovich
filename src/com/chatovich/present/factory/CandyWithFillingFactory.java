package com.chatovich.present.factory;

import com.chatovich.present.creator.PresentParser;
import com.chatovich.present.entity.CandyWithFilling;
import com.chatovich.present.type.FillingType;
import com.chatovich.present.exception.WrongDataException;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class CandyWithFillingFactory extends CandyFactory {

    public CandyWithFilling createConfention(String name, int weight, int kcal, int sugar) throws WrongDataException {
        CandyWithFilling candy = new CandyWithFilling();
        PresentParser presentParser = new PresentParser();
        setFields(candy, weight, kcal, sugar);
        String type = presentParser.parseConfentionType(name);
        switch (type){
            case "cream": candy.setType(FillingType.CREAM);break;
            case "coconut": candy.setType(FillingType.COCONUT);break;
            case "chocolate": candy.setType(FillingType.CHOCOLATE);break;
            case "nuts": candy.setType(FillingType.NUTS);break;
            default: throw new WrongDataException("There is no "+type+" filling in the shop,");
        }
        return candy;
    }
}
