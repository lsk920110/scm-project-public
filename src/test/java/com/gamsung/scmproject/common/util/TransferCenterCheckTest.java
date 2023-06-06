package com.gamsung.scmproject.common.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TransferCenterCheckTest {

    @Test
    void tccheck() {
        String addressFirst = "서울특별시";

        String tc = null;

        if (addressFirst.contains("서울")) {
            tc = "100";
        } else if (addressFirst.contains("경기")) {
            tc = "101";
        } else if (addressFirst.contains("인천")) {
            tc = "102";
        } else if (addressFirst.contains("강원")) {
            tc = "103";
        } else if (addressFirst.contains("충북") || addressFirst.contains("충청북도")) {
            tc = "104";
        } else if (addressFirst.contains("충남") || addressFirst.contains("충청남도")) {
            tc = "105";
        } else if (addressFirst.contains("전북") || addressFirst.contains("전라북도")) {
            tc = "106";
        } else if (addressFirst.contains("전남") || addressFirst.contains("전라남도")) {
            tc = "107";
        } else if (addressFirst.contains("경북") || addressFirst.contains("경상북도")) {
            tc = "108";
        } else if (addressFirst.contains("경남") || addressFirst.contains("경상남도")) {
            tc = "109";
        } else if (addressFirst.contains("제주")) {
            tc = "110";
        }


        assertEquals(tc,"100");
    }


}