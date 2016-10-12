package com.chatovich.present.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yultos_ on 08.10.2016.
 */
public class Present {

    private List<Confection> presentList = new ArrayList<>();

    public Present() {
    }

    public Present(List<Confection> presentList) {
        this.presentList = presentList;
    }

    public List<Confection> getPresentList() {
        return presentList;
    }

    public void setPresentList(List<Confection> presentList) {
        this.presentList = presentList;
    }

    public void addConfention (Confection confection){
        presentList.add(confection);
    }


}
