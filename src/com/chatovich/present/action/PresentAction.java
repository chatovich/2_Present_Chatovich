package com.chatovich.present.action;

import com.chatovich.present.entity.Confection;
import com.chatovich.present.entity.Present;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yultos_ on 09.10.2016
 */
public class PresentAction {

    final static int MIN_PRESENT_SIZE = 3;

    public boolean isPresentBigEnough (List<Confection> present){
        return present.size()>MIN_PRESENT_SIZE;
    }

    public int calcPresentWeight (Present present){
        int weight = 0;
        for (Confection confection : present.getPresentList()) {
            weight+=confection.getWeight();
        }
        return weight;
    }

    public List <Confection> chooseInSugarRange (List<Confection> list, int up, int down){

        List<Confection> listInSugarRange = new ArrayList<>();
        for (Confection confection : list) {
            if (down<confection.getSugar()&&confection.getSugar()<up){
                listInSugarRange.add(confection);
            }
        }
        return listInSugarRange;
    }
}
