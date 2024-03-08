package com.wikipedia.utils;

import org.awaitility.Awaitility;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileUtility {

    public boolean doesFileExist(File file) {
        try {
            Awaitility.await().atMost(Values.wait, TimeUnit.SECONDS).until(file::exists);
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        }
        return true;
    }
    public void deleteFileIfExist(File file) {
        if (file.exists()) {
            file.delete();
        }
    }


}
