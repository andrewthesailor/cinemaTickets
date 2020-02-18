package com.andrewthesailor.cinemaTickets.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    StringUtil stringUtil = new StringUtil();

    @Test
    void verifyName() {
        Boolean tested = stringUtil.verifyName("Grażyna");
        assertEquals(true,tested);
    }

    @Test
    void verifySurName() {
        Boolean tested = stringUtil.verifySurname("Wisła-Płocka");
        assertEquals(true,tested);
    }
}