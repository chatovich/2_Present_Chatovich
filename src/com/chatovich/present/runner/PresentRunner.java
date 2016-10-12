package com.chatovich.present.runner;

import com.chatovich.present.action.PresentAction;
import com.chatovich.present.action.PresentKcalComparator;
import com.chatovich.present.action.ReadFile;
import com.chatovich.present.creator.PresentCreator;
import com.chatovich.present.entity.Confection;
import com.chatovich.present.entity.Present;
import com.chatovich.present.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class PresentRunner {

    static final String FILE_NAME = System.getProperty("user.dir")+"/file/present.txt";
    static final Logger LOGGER = LogManager.getLogger(PresentRunner.class);
    static final int SUGAR_UP = 40;
    static final int SUGAR_DOWN = 20;

    public static void main(String[] args) {

        List<String> presentStringList = ReadFile.readFromTXTFile(FILE_NAME);
        PresentCreator presentCreator = new PresentCreator();
        PresentAction presentAction = new PresentAction();
        Present present;
        try {
            present = presentCreator.createPresent(presentStringList);
            int weight = presentAction.calcPresentWeight(present);
            LOGGER.log(Level.INFO, "Christmas present was created, its weight is "+weight+", present sorted byKcal: ");
            Collections.sort(present.getPresentList(), new PresentKcalComparator());
            present.getPresentList().forEach(a -> LOGGER.log(Level.INFO, a));
            List<Confection> listInSugarRange = presentAction.chooseInSugarRange(present.getPresentList(), SUGAR_UP, SUGAR_DOWN);
            LOGGER.log(Level.INFO,"Confentions with sugar % between "+SUGAR_DOWN+" and "+SUGAR_UP+": ");
            listInSugarRange.forEach(a -> LOGGER.log(Level.INFO, a));

        } catch (WrongDataException e) {
            LOGGER.log(Level.ERROR, "Impossible to create a present.",e);
        }


    }
}
