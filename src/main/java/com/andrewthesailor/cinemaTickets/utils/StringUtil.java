package com.andrewthesailor.cinemaTickets.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class StringUtil {
    private Pattern namePattern = Pattern.compile("[A-ZĄŻÓŁĆĘŃ][a-zążółćęń]+");
    private Pattern surnamePattern = Pattern.compile("[A-ZĄŻÓŁĆĘŃ][a-zążółćęń]+(-[A-ZĄŻÓŁĆĘŃ][a-zążółćęń]+)?");

    public Boolean verifyName(String name){
        return namePattern.matcher(name).matches();
    }


    public Boolean verifySurname(String surname){
        return surnamePattern.matcher(surname).matches();
    }

}
