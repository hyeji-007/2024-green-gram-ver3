package com.green.greengram.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyFileUtilsTest {
    private final String FILE_DIRECTORY = "D:\\khj\\2024-02\\download\\greengram_ver3";
    private MyFileUtils myFileUtils;

    @BeforeEach
    void setUp() {
        myFileUtils = new MyFileUtils(FILE_DIRECTORY);
    }


    @Test
    void deleteFolder() {
        String path = String.format("%s/user/ddd", myFileUtils.getUploadPath());
        myFileUtils.deleteFolder(path, false);
    }

}