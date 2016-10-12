package com.chatovich.present.creator;

import com.chatovich.present.exception.WrongDataException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yultos_ on 08.10.2016
 */
public class PresentParser {

    final static String DELIMETER = ",";
    final static String CONFENTION_NAME_REGEX = "[a-zA-Z ]+";
    final static String CONFENTION_TYPE_REGEX = "[(]\\s?[a-zA-Z]+\\s?[)]";

    public List<String> parseByDelimeter (String line) throws WrongDataException {
        List<String> list = Arrays.asList(line.split(DELIMETER));
        if (list.size()!=4){
            throw new WrongDataException("There is not enough info for creating a confention.");
        }
        return list;
    }

    public String parseConfentionName(String line){

        Pattern pattern = Pattern.compile(CONFENTION_NAME_REGEX);
        Matcher matcher = pattern.matcher(line);
        String confentionName = "";
        if (matcher.find()){
            confentionName = matcher.group().trim();
        }
        return confentionName;
    }

    public  String parseConfentionType(String line) throws WrongDataException {

        //get type of the confention in  brackets
        Pattern pattern = Pattern.compile(CONFENTION_TYPE_REGEX);
        Matcher matcher = pattern.matcher(line);
        String confentionTypeName = "";
        if (matcher.find()){
            confentionTypeName = matcher.group().trim();
        }
        //get rid of brackets
        pattern = Pattern.compile(CONFENTION_NAME_REGEX);
        matcher = pattern.matcher(confentionTypeName);
        if (matcher.find()){
            confentionTypeName = matcher.group().trim();
        }
        if (confentionTypeName.isEmpty()){
            throw new WrongDataException("The type of confention is not indicated.");
        }

        return confentionTypeName;
    }
}
