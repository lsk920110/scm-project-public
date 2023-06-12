package com.gamsung.scmproject.common.util;

public class TransferCenterCheck {

    public static String tcCheck(String firstAddress) {


        String tc = null;

        if (firstAddress.contains("서울")) {
            tc = "100";
        } else if (firstAddress.contains("경기")) {
            tc = "101";
        } else if (firstAddress.contains("인천")) {
            tc = "102";
        } else if (firstAddress.contains("강원")) {
            tc = "103";
        } else if (firstAddress.contains("충북") || firstAddress.contains("충청북도")) {
            tc = "104";
        } else if (firstAddress.contains("충남") || firstAddress.contains("충청남도")) {
            tc = "105";
        } else if (firstAddress.contains("전북") || firstAddress.contains("전라북도")) {
            tc = "106";
        } else if (firstAddress.contains("전남") || firstAddress.contains("전라남도")) {
            tc = "107";
        } else if (firstAddress.contains("경북") || firstAddress.contains("경상북도")) {
            tc = "108";
        } else if (firstAddress.contains("경남") || firstAddress.contains("경상남도")) {
            tc = "109";
        } else if (firstAddress.contains("제주")) {
            tc = "110";
        } else if (firstAddress.contains("부산")) {
            tc = "111";
        } else if (firstAddress.contains("대구")) {
            tc = "112";
        } else if (firstAddress.contains("울산")) {
            tc = "113";
        } else if (firstAddress.contains("광주")) {
            tc = "114";
        } else if (firstAddress.contains("대전")) {
            tc = "115";
        }

        return tc;
    }


}
