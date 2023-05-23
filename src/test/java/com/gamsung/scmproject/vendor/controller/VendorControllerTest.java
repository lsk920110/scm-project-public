package com.gamsung.scmproject.vendor.controller;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class VendorControllerTest {

    @Test
    void dateTimeFormatterTest(){
        String date = "2023-01-01";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(parse);

    }

}