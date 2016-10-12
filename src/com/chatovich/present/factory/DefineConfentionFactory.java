package com.chatovich.present.factory;

import com.chatovich.present.exception.WrongDataException;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class DefineConfentionFactory {

    public static ConfentionFactory defineFactory (String line) throws WrongDataException {
        switch (line){
            case "chocolate" : return new ChocolateFactory();
            case "biscuit": return new BiscuitFactory();
            case "candy": return new CandyFactory();
            case "candy with filling": return new CandyWithFillingFactory();
            default: throw new WrongDataException("There is no such confention in the shop.");
        }
    }
}
