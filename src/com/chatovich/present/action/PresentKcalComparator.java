package com.chatovich.present.action;

import com.chatovich.present.entity.Confection;

import java.util.Comparator;

/**
 * Created by Yultos_ on 09.10.2016
 */
public class PresentKcalComparator implements Comparator<Confection> {

    @Override
    public int compare(Confection a, Confection b) {
        
        return a.getKcal() - b.getKcal();
    }
}
