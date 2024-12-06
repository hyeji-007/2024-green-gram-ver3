package com.green.greengram.common;

public class CommonUtils {
    public static String randomNickNm(){
        String[] str1 = {"화난 ", "욕하는 ", "안경잽이 ", "못생긴 ", "많이먹는 ", "뚱땅뚱땅 ", "철푸덕 "};
        String[] str2 = {"구수영", "권혜지", "수지", "김우준", "김일지", "류현욱", "사공수기", "장재웅"};

        int randomVal = (int)(Math.random()*str1.length);
        int randomVal2 = (int)(Math.random()*str2.length);

        String nickName = str1[randomVal] + str2[randomVal2];
        return nickName;
    }
}
