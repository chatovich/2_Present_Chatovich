package com.chatovich.present.creator;
import com.chatovich.present.action.PresentAction;
import com.chatovich.present.entity.Confection;
import com.chatovich.present.entity.Present;
import com.chatovich.present.exception.WrongDataException;
import com.chatovich.present.factory.ConfentionFactory;
import com.chatovich.present.factory.DefineConfentionFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class PresentCreator {

    static final Logger LOGGER = LogManager.getLogger(PresentCreator.class);

    public Present createPresent (List<String> presentStringList) throws WrongDataException{

        Confection confection;
        Present present = new Present();
        PresentAction presentAction = new PresentAction();
        PresentParser presentParser = new PresentParser();
        for (String line : presentStringList) {
            try {
                if (line.isEmpty()){
                    LOGGER.log(Level.ERROR, "At line ( "+line+" ): line is empty.");
                    continue;
                }
                List<String> paramList = presentParser.parseByDelimeter(line);
                String name = paramList.get(0);
                int weight = Integer.parseInt(paramList.get(1).trim());
                int kcal = Integer.parseInt(paramList.get(2).trim());
                int sugar = Integer.parseInt(paramList.get(3).trim());
                if (weight<0||kcal<0||sugar<0){
                    LOGGER.log(Level.ERROR, "At line ( "+line+" ): number data couldn't be negative.");
                    continue;
                }
                ConfentionFactory factory = DefineConfentionFactory.defineFactory(presentParser.parseConfentionName(name));
                confection = factory.createConfention(name,weight,kcal,sugar);
                present.addConfention(confection);
                LOGGER.log(Level.INFO, "A confention " + confection + " was created, present size - " + present.getPresentList().size());

            } catch (WrongDataException e) {
                LOGGER.log(Level.ERROR, "At line ( "+line+" ):", e);
            } catch (NumberFormatException e){
                LOGGER.log(Level.ERROR, "At line ( "+line+" ): number data is not valid",e);
            }
        }
        if (!presentAction.isPresentBigEnough(present.getPresentList())){
            throw new WrongDataException("The present is too small, kids are gonna be dissapointed.");
        }
        return present;
    }
}
